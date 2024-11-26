package com.pagamento_abstract_factory.pagamento.pagseguro;

import com.pagamento_abstract_factory.gestorderisco.fcontrol.FControl;
import com.pagamento_abstract_factory.operadora.Operadora;
import com.pagamento_abstract_factory.operadora.cielo.Cielo;
import com.pagamento_abstract_factory.pagamento.ModuloPagamentoFactory;

public class PagSeguroModuloPagamentoFactory implements ModuloPagamentoFactory {

    @Override
    public Operadora criarOperadora() {
        return new Cielo();
    }

    @Override
    public com.pagamento_abstract_factory.gestorderisco.GestorDeRisco criarGestorDeRisco() {
        return new FControl();
    }

}
