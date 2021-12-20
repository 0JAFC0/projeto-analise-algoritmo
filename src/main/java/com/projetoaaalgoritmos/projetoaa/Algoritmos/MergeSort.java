package com.projetoaaalgoritmos.projetoaa.Algoritmos;

import java.util.Arrays;

import com.projetoaaalgoritmos.projetoaa.Uteis.GeradorDeArrays;
import com.projetoaaalgoritmos.projetoaa.Uteis.Informacoes;
import com.projetoaaalgoritmos.projetoaa.Uteis.TiposOrdenacao;

import org.springframework.stereotype.Service;

@Service
public class MergeSort extends Base{

    @Override
    protected void roda(Informacoes inf) {
        sort(inf, 0, inf.getVetor().length-1);
    }

    protected void merge(Informacoes inf, int l, int m, int r){
        int n1 = m - l + 1;
        int n2 = r - m;
 
        int L[] = new int [n1];
        int R[] = new int [n2];
 
        for (int i=0; i<n1; ++i){
            L[i] = inf.getVetor()[l + i];
            inf.adicionarMovimentosDeRegistros(1);
        }
        for (int j=0; j<n2; ++j){
            R[j] = inf.getVetor()[m + 1+ j];
            inf.adicionarMovimentosDeRegistros(1);
        }
 
        int i = 0, j = 0;
 
        int k = l;
        while (i < n1 && j < n2){
            inf.adicionarComparacoes(1);
            if (L[i] <= R[j]){
                inf.getVetor()[k] = L[i];
                inf.adicionarMovimentosDeRegistros(1);
                i++;
            }
            else{
                inf.getVetor()[k] = R[j];
                inf.adicionarMovimentosDeRegistros(1);
                j++;
            }
            k++;
        }

        while (i < n1){
            inf.getVetor()[k] = L[i];
            inf.adicionarMovimentosDeRegistros(1);
            i++;
            k++;
        }

        while (j < n2){
            inf.getVetor()[k] = R[j];
            inf.adicionarMovimentosDeRegistros(1);
            j++;
            k++;
        }
    }



    protected void sort(Informacoes inf, int l, int r){
        if (l < r){
            int m = (l+r)/2;
 
            sort(inf, l, m);
            sort(inf , m+1, r);
 
            merge(inf, l, m, r);
        }
    }
    
    public static void main(String[] args) {
        Integer[] v = new GeradorDeArrays().geradorDeArray(10, TiposOrdenacao.ALEATORIO);

        System.out.println(Arrays.toString(v));
        new MergeSort().roda(new Informacoes(v));
        System.out.println(Arrays.toString(v));
    }
}
