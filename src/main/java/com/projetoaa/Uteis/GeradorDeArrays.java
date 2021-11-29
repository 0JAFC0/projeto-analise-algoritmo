package com.projetoaa.Uteis;

public class GeradorDeArrays {

	public Integer[] geradorDeArrayOrdenado(Integer[] vetor, String tipoOrdem) {

		boolean flag = true;
		int index = 0;
		while(flag){
			Integer n = (int)(Math.random()*((int)vetor.length*10));
			
			if(index==vetor.length){
				flag = false;
			}else if(!contains(vetor, n)){
				vetor[index] = n;
				if(index>1){
					if(tipoOrdem.toLowerCase().equals("crescente")){
						ordenar(vetor);
					}else if(tipoOrdem.toLowerCase().equals("decrescente")){
						ordenaInvensamente(vetor);
					}
				}
				index++;
			}
		}
		if(tipoOrdem.toLowerCase().equals("percentual")){
			baguncaPercentual(vetor, 50);
		}
		return vetor;
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

	// metodo para ordenar os vetores  
	private void ordenar(Integer[] v) {
		for(int i = 0; i < v.length-1; i++) {
			boolean estaOrdenado = true;
			for(int j = 0; j < v.length-1-i; j++) {
				if(v[j + 1]==null){
					break;
				}
				if(v[j] > v[j + 1]) {
					Integer aux = v[j];
					v[j] = v[j + 1];
					v[j + 1] = aux;
					estaOrdenado = false;
				}
			}
			if(estaOrdenado)
				break;
		}
	}

	// metodo para ordenar inversamente os vetores
	private Integer[] ordenaInvensamente(Integer[] v){
		for(int i = 0; i < v.length-1; i++) {
			boolean estaOrdenado = true;
			for(int j = 0; j < v.length-1-i; j++) {
				if(v[j + 1]==null){
					break;
				}
				if(v[j] < v[j + 1]) {
					Integer aux = v[j];
					v[j] = v[j + 1];
					v[j + 1] = aux;
					estaOrdenado = false;
				}
			}
			if(estaOrdenado)
				break;
		}
		return v;
	}

	// metodo para ordenar percentual do array
	private Integer[] baguncaPercentual(Integer[] v, int percentual){
		int quantidade = (percentual*v.length)/100;
		
		ordenar(v);
		if(quantidade%2!=0){
			Integer n = 0;
			do{
				n = (int)(Math.random()*((int)v.length*10));
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

	public static void main(String[] args) {

		int t = 1000000;
		// crescente
		System.out.print("[");
		for(int i:new GeradorDeArrays().geradorDeArrayOrdenado(new Integer[t],"crescente"))
			System.out.print(i+" ");
		System.out.print("]");
		// decrescente
		System.out.print("\n[");
		for(int i:new GeradorDeArrays().geradorDeArrayOrdenado(new Integer[t],"decrescente"))
			System.out.print(i+" ");
		System.out.print("]");
		// percentual
		System.out.print("\n[");
		for(int i:new GeradorDeArrays().geradorDeArrayOrdenado(new Integer[t],"percentual"))
			System.out.print(i+" ");
		System.out.print("]");
	}
	
}

