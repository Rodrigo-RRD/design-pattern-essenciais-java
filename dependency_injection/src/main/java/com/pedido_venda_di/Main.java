package com.pedido_venda_di;

import java.math.BigDecimal;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import com.pedido_venda_di.bean.PedidoVendaService;
import com.pedido_venda_di.model.PedidoVenda;

public class Main {
    public static void main(String[] args) {
        try (WeldContainer container = new Weld().initialize()) {
            PedidoVendaService service = container.select(PedidoVendaService.class).get();
            PedidoVenda pedidoVenda = new PedidoVenda("sabonete", new BigDecimal("3.00"));
            service.salvar(pedidoVenda);
            System.out.println("Pedido salvo com sucesso.");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erro ao salvar o pedido.");
        }
    }
}