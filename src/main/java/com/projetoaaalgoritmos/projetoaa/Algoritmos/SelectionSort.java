package com.projetoaaalgoritmos.projetoaa.Algoritmos;

import com.projetoaaalgoritmos.projetoaa.Uteis.Informacoes;

import org.springframework.stereotype.Service;

@Service
public class SelectionSort extends Base{
    
    @Override
    protected void roda(Informacoes inf) {
        int n = inf.getVetor().length;
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++){
            // Find the minimum element in unsorted array
            int min_idx = i;
            inf.adicionarMovimentosDeRegistros(1);
            for (int j = i+1; j < n; j++){
                inf.adicionarComparacoes(1);
                if (inf.getVetor()[j] < inf.getVetor()[min_idx]){
                    min_idx = j;
                    inf.adicionarMovimentosDeRegistros(1);
                }
            }
 
            // Swap the found minimum element with the first
            // element
            int temp = inf.getVetor()[min_idx];
            inf.getVetor()[min_idx] = inf.getVetor()[i];
            inf.getVetor()[i] = temp;
            inf.adicionarMovimentosDeRegistros(3);
        }
    }
}
