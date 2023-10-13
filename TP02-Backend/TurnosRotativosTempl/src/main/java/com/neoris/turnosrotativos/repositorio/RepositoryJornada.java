package com.neoris.turnosrotativos.repositorio;

import com.neoris.turnosrotativos.entities.Jornada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface RepositoryJornada extends JpaRepository<Jornada,Integer> {

    //Devulve todas las jornadas que sea igual la fecha
    List<Jornada> findAllByFecha(LocalDate fecha);

    //Devuelve todas las jornadas que sea igual con el dni
    @Query(value="SELECT j FROM jornadas j WHERE j.nroDocumento=:dni" )
    List<Jornada> findAllByNroDocumento(@Param("dni") Integer dni);

    //Devuelve todas las jornadas que sean igual al dni y la fecha
    @Query(value = "SELECT j FROM jornadas j WHERE j.nroDocumento=:dni AND j.fecha=:fecha")
    List<Jornada> findAllCondicion(@Param("dni") Integer dni,@Param("fecha") LocalDate fecha);

    //Devuelve todas las jornadas que sean igual al dni y que la fecha sea igual algun dia de la Semana
    @Query(value= "SELECT j FROM jornadas j WHERE j.nroDocumento=:dni AND j.fecha BETWEEN :lunes AND :domingo")
    List<Jornada> findAllCondicionRangoFecha(@Param("dni") Integer dni,@Param("lunes") LocalDate lunes,@Param("domingo") LocalDate domingo);
}
