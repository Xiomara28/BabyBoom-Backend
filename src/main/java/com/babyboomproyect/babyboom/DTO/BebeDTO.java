package com.babyboomproyect.babyboom.DTO;

import com.babyboomproyect.babyboom.entities.Apoderado;

import java.util.Date;

public class BebeDTO {

    private Long idBebe;
    private String nombreBebe;
    private Date fechaBebe;
    private ApoderadoDTO apoderado=new ApoderadoDTO();

    // Getters y setters

    public Long getIdBebe() {
        return idBebe;
    }

    public void setIdBebe(Long idBebe) {
        this.idBebe = idBebe;
    }

    public String getNombreBebe() {
        return nombreBebe;
    }

    public void setNombreBebe(String nombreBebe) {
        this.nombreBebe = nombreBebe;
    }

    public Date getFechaBebe() {
        return fechaBebe;
    }

    public void setFechaBebe(Date fechaBebe) {
        this.fechaBebe = fechaBebe;
    }

    public ApoderadoDTO getApoderado() {
        return apoderado;
    }

    public void setApoderado(ApoderadoDTO apoderado) {
        this.apoderado = apoderado;
    }
}
