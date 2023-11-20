package com.babyboomproyect.babyboom.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "control_vacunacion")
public class ControlVacunacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idControlVacunacion;

    private Date fecha;
    private String tipoVacuna;
    private String estadoVacunacion;
    private String nombreVacunador;
    private String lugar;

    @OneToMany(mappedBy = "controlVacunacion")
    private List<BebeControlVacunacion> bebeControlVacunaciones;

    // Constructores (vacío y lleno)

    public ControlVacunacion() {
    }

    public ControlVacunacion(Long idControlVacunacion, Date fecha, String tipoVacuna, String estadoVacunacion, String nombreVacunador, String lugar) {
        this.idControlVacunacion = idControlVacunacion;
        this.fecha = fecha;
        this.tipoVacuna = tipoVacuna;
        this.estadoVacunacion = estadoVacunacion;
        this.nombreVacunador = nombreVacunador;
        this.lugar = lugar;
    }

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
