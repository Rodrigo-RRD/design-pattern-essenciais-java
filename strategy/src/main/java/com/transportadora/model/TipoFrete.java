package com.transportadora.model;

import com.transportadora.service.Normal;
import com.transportadora.service.Sedex;
import com.transportadora.util.Frete;

public enum TipoFrete {

    NORMAL {

        @Override
        public Frete obterFrete() {
            return new Normal();
        }
    },
    SEDEX {
        @Override
        public Frete obterFrete() {
            return new Sedex();
        }
    };

    public abstract Frete obterFrete();
}
