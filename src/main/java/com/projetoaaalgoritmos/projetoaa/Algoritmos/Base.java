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

// codigo do Serviço que vai ser herdado pelos algoritmos de ordenação
@Service
public abstract class Base {

    // atributo que contabiliza o tempo
    private Stopwatch relogio;

    // repository responsavel por salvar no banco
    @Autowired
    private InformacoesRepository repository;

    public Base(){
        this.relogio = Stopwatch.createUnstarted();
    }

    // reinicia o tempo do relogio
    private void restartTime(){
        relogio = Stopwatch.createUnstarted();
    }

    // metodo abstrato que é sobrescrito nos algoritmos
    protected abstract void roda(Informacoes inf);

    // metodo responsavel por iniciar o tempo e chamar o restartTime
    protected void calcularTempo(Informacoes inf){
        relogio.start();
        roda(inf);
        relogio.stop();
        inf.setTempo(relogio.elapsed(TimeUnit.MICROSECONDS));
        restartTime();
    }

    // metodo responsavel por chamar o metodo calculaTempo e 
    // rodar todos os tamanhos de vetores e a quantidade de vezes.
    public void rodarAlgoritmo(){
        Integer[] tamanhos = {1000000}; // aqui é a lista de tamanhos dos vetores.
        //{10,100,1000,10000,100000};
        Integer[] vezes = {3,3,1,1}; // tem que trocar a quantidade de vezes caso queira mais vezes de cada
        //{14, 14, 1, 1};
        //{3,3,1,1} // exemplos de listas para serem substituidas na variavel vezes
        TiposOrdenacao[] tipo = {TiposOrdenacao.ALEATORIO,TiposOrdenacao.PERCENTUAL,TiposOrdenacao.CRESCENTE,TiposOrdenacao.DECRESCENTE};
        for(int tamanho:tamanhos){
            for(int i = 0;i < vezes.length;i++){
                salva(tamanho, vezes[i], tipo[i]);
            }
        }
    }

    // Metodo printa no console algumas informações e salva no banco as informacoes uteis
    public void salva(Integer tamanho,Integer vezes,TiposOrdenacao tipo){
        System.out.println("Vetor com Quantidade: " + tamanho);
        System.out.println("Tipo: " + tipo.toString());
        System.out.println(this.getClass().getSimpleName());
        for(int v = 1;v <= vezes;v++){
            System.out.println("Laço: " + v);
            // Parte que gera o vetor
            Integer[] arr1 = new GeradorDeArrays().geradorDeArray(tamanho, tipo);
            Informacoes inf = new Informacoes(arr1);
            calcularTempo(inf);
            // Parte que seta as informacoes no Model e depois salva no banco
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
