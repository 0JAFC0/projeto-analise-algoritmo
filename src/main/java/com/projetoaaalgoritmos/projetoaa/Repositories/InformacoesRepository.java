package com.projetoaaalgoritmos.projetoaa.Repositories;

import com.projetoaaalgoritmos.projetoaa.Modal.InfomacoesModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// repository interface responsavel por salvar no banco
@Repository
public interface InformacoesRepository extends JpaRepository<InfomacoesModel, Long> {
    
}
