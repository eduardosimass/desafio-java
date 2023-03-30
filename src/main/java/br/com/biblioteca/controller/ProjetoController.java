package br.com.biblioteca.controller;

import br.com.biblioteca.model.Projeto;
import br.com.biblioteca.repository.ProjetoRepository;
import br.com.biblioteca.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/projeto")
public class ProjetoController {

    @Autowired
    private ProjetoRepository repository;
    @Autowired
    private ProjetoService projetoService;

    ProjetoController(ProjetoRepository projetoRepository) {
        this.repository = projetoRepository;
    }

    @CrossOrigin
    @GetMapping("")
    public List < Projeto > listaProjetos() {
        return projetoService.listaProjetos();
    }

    @GetMapping(path = {
            "/{id}"
    })
    public Projeto buscaProjetoPorId(@PathVariable Long id) {
        return projetoService.buscaProjetoPorId(id);
    }

    @PostMapping(value = "/")
    public Projeto create(@RequestBody Projeto projeto) {
        return projetoService.salvarProjeto(projeto);
    }

    @CrossOrigin
    @PutMapping(value = "editar/{id}")
    public Projeto update(@PathVariable("id") Long id, @RequestBody Projeto projeto) {
        return projetoService.alterarProjeto(projeto, id);
    }

    @CrossOrigin
    @DeleteMapping(path = {
            "delete/{id}"
    })
    public ResponseEntity < String > delete(@PathVariable Long id) {
        return projetoService.deleteProjetoPorId(id);
    }
}