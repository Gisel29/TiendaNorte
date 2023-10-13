package com.neoris.turnosrotativos.repositorio;

import com.neoris.turnosrotativos.entities.Concepto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryConcepto extends JpaRepository<Concepto,Integer> {

}
