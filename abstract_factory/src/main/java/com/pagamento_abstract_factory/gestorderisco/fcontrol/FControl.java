package com.pagamento_abstract_factory.gestorderisco.fcontrol;

import java.math.BigDecimal;

import com.pagamento_abstract_factory.gestorderisco.AlertaDeRiscoException;
import com.pagamento_abstract_factory.gestorderisco.GestorDeRisco;

public class FControl implements GestorDeRisco {

	@Override
	public void avaliarRisco(String cartao, BigDecimal valor) throws AlertaDeRiscoException {
		if (cartao.startsWith("7777")) {
			throw new AlertaDeRiscoException("Cartão suspeito.");
		}
    }

}
