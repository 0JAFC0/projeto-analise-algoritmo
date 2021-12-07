package com.projetoaaalgoritmos.projetoaa;

import com.projetoaaalgoritmos.projetoaa.Algoritmos.InsertionSort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetoaaApplication implements CommandLineRunner{

	@Autowired
	private InsertionSort insertionSort;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoaaApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		insertionSort.rodarAlgoritmo();
	}
	
}
