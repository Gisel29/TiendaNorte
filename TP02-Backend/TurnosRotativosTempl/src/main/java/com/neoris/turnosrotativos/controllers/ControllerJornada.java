package com.neoris.turnosrotativos.controllers;

import com.neoris.turnosrotativos.dto.JornadaDto;
import com.neoris.turnosrotativos.entities.Jornada;
import com.neoris.turnosrotativos.exception.Excepciones;
import com.neoris.turnosrotativos.services.ServiceJornada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class ControllerJornada {

    @Autowired
    private ServiceJornada serviceJornada;

    @GetMapping("jornada")
    public ResponseEntity<List<Jornada>> obtenerJornadas(@RequestParam(required = false,name = "nroDocumento") Integer nroDocumento, @RequestParam(required = false,name = "fecha")String fecha) throws Excepciones {
        LocalDate f=null;
        // Verifico que tiene formato fecha: yyyy-MM-dd
        if(fecha!=null ){
            try {
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                f = LocalDate.parse(fecha, formato);
            }catch (DateTimeParseException e){
                throw  new Excepciones("Se ingreso texto con formato de fecha invalido,Formato Valido: yyyy-MM-dd", HttpStatus.CONFLICT.value(),HttpStatus.CONFLICT.name());
            }
        }
        return ResponseEntity.ok(serviceJornada.obtenerJornadas(nroDocumento,f));
    }

    @PostMapping("jornada")
    public ResponseEntity<Jornada> crearJornada(@Valid @RequestBody JornadaDto jornadaDto){
        Jornada jornadaAdd = serviceJornada.crearJornada(jornadaDto);
        HttpHeaders responseHeaders=new HttpHeaders();
        responseHeaders.set(HttpHeaders.LOCATION,String.format("/jornada/%d",jornadaAdd.getId()));
        return ResponseEntity.created(URI.create(String.format("/jornada/%d",jornadaAdd.getId()))).body(jornadaAdd);
    }
}
