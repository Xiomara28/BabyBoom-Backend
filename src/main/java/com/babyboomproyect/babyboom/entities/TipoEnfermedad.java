package com.babyboomproyect.babyboom.entities;

import javax.persistence.*;

@Entity
@Table(name = "tipo_enfermedad")
public class TipoEnfermedad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEnfermedad;
    @Column(name = "nombreEnfermedad")

    private String nombreEnfermedad;
    private String tipoTipoEnfermedad;

    // Constructores (vacío y lleno)

    public TipoEnfermedad() {
    }

    public TipoEnfermedad(Long idEnfermedad, String nombreEnfermedad, String tipoTipoEnfermedad) {
        this.idEnfermedad = idEnfermedad;
        this.nombreEnfermedad = nombreEnfermedad;
        this.tipoTipoEnfermedad = tipoTipoEnfermedad;
    }

    // Getters y Setters

    public Long getIdEnfermedad() {
        return idEnfermedad;
    }

    public void setIdEnfermedad(Long idEnfermedad) {
        this.idEnfermedad = idEnfermedad;
    }

    public String getNombreEnfermedad() {
        return nombreEnfermedad;
    }

    public void setNombreEnfermedad(String nombreEnfermedad) {
        this.nombreEnfermedad = nombreEnfermedad;
    }

    public String getTipoTipoEnfermedad() {
        return tipoTipoEnfermedad;
    }

    public void setTipoTipoEnfermedad(String tipoTipoEnfermedad) {
        this.tipoTipoEnfermedad = tipoTipoEnfermedad;
    }
}
