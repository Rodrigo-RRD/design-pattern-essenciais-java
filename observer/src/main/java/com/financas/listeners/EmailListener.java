package com.financas.listeners;

import java.util.List;

import com.financas.model.Lancamento;
import com.financas.notifier.Notificador;

public class EmailListener implements Listener {

    private Notificador notificador;

    public EmailListener(Notificador notificador) {
        this.notificador = notificador;
        this.notificador.registrarListener(this);
    }

    @Override
    public void atualizar() {
        List<Lancamento> lancamentosVencidos = this.notificador.getLancamentosVencidos();
        for (Lancamento lancamento : lancamentosVencidos) {
            System.out.println("Enviando SMS para " + lancamento.getPessoa().getTelefone());
        }
    }

}
