package com.neoris.turnosrotativos.exception;

public class Excepciones extends RuntimeException {
    private final Integer status;
    private final String nombreStatus;
    public Excepciones(String mensage,Integer status, String nombre) {
      super(mensage);
      this.status=status;
      this.nombreStatus=nombre;
    }

    public Integer getStatus(){
         return status;
    }

    public String getNombreStatus(){
        return nombreStatus;
    }
}
