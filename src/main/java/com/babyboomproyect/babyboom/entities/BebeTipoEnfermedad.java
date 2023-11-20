package com.babyboomproyect.babyboom.entities;

import javax.persistence.*;

@Entity
@Table(name = "bebe_tipo_enfermedad")
public class BebeTipoEnfermedad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_bebe")
    private Bebe bebe;

    @ManyToOne
    @JoinColumn(name = "id_tipo_enfermedad")
    private TipoEnfermedad tipoEnfermedad;

    public BebeTipoEnfermedad() {
    }

    public BebeTipoEnfermedad(Long id, Bebe bebe, TipoEnfermedad tipoEnfermedad) {
        this.id = id;
        this.bebe = bebe;
        this.tipoEnfermedad = tipoEnfermedad;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Bebe getBebe() {
        return bebe;
    }

    public void setBebe(Bebe bebe) {
        this.bebe = bebe;
    }

    public TipoEnfermedad getTipoEnfermedad() {
        return tipoEnfermedad;
    }

    public void setTipoEnfermedad(TipoEnfermedad tipoEnfermedad) {
        this.tipoEnfermedad = tipoEnfermedad;
    }
}
