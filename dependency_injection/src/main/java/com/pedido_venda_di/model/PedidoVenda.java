package com.pedido_venda_di.model;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoVenda {
    private String descricao;
    private BigDecimal valor;
    private BigDecimal imposto;
    private Date data;

    public PedidoVenda(String descricao, BigDecimal valor) {
        this.descricao = descricao;
        this.valor = valor;
    }
}
