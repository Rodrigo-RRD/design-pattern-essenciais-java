package com.pedido_venda;

import java.math.BigDecimal;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoVenda {
    private String numero;
    private Cliente cliente;
    private List<ItemPedido> itensPedido;

    public BigDecimal getValorTotal() {
        BigDecimal valorTotal = BigDecimal.ZERO;
        for (ItemPedido item : itensPedido) {
            valorTotal = valorTotal.add(item.getValorUnitario().multiply(new BigDecimal(item.getQuantidade())));
        }

        // Se cliente vip dar 4% de desconto
        if (cliente.isVip()) {
            valorTotal = valorTotal.multiply(new BigDecimal("0.96"));
        }

        return valorTotal;
    }
}
