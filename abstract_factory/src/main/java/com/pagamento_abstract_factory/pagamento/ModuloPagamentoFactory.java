package com.pagamento_abstract_factory.pagamento;

import com.pagamento_abstract_factory.operadora.Operadora;

public interface ModuloPagamentoFactory {

	public Operadora criarOperadora();
	public com.pagamento_abstract_factory.gestorderisco.GestorDeRisco criarGestorDeRisco();
	
}
