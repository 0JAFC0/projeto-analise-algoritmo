package com.projetoaaalgoritmos.projetoaa.Uteis;

import lombok.Getter;
import lombok.Setter;

// classe utilizando para ser manipulada no algoritmo base e nos algoritmos de ordenacao
@Setter
@Getter
public class Informacoes {
    private Long quantComparacoes = 0l;
    private Long quantidadeMovimentosRegistros = 0l;
    private TiposOrdenacao tipoDeOrdenacao = null;
    private Long tempo = 0l;
    private Integer[] vetor;
    private Integer sizeVetor;
    private String AlgoritmoName;

    public Informacoes(Integer[] vetor){
        this.vetor = vetor;
    }

    public void adicionarMovimentosDeRegistros(Integer quant){
        this.quantidadeMovimentosRegistros += quant;
    }

    public void adicionarComparacoes(Integer quant){
        this.quantComparacoes += quant;
    }
}
