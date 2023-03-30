package br.com.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Membro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String idprojeto;
    private String idpessoa;



}