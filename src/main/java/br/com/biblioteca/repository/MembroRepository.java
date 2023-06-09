package br.com.biblioteca.repository;

import br.com.biblioteca.model.Membro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembroRepository extends JpaRepository < Membro, Long > {

}