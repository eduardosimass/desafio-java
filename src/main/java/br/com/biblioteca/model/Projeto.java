package br.com.biblioteca.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dataInicio;
    private String dataPrevisaoFim;
    private String dataFim;
    private String descricao;
    private String status;
    private String orcamento;
    private String risco;
    @ManyToOne
    @JoinColumn(name = "idgerente")
    private Pessoa idGerente;


    public Projeto(Long id, String nome, String dataInicio, String dataPrevisaoFim, String dataFim, String descricao, String status, String orcamento, String risco) {

    }
}