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
	String getHost(){return "????";}
		
	@Test
    public void abre_datatable_e_verifica_resultado_da_datatable_pela_busca_por_Camino() {
		//Vai para http://localhost:"+ port+ "/protot/index2.html
        goTo(getHost());        
        //Verifica que o título da página é da Dashboard
        assertThat(window().title()).isEqualTo("AdminLTE 2 | Dashboard");
        //Clica no link table
        
        //Clica no link datatable
        $("#link-datatable").click();
        //Verifica que o título da página agora é do Datatables
        
        //procura o campo search da datatable e preenche com Camino
        
        //Verifica que o resultado da tabela apresenta 1 de 2 entradas.
        
    }
	
	@Test
    public void abre_hover_table_na_pagina_5_e_verifica_element_Presto() {
		//abrir a página inicial
                
        //verifica que o título é Dashboard
        
        //Clica em Table
        
        //Clica em Datatable
        
        //Verifica que o título é Datatables
        
        //Verifica que o primeiro elemento é Gecko na tabela
        assertThat(el("td")).hasText("Gecko");
        //Clica no link cujo atributo data-dt-idx tem valor 5
        el("a", with("data-dt-idx").startsWith("5")).click();
        //verifica que o primeiro elemento cujo estilo é sorting_1 tem o texto Presto
        
        //Verifica que não tem mais o elemento Gecko na tabela
        
    }
	
}