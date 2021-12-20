package com.projetoaaalgoritmos.projetoaa.Algoritmos;

import java.util.Arrays;

import com.projetoaaalgoritmos.projetoaa.Uteis.GeradorDeArrays;
import com.projetoaaalgoritmos.projetoaa.Uteis.Informacoes;
import com.projetoaaalgoritmos.projetoaa.Uteis.TiposOrdenacao;

import org.springframework.stereotype.Service;

@Service
public class BubbleSort extends Base{

    @Override
    protected void roda(Informacoes inf) {
        int n = inf.getVetor().length;
        for (int i = 0; i < n-1; i++){
            for (int j = 0; j < n-i-1; j++){
                if (inf.getVetor()[j] > inf.getVetor()[j+1]){
                    // swap temp and arr[i]
                    int temp = inf.getVetor()[j];
                    inf.getVetor()[j] = inf.getVetor()[j+1];
                    inf.getVetor()[j+1] = temp;
                    inf.adicionarMovimentosDeRegistros(3);
                }
                inf.adicionarComparacoes(1);
            }
        }
        
    }

    public static void main(String[] args) {
        Integer[] v = new GeradorDeArrays().geradorDeArray(10, TiposOrdenacao.ALEATORIO);

        System.out.println(Arrays.toString(v));
        new BubbleSort().roda(new Informacoes(v));
        System.out.println(Arrays.toString(v));
    }
}
