package com.projetoaaalgoritmos.projetoaa.Algoritmos;

import com.projetoaaalgoritmos.projetoaa.Uteis.Informacoes;

import org.springframework.stereotype.Service;

@Service
public class InsertionSort extends Base{

    @Override
    protected void roda(Informacoes inf) {
        int n = inf.getVetor().length; 
        long quantComp = 0;
        long quantMovRegistro = 0;
        for (int j = 1; j < n-1; j++) { 
            int key = inf.getVetor()[j];
            quantMovRegistro+=1;
            int i = j-1;  
            while ( (i > -1) && ( inf.getVetor()[i] > key ) ) {
                quantComp += 1;
                inf.getVetor()[i+1] = inf.getVetor()[i];  
                quantMovRegistro+=1;
                i--;  
            }
            quantComp++;
            inf.getVetor()[i+1] = key; 
            quantMovRegistro++;
        }
        quantComp++;
        // parte que seta no inf
        inf.setQuantComparacoes(quantComp);
        inf.setQuantidadeMovimentosRegistros(quantMovRegistro);
        inf.setSizeVetor(inf.getVetor().length);
        inf.setAlgoritmoName("Insertion Sort");
    }
}
