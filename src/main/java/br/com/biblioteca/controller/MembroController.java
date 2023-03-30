package br.com.biblioteca.controller;

import br.com.biblioteca.model.Membro;
import br.com.biblioteca.repository.MembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/associacoes")
public class MembroController {

    @Autowired
    private MembroRepository membroRepository;

    @PostMapping
    public ResponseEntity < Membro > criarAssociacao(@RequestBody Membro membro) {
        Membro novoMembro = membroRepository.save(membro);
        return ResponseEntity.ok(novoMembro);
    }

    @PutMapping("/{idprojeto}/{idpessoa}/")
    public ResponseEntity < Membro > SalvarDados(@PathVariable Long idprojeto, @PathVariable Long idpessoa, @RequestBody Membro membro) {
        Membro membroAtualizado = membroRepository.save(membro);
        return ResponseEntity.ok(membroAtualizado);
    }

}