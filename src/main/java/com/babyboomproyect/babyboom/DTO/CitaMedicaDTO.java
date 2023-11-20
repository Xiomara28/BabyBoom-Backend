package com.babyboomproyect.babyboom.DTO;

import java.util.Date;

public class CitaMedicaDTO {

    private Long idCitaMedica;
    private Long idMedico;
    private Long idApoderado;
    private String tituloCita;
    private Date fecha;
    private String lugar;
    private String nombreClinica;

    // Getters y setters

    public Long getIdCitaMedica() {
        return idCitaMedica;
    }

    public void setIdCitaMedica(Long idCitaMedica) {
        this.idCitaMedica = idCitaMedica;
    }

    public Long getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Long idMedico) {
        this.idMedico = idMedico;
    }

    public Long getIdApoderado() {
        return idApoderado;
    }

    public void setIdApoderado(Long idApoderado) {
        this.idApoderado = idApoderado;
    }

    public String getTituloCita() {
        return tituloCita;
    }

    public void setTituloCita(String tituloCita) {
        this.tituloCita = tituloCita;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getNombreClinica() {
        return nombreClinica;
    }

    public void setNombreClinica(String nombreClinica) {
        this.nombreClinica = nombreClinica;
    }
}
