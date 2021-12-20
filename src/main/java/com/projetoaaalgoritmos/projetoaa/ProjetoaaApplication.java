package com.projetoaaalgoritmos.projetoaa;

import com.projetoaaalgoritmos.projetoaa.Algoritmos.BubbleSort;
import com.projetoaaalgoritmos.projetoaa.Algoritmos.InsertionSort;
import com.projetoaaalgoritmos.projetoaa.Algoritmos.MergeSort;
import com.projetoaaalgoritmos.projetoaa.Algoritmos.QuickSort;
import com.projetoaaalgoritmos.projetoaa.Algoritmos.SelectionSort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// classe responsavel por executar o springboot -> main 
@SpringBootApplication
public class ProjetoaaApplication implements CommandLineRunner{
	
	@Autowired
	private InsertionSort insertionSort;

	@Autowired
	private BubbleSort bubbleSort;

	@Autowired
	private SelectionSort selectionSort;

	@Autowired
	private MergeSort mergeSort;

	@Autowired
	private QuickSort quickSort;

	// Main do programa
	public static void main(String[] args) {
		SpringApplication.run(ProjetoaaApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		//insertionSort.rodarAlgoritmo();
		selectionSort.rodarAlgoritmo();
		// mergeSort.rodarAlgoritmo();
		// quickSort.rodarAlgoritmo();
		//bubbleSort.rodarAlgoritmo();
	}
	
}
