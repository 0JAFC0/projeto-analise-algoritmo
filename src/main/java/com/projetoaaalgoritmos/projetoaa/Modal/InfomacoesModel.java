package com.projetoaaalgoritmos.projetoaa.Modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.projetoaaalgoritmos.projetoaa.Uteis.TiposOrdenacao;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "T_INFORMACOES")
public class InfomacoesModel {
    
    // atributos do Model entitidade que é salva no banco
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
    private Long id;
    private String AlgoritmoName;
    private Long quantComparacoes;
    private Long quantidadeMovimentosRegistros;
    @Enumerated(EnumType.STRING)
    private TiposOrdenacao tipoDeOrdenacao;
    private Long tempo;
    private Integer sizeVetor;
}
