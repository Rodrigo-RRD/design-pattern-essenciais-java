package com.pedido_venda_di.bean.impl;

import java.math.BigDecimal;

import com.pedido_venda_di.bean.CalculadoraImposto;

public class CalculadoraImpostoImpl implements CalculadoraImposto {

    @Override
    public BigDecimal calcular(BigDecimal valor) {
        return valor.multiply(new BigDecimal("0.15"));
    }

}
