package com.pedido_venda_di.bean;

import java.math.BigDecimal;

public interface CalculadoraImposto {
    public BigDecimal calcular(BigDecimal valor);
}
