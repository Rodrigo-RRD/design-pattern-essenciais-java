package com.maladireta.contato;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Contato {
    private String nome;
    private String email;

    public Contato(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
}
