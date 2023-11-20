package com.babyboomproyect.babyboom.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "cita_medica")
public class CitaMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCitaMedica;

    @ManyToOne
    @JoinColumn(name = "idMedico")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "idApoderado")
    private Apoderado apoderado;


    private String tituloCita;

    private Date fecha;

    private String lugar;

    private String nombreClinica;

    // Otros campos adicionales de la entidad CitaMedica

    // Constructores, getters y setters


    public CitaMedica() {
    }

    public CitaMedica(Long idCitaMedica, Medico medico, Apoderado apoderado, String tituloCita, Date fecha, String lugar, String nombreClinica) {
        this.idCitaMedica = idCitaMedica;
        this.medico = medico;
        this.apoderado = apoderado;
        this.tituloCita = tituloCita;
        this.fecha = fecha;
        this.lugar = lugar;
        this.nombreClinica = nombreClinica;
    }

    public Long getIdCitaMedica() {
        return idCitaMedica;
    }

    public void setIdCitaMedica(Long idCitaMedica) {
        this.idCitaMedica = idCitaMedica;
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

    public Long getIdMedico() {
        return medico != null ? medico.getIdMedico() : null;
    }

    public void setIdMedico(Long idMedico) {
        if (medico == null) {
            medico = new Medico();
        }
        medico.setIdMedico(idMedico);
    }

    public Long getIdApoderado() {
        return apoderado != null ? apoderado.getIdApoderado() : null;
    }

    public void setIdApoderado(Long idApoderado) {
        if (apoderado == null) {
            apoderado = new Apoderado();
        }
        apoderado.setIdApoderado(idApoderado);
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Apoderado getApoderado() {
        return apoderado;
    }

    public void setApoderado(Apoderado apoderado) {
        this.apoderado = apoderado;
    }



}
