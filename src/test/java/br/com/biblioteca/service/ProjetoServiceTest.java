package br.com.biblioteca.service;
import br.com.biblioteca.model.Projeto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProjetoTest {


    @Test
    void salvarProjeto() {


        Long id = 1L;
        String nome = "Projeto 1";
        String dataInicio = "01/01/2022";
        String dataPrevisaoFim = "31/12/2022";
        String dataFim = null;
        String descricao = "Descrição do Projeto 1";
        String status = "Em Andamento";
        String orcamento = "100000.00";
        String risco = "Alto";

        Projeto projeto;
        projeto = new Projeto(id, nome, dataInicio, dataPrevisaoFim, dataFim, descricao, status, orcamento, risco);

        assertEquals(id, projeto.getId());
        assertEquals(nome, projeto.getNome());
        assertEquals(dataInicio, projeto.getDataInicio());
        assertEquals(dataPrevisaoFim, projeto.getDataPrevisaoFim());
        Assertions.assertNull(projeto.getDataFim());
        assertEquals(descricao, projeto.getDescricao());
        assertEquals(status, projeto.getStatus());
        assertEquals(orcamento, projeto.getOrcamento());
        assertEquals(risco, projeto.getRisco());
    }

}