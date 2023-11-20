package com.babyboomproyect.babyboom.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "problema")
public class Problema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProblema;

    @ManyToOne
    @JoinColumn(name = "idSoporte")
    private SoporteTecnico soporteTecnico;

    @ManyToOne
    @JoinColumn(name = "idApoderado")
    private Apoderado apoderado;

    private String titulo;

    private String descripcion;

    @Column(name = "fecha_inicio")
    private java.sql.Date fechaInicio;

    @Column(name = "fecha_fin")
    private java.sql.Date fechaFin;

    // Otros campos adicionales de la entidad Problema

    // Constructores, getters y setters


    public Problema() {
    }

    public Problema(Long idProblema, SoporteTecnico soporteTecnico, Apoderado apoderado, String titulo, String descripcion, Date fechaInicio, Date fechaFin) {
        this.idProblema = idProblema;
        this.soporteTecnico = soporteTecnico;
        this.apoderado = apoderado;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Long getIdProblema() {
        return idProblema;
    }

    public void setIdProblema(Long idProblema) {
        this.idProblema = idProblema;
    }

    public SoporteTecnico getSoporteTecnico() {
        return soporteTecnico;
    }

    public void setSoporteTecnico(SoporteTecnico soporteTecnico) {
        this.soporteTecnico = soporteTecnico;
    }

    public Apoderado getApoderado() {
        return apoderado;
    }

    public void setApoderado(Apoderado apoderado) {
        this.apoderado = apoderado;
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
}
