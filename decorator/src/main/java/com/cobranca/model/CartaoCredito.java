package com.cobranca.model;

import java.time.YearMonth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartaoCredito {
    private String numero;
    private String nome;
    private YearMonth vencimento;
    private int codigoSeguranca;

    public CartaoCredito(String numero, String nome, YearMonth vencimento,
            int codigoSeguranca) {
        this.numero = numero;
        this.nome = nome;
        this.vencimento = vencimento;
        this.codigoSeguranca = codigoSeguranca;
    }

    @Override
    public String toString() {
        return "CartaoCredito [numero=" + numero + ", nome=" + nome
                + ", vencimento=" + vencimento + ", codigoSeguranca="
                + codigoSeguranca + "]";
    }

}
