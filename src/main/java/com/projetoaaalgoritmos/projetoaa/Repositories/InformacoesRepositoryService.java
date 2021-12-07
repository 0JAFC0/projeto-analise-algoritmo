package com.projetoaaalgoritmos.projetoaa.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InformacoesRepositoryService{
    
    @Autowired
    private InformacoesRepository informacoesRepository;

    public InformacoesRepository getInstance(){
        return this.informacoesRepository;
    }
}
