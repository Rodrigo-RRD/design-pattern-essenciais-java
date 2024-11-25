package com.pedido_venda_di.bean.impl;

import java.math.BigDecimal;
import java.util.Date;

import com.pedido_venda_di.bean.CalculadoraImposto;
import com.pedido_venda_di.bean.PedidoVendaService;
import com.pedido_venda_di.model.PedidoVenda;
import com.pedido_venda_di.repository.PedidosVendas;

import jakarta.inject.Inject;


public class PedidoVendaServiceImpl implements PedidoVendaService {

	@Inject
	private PedidosVendas pedidosVendas;
	
	@Inject
	private CalculadoraImposto calculadoraImposto;

	@Override
    public void salvar(PedidoVenda pedidoVenda) {
		pedidoVenda.setData(new Date());
		
		BigDecimal imposto = calculadoraImposto.calcular(pedidoVenda.getValor());
		pedidoVenda.setImposto(imposto);
		
		pedidosVendas.salvar(pedidoVenda);
	}

}
