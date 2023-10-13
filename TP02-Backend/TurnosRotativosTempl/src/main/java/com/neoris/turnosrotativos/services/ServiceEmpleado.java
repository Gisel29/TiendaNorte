package com.neoris.turnosrotativos.services;

import com.neoris.turnosrotativos.dto.EmpleadoDto;
import com.neoris.turnosrotativos.entities.Empleado;

import java.util.List;

public interface ServiceEmpleado {
    Empleado crearEmpleado(Empleado empleado); // Se crea un nuevo empleado
    List<Empleado> obtenerEmpleados(); //Devuelve una lista con todos los empleados
    Empleado obtenerEmpleadoId(Integer Id); // Devuelve un empleado que coincida con la Id
    Empleado actualizoEmpleado(Integer Id, EmpleadoDto empleado); // Se actualiza el empleado segun el Id
    void eliminarEmpleado(Integer Id); //Elimino un empleado
}
