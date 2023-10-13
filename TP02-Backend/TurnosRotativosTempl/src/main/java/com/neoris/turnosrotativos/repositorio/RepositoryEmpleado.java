package com.neoris.turnosrotativos.repositorio;

import com.neoris.turnosrotativos.entities.Empleado;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RepositoryEmpleado extends JpaRepository<Empleado,Integer>{

    @NotNull Optional<Empleado> findById(@NotNull Integer id);

    @Query(value="SELECT e FROM empleados e WHERE e.nroDocumento=:dni")
    Optional<Empleado> findByNroDocumento(@Param("dni") Integer dni);

    Optional<Empleado> findByEmail(String email);
}