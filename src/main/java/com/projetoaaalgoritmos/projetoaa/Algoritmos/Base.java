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
        Integer[] tamanhos = {10, 100, 1000, 10000, 100000};
        for(int tamanho:tamanhos){
            System.out.println("Vetor com Quantidade: " + tamanho);
            System.out.println("Aleatorio:");
            for(int vezes = 0;vezes < 14;vezes++){
                System.out.println("Laço: " + vezes);
                Integer[] arr1 = new GeradorDeArrays().geradorDeArray(tamanho, TiposOrdenacao.ALEATORIO);
                Informacoes inf = new Informacoes(arr1);
                calcularTempo(inf);
                InfomacoesModel entite = new InfomacoesModel();
                entite.setId(1l);
                entite.setQuantComparacoes(inf.getQuantComparacoes());
                entite.setQuantidadeMovimentosRegistros(inf.getQuantidadeMovimentosRegistros());
                entite.setTempo(inf.getTempo());
                entite.setTipoDeOrdenacao(inf.getTipoDeOrdenacao());
                entite.setSizeVetor(inf.getSizeVetor());
                entite.setTipoDeOrdenacao(TiposOrdenacao.ALEATORIO);
                entite.setAlgoritmoName(inf.getAlgoritmoName());
                repository.save(entite);
            }
            
            System.out.println("Percentual:");
            for(int vezes = 0;vezes < 14;vezes++){
                System.out.println("Laço: " + vezes);
                Integer[] arr1 = new GeradorDeArrays().geradorDeArray(tamanho, TiposOrdenacao.ALEATORIO);
                Informacoes inf = new Informacoes(arr1);
                calcularTempo(inf);
                InfomacoesModel entite = new InfomacoesModel();
                entite.setId(1l);
                entite.setQuantComparacoes(inf.getQuantComparacoes());
                entite.setQuantidadeMovimentosRegistros(inf.getQuantidadeMovimentosRegistros());
                entite.setTempo(inf.getTempo());
                entite.setTipoDeOrdenacao(inf.getTipoDeOrdenacao());
                entite.setSizeVetor(inf.getSizeVetor());
                entite.setTipoDeOrdenacao(TiposOrdenacao.ALEATORIO);
                entite.setAlgoritmoName(inf.getAlgoritmoName());
                repository.save(entite);
            }

            System.out.println("Crescente:");
            Integer[] arr1 = new GeradorDeArrays().geradorDeArray(tamanho, TiposOrdenacao.CRESCENTE);
            Informacoes inf1 = new Informacoes(arr1);
            InfomacoesModel entite = new InfomacoesModel();
            entite.setQuantComparacoes(inf1.getQuantComparacoes());
            entite.setQuantidadeMovimentosRegistros(inf1.getQuantidadeMovimentosRegistros());
            entite.setTempo(inf1.getTempo());
            entite.setTipoDeOrdenacao(inf1.getTipoDeOrdenacao());
            entite.setSizeVetor(inf1.getSizeVetor());
            repository.save(entite);
            calcularTempo(inf1);
            
            System.out.println("Decrescente:");
            Integer[] arr2 = new GeradorDeArrays().geradorDeArray(tamanho, TiposOrdenacao.DECRESCENTE);
            Informacoes inf2 = new Informacoes(arr2);
            entite = new InfomacoesModel();
            entite.setQuantComparacoes(inf2.getQuantComparacoes());
            entite.setQuantidadeMovimentosRegistros(inf2.getQuantidadeMovimentosRegistros());
            entite.setTempo(inf2.getTempo());
            entite.setTipoDeOrdenacao(inf2.getTipoDeOrdenacao());
            entite.setSizeVetor(inf2.getSizeVetor());
            repository.save(entite);
            calcularTempo(inf2);         
        }
    }
}
