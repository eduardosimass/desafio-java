package br.com.biblioteca.service;
import br.com.biblioteca.model.Projeto;
import br.com.biblioteca.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {
    @Autowired
    private ProjetoRepository projetoRepository;

    public List < Projeto > listaProjetos() {
        return projetoRepository.findAll();
    }
    public Projeto buscaProjetoPorId(Long id) {
        return projetoRepository.findById(id).orElse(null);
    }
    public Projeto salvarProjeto(Projeto projeto) {
        return projetoRepository.save(projeto);
    }
    public Projeto alterarProjeto(Projeto projeto, Long id) {
        return projetoRepository.findById(id)
                .map(toRecord -> {
                    toRecord.setNome(projeto.getNome());
                    toRecord.setDataInicio(projeto.getDataInicio());
                    toRecord.setDataPrevisaoFim(projeto.getDataPrevisaoFim());
                    toRecord.setDataFim(projeto.getDataFim());
                    toRecord.setOrcamento(projeto.getOrcamento());
                    toRecord.setDescricao(projeto.getDescricao());
                    toRecord.setStatus(projeto.getStatus());
                    toRecord.setRisco(projeto.getRisco());
                    Projeto updated = projetoRepository.save(toRecord);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build()).getBody();
    }
    public ResponseEntity < String > deleteProjetoPorId(Long id) {
        Optional < Projeto > projetoOptional = projetoRepository.findById(id);
        if (projetoOptional.isPresent()) {
            Projeto projeto = projetoOptional.get();
            if (projeto.getStatus().equals("iniciado") || projeto.getStatus().equals("em andamento") || projeto.getStatus().equals("encerrado")) {
                return ResponseEntity.badRequest().body("O projeto já foi iniciado, está em andamento ou foi encerrado! Verifique!");
            } else {
                projetoRepository.deleteById(id);
                return ResponseEntity.ok("Projeto Excluido com sucesso");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}