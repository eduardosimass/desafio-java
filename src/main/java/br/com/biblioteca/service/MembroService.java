package br.com.biblioteca.service;

import br.com.biblioteca.model.Membro;
import br.com.biblioteca.repository.MembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembroService {
    @Autowired
    MembroRepository membroRepository;
    public Membro SalvarDados(Membro membro){
        return membroRepository.save(new Membro());
    }

}
