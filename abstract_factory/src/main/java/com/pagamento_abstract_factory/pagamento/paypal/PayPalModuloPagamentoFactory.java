package com.pagamento_abstract_factory.pagamento.paypal;

import com.pagamento_abstract_factory.gestorderisco.GestorDeRisco;
import com.pagamento_abstract_factory.gestorderisco.clearsale.ClearSale;
import com.pagamento_abstract_factory.operadora.Operadora;
import com.pagamento_abstract_factory.operadora.redecard.Redecard;
import com.pagamento_abstract_factory.pagamento.ModuloPagamentoFactory;

public class PayPalModuloPagamentoFactory implements ModuloPagamentoFactory {

	@Override
    public Operadora criarOperadora() {
	    return new Redecard();
    }

	@Override
    public GestorDeRisco criarGestorDeRisco() {
	    return new ClearSale();
    }

}
