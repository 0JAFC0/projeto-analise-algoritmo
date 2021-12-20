package com.projetoaaalgoritmos.projetoaa.Algoritmos;

import java.util.Arrays;

import com.projetoaaalgoritmos.projetoaa.Uteis.GeradorDeArrays;
import com.projetoaaalgoritmos.projetoaa.Uteis.Informacoes;
import com.projetoaaalgoritmos.projetoaa.Uteis.TiposOrdenacao;

import org.springframework.stereotype.Service;

@Service
public class QuickSort extends Base {

    @Override
    protected void roda(Informacoes inf) {
        quickSort(inf, inf.getVetor().length);
    }

    public void quickSort(Informacoes inf,final int size) {
        int l = 0;
        int r = size - 1;
        int q, i = 0;
        int tmpr = r;
        while (true) {
            i--;
            while (l < tmpr) {
                q = partition(inf,l, tmpr);
                inf.getVetor()[tmpr] = -inf.getVetor()[tmpr];
                inf.adicionarMovimentosDeRegistros(1);
                tmpr = q - 1;
                ++i;
            }
            if (i < 0)
                break;
            l++;
            tmpr = findNextR(inf,l, size);
            inf.getVetor()[tmpr] = -inf.getVetor()[tmpr];
            inf.adicionarMovimentosDeRegistros(1);
        }
    }

    private int findNextR(Informacoes inf,final int l, final int size) {
        for (int i = l; i < size; ++i) {
            inf.adicionarComparacoes(1);
            if (inf.getVetor()[i] < 0){
                return i;
            }
        }
        return size - 1;
    }

    private int partition(Informacoes inf,int l, int r) {
        long pivot = inf.getVetor()[(l + r) / 2];
        inf.adicionarMovimentosDeRegistros(1);
        while (l <= r) {
            while (inf.getVetor()[r] > pivot){
                inf.adicionarComparacoes(1);
                r--;
            }
            while (inf.getVetor()[l] < pivot){
                inf.adicionarComparacoes(1);
                l++;
            }
            if (l <= r) {
                Integer tmp = inf.getVetor()[r];
                inf.getVetor()[r] = inf.getVetor()[l];
                inf.getVetor()[l] = tmp;
                inf.adicionarMovimentosDeRegistros(3);
                l++;
                r--;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Integer[] v = new GeradorDeArrays().geradorDeArray(10, TiposOrdenacao.ALEATORIO);

        System.out.println(Arrays.toString(v));
        new QuickSort().roda(new Informacoes(v));
        System.out.println(Arrays.toString(v));
    }
}
