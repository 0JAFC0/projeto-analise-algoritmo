package com.projetoaaalgoritmos.projetoaa.Uteis;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//classe responsavel por gerar os Arrays dos tipos especificos e dos tamanhos
public class GeradorDeArrays {

	public Integer[] geradorDeArray(int quantidade, TiposOrdenacao tipoOrdem) {

		Integer[] temp = IntStream.of(IntStream.range(1, quantidade).toArray()).boxed().toArray(Integer[]::new);
					
		if(tipoOrdem == TiposOrdenacao.CRESCENTE){
			return temp;
		}
		else if(tipoOrdem == TiposOrdenacao.DECRESCENTE){
			return ordenaInvensamente(temp);
		}
		else if(tipoOrdem == TiposOrdenacao.PERCENTUAL){
			return baguncaPercentual(temp, 50);
		}else if(tipoOrdem == TiposOrdenacao.ALEATORIO){
			return baguncaVetor(temp);
		}

		return null;
	}

	private Integer[] baguncaVetor(Integer[] v){
		List<Integer> temp = Arrays.stream(v).collect(Collectors.toList());
		Collections.shuffle(temp);
		return temp.stream().toArray(Integer[]::new);
	}
	
	private boolean contains(Integer[] vetor, Integer v){

		for(int i = 0;i < vetor.length;i++){
			if(vetor[i]==null){
				break;
			}
			else if(vetor[i]==v){
				return true;
			}

		}
		return false;
	}

	// // metodo para ordenar os vetores  
	// private void ordenar(Integer[] v) {
	// 	for(int i = 0; i < v.length-1; i++) {
	// 		boolean esta = true;
	// 		for(int j = 0; j < v.length-1-i; j++) {
	// 			if(v[j + 1]==null){
	// 				break;
	// 			}
	// 			if(v[j] > v[j + 1]) {
	// 				Integer aux = v[j];
	// 				v[j] = v[j + 1];
	// 				v[j + 1] = aux;
	// 				esta = false;
	// 			}
	// 		}
	// 		if(esta)
	// 			break;
	// 	}
	// }

	// metodo para ordenar inversamente os vetores
	private Integer[] ordenaInvensamente(Integer[] v){
		// for(int i = 0; i < v.length-1; i++) {
		// 	boolean esta = true;
		// 	for(int j = 0; j < v.length-1-i; j++) {
		// 		if(v[j + 1]==null){
		// 			break;
		// 		}
		// 		if(v[j] < v[j + 1]) {
		// 			Integer aux = v[j];
		// 			v[j] = v[j + 1];
		// 			v[j + 1] = aux;
		// 			esta = false;
		// 		}
		// 	}
		// 	if(esta)
		// 		break;
		// }
		List<Integer> temp  = Arrays.stream(v).collect(Collectors.toList());
		Collections.reverse(temp);
		return temp.stream().toArray(Integer[]::new);
	}

	// metodo para ordenar percentual do array
	private Integer[] baguncaPercentual(Integer[] v, int percentual){
		int quantidade = v.length-((percentual*v.length)/100);
		
		if(quantidade%2!=0){
			Integer n = 0;
			do{
				n = (int)(Math.random()*((int)v.length));
			}while(contains(v, n));
			v[(int)(Math.random()*(v.length-1))] = n;
		}
		for(int i = 0; i < quantidade/2; i++) {
			trocar(v, (int)(Math.random()*(v.length-1)), (int)(Math.random()*(v.length-1)));
		}
		return v;
	}
	
	// metodo para trocar de posições no vetor
	private static void trocar(Integer[] v, int i, int j) {
		Integer aux = v[i];
		v[i] = v[j];
		v[j] = aux;
	}

	// public static void main(String[] args) {

	// 	int t = 10;
	// 	// crescente
	// 	System.out.print("[");
	// 	for(int i:new GeradorDeArrays().geradorDeArray(t,TiposOrdenacao.CRESCENTE))
	// 		System.out.print(i+" ");
	// 	System.out.print("]");
	// 	// // decrescente
	// 	System.out.print("\n[");
	// 	for(int i:new GeradorDeArrays().geradorDeArray(t,TiposOrdenacao.DECRESCENTE))
	// 		System.out.print(i+" ");
	// 	System.out.print("]");
	// 	// // percentual
	// 	System.out.print("\n[");
	// 	for(int i:new GeradorDeArrays().geradorDeArray(t,TiposOrdenacao.PERCENTUAL))
	// 		System.out.print(i+" ");
	// 	System.out.print("]");
	// 	// Aleatorio
	// 	System.out.print("\n[");
	// 	for(int i:new GeradorDeArrays().geradorDeArray(t,TiposOrdenacao.ALEATORIO))
	// 		System.out.print(i+" ");
	// 	System.out.print("]");
	// }
	
}

