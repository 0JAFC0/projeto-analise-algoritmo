package com.projetoaa.Algoritmos;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import com.projetoaa.Uteis.GeradorDeArrays;
import com.projetoaa.Uteis.TiposOrdenacao;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Base {

    private Informacoes informacoes;

    private Stopwatch relogio;

    private void restartTime(){
        relogio = Stopwatch.createUnstarted();
    }

    protected abstract void roda(Informacoes inf);

    protected void calcularTempo(Informacoes inf){
        relogio.start();
        roda(inf);
        relogio.stop();
        inf.setTempo(relogio.elapsed(TimeUnit.MICROSECONDS));
        restartTime();
    }

    public void rodarAlgoritmo(){
        Integer[] tamanhos = {10, 100, 1000, 10000, 100000};
        for(int tamanho:tamanhos){
            System.out.println("Vetor com Quantidade: " + tamanho);
            System.out.println("Aleatorio:");
            for(int vezes = 0;vezes < 14;vezes++){
                System.out.println("Laço: " + vezes);
                Integer[] arr1 = new GeradorDeArrays().geradorDeArray(tamanho, TiposOrdenacao.ALEATORIO);
                Informacoes inf = new Informacoes(arr1);
                calcularTempo(inf);
            }
            
            System.out.println("Percentual:");
            for(int vezes = 0;vezes < 14;vezes++){
                System.out.println("Laço: " + vezes);
                Integer[] arr1 = new GeradorDeArrays().geradorDeArray(tamanho, TiposOrdenacao.PERCENTUAL);
                Informacoes inf = new Informacoes(arr1);
                calcularTempo(inf);
            }

            System.out.println("Crescente:");
            Integer[] arr1 = new GeradorDeArrays().geradorDeArray(tamanho, TiposOrdenacao.CRESCENTE);
            Informacoes inf1 = new Informacoes(arr1);
            calcularTempo(inf1);
            
            System.out.println("Decrescente:");
            Integer[] arr2 = new GeradorDeArrays().geradorDeArray(tamanho, TiposOrdenacao.DECRESCENTE);
            Informacoes inf2 = new Informacoes(arr2);
            calcularTempo(inf2);         
        }
    }
}
