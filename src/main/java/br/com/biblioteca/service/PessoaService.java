package br.com.biblioteca.service;
import br.com.biblioteca.model.Pessoa;
import br.com.biblioteca.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PessoaService {
    @Autowired
    PessoaRepository pessoaRepository;
    public List < Pessoa > listaPessoas() {
        return pessoaRepository.findAll();
    }
    public Pessoa buscaPessoaPorId(Long id) {
        return pessoaRepository.findById(id).orElse(null);
    }
    public Pessoa salvarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
    public ResponseEntity < Pessoa > alterarPessoa(Pessoa pessoa, Long id) {
        return pessoaRepository.findById(id)
                .map(toRecord -> {
                    toRecord.setNome(pessoa.getNome());
                    toRecord.setCpf(pessoa.getCpf());
                    toRecord.setDataNascimento(pessoa.getDataNascimento());
                    toRecord.setFuncionario(pessoa.getFuncionario());
                    Pessoa updated = pessoaRepository.save(toRecord);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }
    public ResponseEntity < ? > deletePessoaPorId(Long id) {
        return pessoaRepository.findById(id)
                .map(toRecord -> {
                    pessoaRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}