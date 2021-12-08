package com.projetoaaalgoritmos.projetoaa.Algoritmos;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import com.projetoaaalgoritmos.projetoaa.Modal.InfomacoesModel;
import com.projetoaaalgoritmos.projetoaa.Repositories.InformacoesRepository;
import com.projetoaaalgoritmos.projetoaa.Uteis.GeradorDeArrays;
import com.projetoaaalgoritmos.projetoaa.Uteis.Informacoes;
import com.projetoaaalgoritmos.projetoaa.Uteis.TiposOrdenacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class Base {

    private Stopwatch relogio;

    @Autowired
    private InformacoesRepository repository;

    public Base(){
        this.relogio = Stopwatch.createUnstarted();
    }

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
        Integer[] tamanhos = {10,100,1000,10000,100000};
        Integer[] vezes = {14, 14, 1, 1};
        TiposOrdenacao[] tipo = {TiposOrdenacao.ALEATORIO,TiposOrdenacao.PERCENTUAL,TiposOrdenacao.CRESCENTE,TiposOrdenacao.DECRESCENTE};
        for(int tamanho:tamanhos){
            for(int i = 0;i < vezes.length;i++){
                salva(tamanho, vezes[i], tipo[i]);
            }
        }
    }
    public void salva(Integer tamanho,Integer vezes,TiposOrdenacao tipo){
        System.out.println("Vetor com Quantidade: " + tamanho);
        System.out.println("Tipo: " + tipo.toString());
        for(int v = 1;v <= vezes;v++){
            System.out.println("Laço: " + v);
            Integer[] arr1 = new GeradorDeArrays().geradorDeArray(tamanho, tipo);
            Informacoes inf = new Informacoes(arr1);
            calcularTempo(inf);
            InfomacoesModel entite = new InfomacoesModel();
            entite.setId(0l);
            entite.setQuantComparacoes(inf.getQuantComparacoes());
            entite.setQuantidadeMovimentosRegistros(inf.getQuantidadeMovimentosRegistros());
            entite.setTempo(inf.getTempo());
            entite.setSizeVetor(inf.getVetor().length+1);
            entite.setTipoDeOrdenacao(tipo);
            entite.setAlgoritmoName(this.getClass().getSimpleName());
            repository.save(entite);
        }
    }
}
