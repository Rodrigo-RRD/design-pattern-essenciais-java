package com.financas.notifier;

import java.util.List;

import com.financas.listeners.Listener;
import com.financas.model.Lancamento;

public interface Notificador {

    public void registrarListener(Listener listener);

    public void removerListener(Listener listener);

    public void notificarListeners();

    public void novosLancamentosVencidos(List<Lancamento> lancamentosVencidos);

    public List<Lancamento> getLancamentosVencidos();

}
