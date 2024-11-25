package com.transportadora.service;

import com.transportadora.util.Frete;

public class Sedex implements Frete {

    public double calcularPreco(int distancia) {
        return distancia * 1.45 + 12;
    }

}
