package com.projetoaaalgoritmos.projetoaa.Algoritmos;

import java.util.Arrays;

import com.projetoaaalgoritmos.projetoaa.Uteis.GeradorDeArrays;
import com.projetoaaalgoritmos.projetoaa.Uteis.Informacoes;
import com.projetoaaalgoritmos.projetoaa.Uteis.TiposOrdenacao;

import org.springframework.stereotype.Service;

@Service
public class QuickSort extends Base{

    @Override
    protected void roda(Informacoes inf) {
        sort(inf, 0, inf.getVetor().length-1);
    }

    protected int partition(Informacoes inf, int low, int high){
        int pivot = inf.getVetor()[high];
        inf.adicionarMovimentosDeRegistros(1);
        int i = (low-1);
        for (int j=low; j<high; j++){

            if (inf.getVetor()[j] <= pivot){
                inf.adicionarComparacoes(1);
                i++;

                int temp = inf.getVetor()[i];
                inf.getVetor()[i] = inf.getVetor()[j];
                inf.getVetor()[j] = temp;
                inf.adicionarMovimentosDeRegistros(3);
            }
        }

        int temp = inf.getVetor()[i+1];
        inf.getVetor()[i+1] = inf.getVetor()[high];
        inf.getVetor()[high] = temp;
        inf.adicionarMovimentosDeRegistros(3);
  
        return i+1;
    }
  
    protected void sort(Informacoes inf, int low, int high){
        if (low < high){
            int pi = partition(inf, low, high);

            sort(inf, low, pi-1);
            sort(inf, pi+1, high);
        }
    }

    public static void main(String[] args) {
        Integer[] v = new GeradorDeArrays().geradorDeArray(10, TiposOrdenacao.ALEATORIO);

        System.out.println(Arrays.toString(v));
        new QuickSort().roda(new Informacoes(v));
        System.out.println(Arrays.toString(v));
    }
}
