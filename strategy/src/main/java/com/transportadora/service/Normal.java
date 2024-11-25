package com.transportadora.service;

import com.transportadora.util.Frete;

public class Normal implements Frete {

    @Override
    public double calcularPreco(int distancia) {
        return distancia * 1.25 + 10;
    }

}
