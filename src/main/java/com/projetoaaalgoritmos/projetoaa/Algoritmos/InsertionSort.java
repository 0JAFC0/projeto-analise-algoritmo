package com.projetoaaalgoritmos.projetoaa.Algoritmos;

import com.projetoaaalgoritmos.projetoaa.Uteis.Informacoes;

import org.springframework.stereotype.Service;

@Service
public class InsertionSort extends Base{

    @Override
    protected void roda(Informacoes inf) {
        int n = inf.getVetor().length;
        for (int j = 1; j < n-1; j++) { 
            int key = inf.getVetor()[j];
            inf.adicionarMovimentosDeRegistros(1);
            int i = j-1;  
            while ( (i > -1) && ( inf.getVetor()[i] > key ) ) {
                inf.adicionarComparacoes(1);
                inf.getVetor()[i+1] = inf.getVetor()[i];
                inf.adicionarMovimentosDeRegistros(1);
                i--;
            }
            inf.adicionarComparacoes(1);
            inf.getVetor()[i+1] = key;
            inf.adicionarMovimentosDeRegistros(1);
        }
        
    }
}
