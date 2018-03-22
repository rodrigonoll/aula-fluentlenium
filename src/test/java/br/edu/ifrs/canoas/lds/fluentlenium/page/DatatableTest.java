package br.edu.ifrs.canoas.lds.fluentlenium.page;


import br.edu.ifrs.canoas.lds.fluentlenium.test.DatatablePage;
import br.edu.ifrs.canoas.lds.fluentlenium.test.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.configuration.FluentConfiguration;
import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.core.hook.wait.Wait;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.assertj.FluentLeniumAssertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.with;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Wait
@FluentConfiguration(webDriver="chrome")
public class DatatableTest extends FluentTest {

    @LocalServerPort
    protected int port;

    @Page
    HomePage homePage;

    @Page
    DatatablePage datatablePage;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void checkEnterHomePage_navigateToDatatable_searchByCamino() {
        //Given: está para página index
        homePage.go(port);
        homePage.isAt();

        //When: clica em table, datatable e preenche Camino no botão search
        homePage.getLinkTable().click();
        homePage.getLinkDatatable().click();
        datatablePage.isAt();
        datatablePage.getSearch().fill().with("Camino");

        //Then: deve ter 2 retornos para consulta
        assertThat($(".dataTables_info").last().text().equalsIgnoreCase(
                "Showing 1 to 2 of 2 entries (filtered from 57 total entries)"));
    }


    @Test
    public void abre_hover_table_na_pagina_5_e_verifica_element_Presto() {
        //Given: está na página da datatable
        datatablePage.go(port);
        datatablePage.isAt();

        //When: clica no navegador 5 da tabela
        el("a", with("data-dt-idx").startsWith("5")).click();

        //Then: verifica que aparece na tabela o texto Presto e não aparece Gecko
        assertThat(el("td")).hasText("Presto");
        assertThat(el("td")).hasNotText("Gecko");

    }
}


