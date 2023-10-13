package com.neoris.turnosrotativos.services;

import com.neoris.turnosrotativos.entities.Concepto;
import com.neoris.turnosrotativos.repositorio.RepositoryConcepto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceImplConcepto implements ServiceConcepto {

    @Autowired
    private RepositoryConcepto repoConcepto;

    // Devuelve todos los conceptos
    @Override
    public List<Concepto> allConcepto() {
        return repoConcepto.findAll();
    }
}



