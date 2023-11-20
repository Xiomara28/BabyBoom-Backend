package com.babyboomproyect.babyboom.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "bebe")
public class Bebe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBebe;

    @ManyToOne
    @JoinColumn(name = "Apoderado_idApoderado")
    private Apoderado apoderado;

    private String nombreBebe;
    private Date fechaBebe;

    @OneToMany(mappedBy = "bebe")
    private Set<BebeTipoEnfermedad> bebeTipoEnfermedads;

    @OneToMany(mappedBy = "bebe")
    private List<BebeControlVacunacion> bebeControlVacunaciones;

    // Constructores (vacío y lleno)

    public Bebe() {
    }

    public Bebe(Long idBebe, Apoderado apoderado, String nombreBebe, Date fechaBebe) {
        this.idBebe = idBebe;
        this.apoderado = apoderado;
        this.nombreBebe = nombreBebe;
        this.fechaBebe = fechaBebe;
    }

    // Getters y Setters

    public Long getIdBebe() {
        return idBebe;
    }

    public void setIdBebe(Long idBebe) {
        this.idBebe = idBebe;
    }

    public Apoderado getApoderado() {
        return apoderado;
    }

    public void setApoderado(Apoderado apoderado) {
        this.apoderado = apoderado;
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
}
