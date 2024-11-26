package com.cobranca.service;

import com.cobranca.model.CartaoCredito;
import com.cobranca.model.Cliente;

public interface AutorizadorCartaoCredito {
    public void autorizar(Cliente cliente, CartaoCredito cartaoCredito, double valor);
}
