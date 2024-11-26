package com.pagamento_abstract_factory.gestorderisco.clearsale;

import java.math.BigDecimal;

import com.pagamento_abstract_factory.gestorderisco.AlertaDeRiscoException;
import com.pagamento_abstract_factory.gestorderisco.GestorDeRisco;

public class ClearSale implements GestorDeRisco {

	@Override
	public void avaliarRisco(String cartao, BigDecimal valor) throws AlertaDeRiscoException {
		if (cartao.startsWith("1111") && valorMuitoAlto(valor)) {
			throw new AlertaDeRiscoException("Valor muito alto para esse cartão");
		}
	}

	private boolean valorMuitoAlto(BigDecimal valor) {
		BigDecimal limite = new BigDecimal("5000");
		return limite.compareTo(valor) < 0;
	}

}
