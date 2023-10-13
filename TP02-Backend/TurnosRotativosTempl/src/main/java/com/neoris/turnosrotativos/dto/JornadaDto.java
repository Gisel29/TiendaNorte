package com.neoris.turnosrotativos.dto;


import com.neoris.turnosrotativos.entities.Concepto;
import com.neoris.turnosrotativos.entities.Empleado;
import com.neoris.turnosrotativos.entities.Jornada;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@Data
public class JornadaDto {
    @NotNull(message = " El IdEmpleado es obligatorio")

    private Integer IdEmpleado;
    @NotNull(message = "El IdConcepto' es obligatorio")
    private Integer idConcepto;
    @NotNull(message = "La fecha es obligatoria")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;

    private Integer horasDeTrabajo;


    // Aca asignamos los atributos a jornada
    public Jornada toEntity(Empleado e, Concepto c){
        Jornada j=new Jornada();
        j.setConcepto(c.getNombre());
        j.setFecha(this.getFecha());
        j.setNombreCompleto(e.getNombre()+" "+e.getApellido());
        j.setNroDocumento(e.getNroDocumento());
        j.setHsTrabajadas(this.horasDeTrabajo);
        return j;
    }

}


