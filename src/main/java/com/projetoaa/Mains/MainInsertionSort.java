package com.projetoaa.Mains;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import com.projetoaa.Algoritmos.Base;
import com.projetoaa.Algoritmos.InsertionSort;
import com.projetoaa.Uteis.GeradorDeArrays;
import com.projetoaa.Uteis.TiposOrdenacao;

public class MainInsertionSort extends Base{
    public static void main(String a[]){
        int t = 100000;
        
        Integer[] arr1 = new GeradorDeArrays().geradorDeArray(t, TiposOrdenacao.ALEATORIO);
        
        Stopwatch relogio = Stopwatch.createStarted();
        InsertionSort.insertionSort(arr1);//sorting array using insertion sort    
        relogio.stop();
        System.out.println(relogio.elapsed(TimeUnit.MICROSECONDS));

        arr1 = new GeradorDeArrays().geradorDeArray(t, TiposOrdenacao.DECRESCENTE);

        relogio = Stopwatch.createStarted();
        InsertionSort.insertionSort(arr1);//sorting array using insertion sort    
        relogio.stop();
        System.out.println(relogio.elapsed(TimeUnit.MICROSECONDS));
        // System.out.println("After Insertion Sort");    
        // for(Integer i:arr1){    
        //     System.out.print(i+" ");    
        // }
    }
}
