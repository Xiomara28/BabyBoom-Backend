package com.babyboomproyect.babyboom.DTO;

import java.util.Date;

public class ControlVacunacionDTO {

    private Long idControlVacunacion;
    private Date fecha;
    private String tipoVacuna;
    private String estadoVacunacion;
    private String nombreVacunador;
    private String lugar;

    // Getters y Setters

    public Long getIdControlVacunacion() {
        return idControlVacunacion;
    }

    public void setIdControlVacunacion(Long idControlVacunacion) {
        this.idControlVacunacion = idControlVacunacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipoVacuna() {
        return tipoVacuna;
    }

    public void setTipoVacuna(String tipoVacuna) {
        this.tipoVacuna = tipoVacuna;
    }

    public String getEstadoVacunacion() {
        return estadoVacunacion;
    }

    public void setEstadoVacunacion(String estadoVacunacion) {
        this.estadoVacunacion = estadoVacunacion;
    }

    public String getNombreVacunador() {
        return nombreVacunador;
    }

    public void setNombreVacunador(String nombreVacunador) {
        this.nombreVacunador = nombreVacunador;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
}
