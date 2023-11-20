package com.babyboomproyect.babyboom.DTO;

import java.sql.Date;

public class ProblemaDTO {
    private Long idProblema;
    private String titulo;
    private String descripcion;
    private java.sql.Date fechaInicio;
    private java.sql.Date fechaFin;
    private Long idApoderado; // Nueva propiedad
    private Long idSoporteTecnico; // Nueva propiedad

    public Long getIdProblema() {
        return idProblema;
    }

    public void setIdProblema(Long idProblema) {
        this.idProblema = idProblema;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Long getIdApoderado() {
        return idApoderado;
    }

    public void setIdApoderado(Long idApoderado) {
        this.idApoderado = idApoderado;
    }

    public Long getIdSoporteTecnico() {
        return idSoporteTecnico;
    }

    public void setIdSoporteTecnico(Long idSoporteTecnico) {
        this.idSoporteTecnico = idSoporteTecnico;
    }
}
