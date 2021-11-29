package com.projetoaa.Algoritmos;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import com.projetoaa.Uteis.GeradorDeArrays;
import com.projetoaa.Uteis.TiposOrdenacao;

public class InsertionSort {

    public static void insertionSort(Integer array[]) {  
        int n = array.length; 
        int quantComp = 0;
        int quantMovRegistro = 0;
        for (int j = 1; j < n-1; j++) { 
            quantComp++;
            int key = array[j];
            int i = j-1;  
            while ( (i > -1) && ( array [i] > key ) ) {
                quantComp += 2;
                array [i+1] = array [i];  
                quantMovRegistro++;
                i--;  
            }
            array[i+1] = key; 
            quantMovRegistro++;
        }
        quantComp++;
    } 
    
    public static void main(String a[]){
        int t = 10000;
        
        Integer[] arr1 = new GeradorDeArrays().geradorDeArray(t, TiposOrdenacao.ALEATORIO);
        
        Stopwatch relogio = Stopwatch.createStarted();
        insertionSort(arr1);//sorting array using insertion sort    
        relogio.stop();
        System.out.println(relogio.elapsed(TimeUnit.MILLISECONDS));

        arr1 = new GeradorDeArrays().geradorDeArray(t, TiposOrdenacao.DECRESCENTE);

        relogio = Stopwatch.createStarted();
        insertionSort(arr1);//sorting array using insertion sort    
        relogio.stop();
        System.out.println(relogio.elapsed(TimeUnit.MILLISECONDS));
        // System.out.println("After Insertion Sort");    
        // for(Integer i:arr1){    
        //     System.out.print(i+" ");    
        // }
    }
}
