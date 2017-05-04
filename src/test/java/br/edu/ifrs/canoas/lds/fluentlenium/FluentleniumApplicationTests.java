package br.edu.ifrs.canoas.lds.fluentlenium;


import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.assertj.FluentLeniumAssertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.with;

import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.core.hook.wait.Wait;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@Wait
public class FluentleniumApplicationTests extends FluentTest{
	
	@Value("${local.server.port}") int port;
	String getHost(){return "http://localhost:"+ port+ "/protot/index2.html";}
		
	@Test
    public void abre_datatable_e_verifica_resultado_da_datatable_pela_busca_por_Camino() {
		//Vai para http://localhost:"+ port+ "/protot/index2.html
        goTo(getHost());        
        //Verifica que o título da página é da Dashboard
        assertThat(window().title()).isEqualTo("AdminLTE 2 | Dashboard");
        //Clica no link table
        $("#link-tables").click();
        //Clica no link datatable
        $("#link-datatable").click();
        //Verifica que o título da página agora é do Datatables
        assertThat(window().title()).isEqualTo("AdminLTE 2 | Data Tables");
        //procura o campo search da datatable e preenche com Camino
        $(".input-sm").fill().with("Camino");
        //Verifica que o resultado da tabela apresenta 1 de 2 entradas.
        assertThat($(".dataTables_info")).hasText("Showing 1 to 2 of 2 entries (filtered from 57 total entries)");
    }
	
	@Test
    public void abre_hover_table_na_pagina_5_e_verifica_element_Presto() {
		//abrir a página inicial
        goTo(getHost());        
        //verifica que o título é Dashboard
        assertThat(window().title()).isEqualTo("AdminLTE 2 | Dashboard");
        //Clica em Table
        $("#link-tables").click();
        //Clica em Datatable
        $("#link-datatable").click();
        //Verifica que o título é Datatables
        assertThat(window().title()).isEqualTo("AdminLTE 2 | Data Tables");
        //Verifica que o primeiro elemento é Gecko na tabela
        assertThat(el("td")).hasText("Gecko");
        //Clica no link cujo atributo data-dt-idx tem valor 5
        el("a", with("data-dt-idx").startsWith("5")).click();
        //verifica que o primeiro elemento cujo estilo é sorting_1 tem o texto Presto
        assertThat(el("td")).hasText("Presto");
        //Verifica que não tem mais o elemento Gecko na tabela
        assertThat(el("td")).hasNotText("Gecko");
    }
	
}