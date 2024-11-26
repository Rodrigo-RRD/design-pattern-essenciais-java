package com.pagamento_abstract_factory.pagamento;

import java.math.BigDecimal;

import com.pagamento_abstract_factory.AlertaDeRiscoException;
import com.pagamento_abstract_factory.GestorDeRisco;
import com.pagamento_abstract_factory.operadora.CapturaNaoAutorizadaException;
import com.pagamento_abstract_factory.operadora.Operadora;

public class Pagamento {

    private Operadora operadora;
    private GestorDeRisco gestorDeRisco;

    public Pagamento(ModuloPagamentoFactory moduloPagamentoFactory) {
        this.operadora = moduloPagamentoFactory.criarOperadora();
        this.gestorDeRisco = (GestorDeRisco) moduloPagamentoFactory.criarGestorDeRisco();
    }

    public Long autorizar(String cartao, BigDecimal valor)
            throws CapturaNaoAutorizadaException, AlertaDeRiscoException {
        this.operadora.capturar(cartao, valor);
        this.gestorDeRisco.avaliarRisco(cartao, valor);
        return this.operadora.confirmar();
    }

}
