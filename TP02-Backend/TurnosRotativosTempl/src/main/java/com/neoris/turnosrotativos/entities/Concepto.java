package com.neoris.turnosrotativos.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity(name = "conceptos")
public class Concepto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotBlank(message = " El Nombre no se ingreso")
    private String nombre;
    @NotNull(message = "Corroborrar si es laborable")
    private Boolean laborable;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer hsMinimo;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer hsMaximo;

    public Integer getId() { return id; }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getLaborable() {
        return laborable;
    }

    public void setLaborable(Boolean laborable) {
        this.laborable = laborable;
    }

    public Integer getHsMinimo() {
        return hsMinimo;
    }

    public Integer getHsMaximo() {
        return hsMaximo;
    }

}
