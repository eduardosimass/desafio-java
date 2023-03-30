package br.com.biblioteca.controller;

import br.com.biblioteca.model.Pessoa;
import br.com.biblioteca.repository.PessoaRepository;
import br.com.biblioteca.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping({
        "/pessoa"
})
public class PessoaController {

    private PessoaRepository repository;
    PessoaController(PessoaRepository pessoaRepository) {
        this.repository = pessoaRepository;
    }
    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public List < Pessoa > listaPessoas() {
        return pessoaService.listaPessoas();
    }

    @GetMapping(path = {
            "busca/{id}"
    })
    public Pessoa buscaPessoaPorId(@PathVariable Long id) {
        return pessoaService.buscaPessoaPorId(id);
    }

    @PostMapping
    public Pessoa create(@RequestBody Pessoa pessoa) {
        return pessoaService.salvarPessoa(pessoa);
    }

    @PutMapping(value = "editar/{id}")
    public Pessoa update(@PathVariable("id") Long id, @RequestBody Pessoa pessoa) {
        return pessoaService.alterarPessoa(pessoa, id).getBody();
    }

    @DeleteMapping(path = {
            "delete/{id}"
    })
    public ResponseEntity delete(@PathVariable Long id) {
        return pessoaService.deletePessoaPorId(id);
    }
}