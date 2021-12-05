package com.projetoaa.Algoritmos;

import com.projetoaa.Uteis.TiposOrdenacao;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Informacoes {
    private Long quantComparacoes = 0l;
    private Long quantidadeMovimentosRegistros = 0l;
    private TiposOrdenacao tipoDeOrdenacao = null;
    private Long tempo = 0l;
    private Integer[] vetor;

    public Informacoes(Integer[] vetor){
        this.vetor = vetor;
    }
}
