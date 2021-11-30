package com.projetoaa.Algoritmos;

import com.google.common.base.Stopwatch;

public abstract class Base {

    private Stopwatch relogio;
    
    public Base(){
        relogio = Stopwatch.createUnstarted();
    }

    public abstract void roda(Informacoes inf);

    public void calcularTempo(Informacoes inf){
        relogio.start();
        roda(inf);
        relogio.stop();
    }
}
