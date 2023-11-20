package com.babyboomproyect.babyboom.entities;

import javax.persistence.*;

@Entity
@Table(name = "bebe_control_vacunacion")
public class BebeControlVacunacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bebe_id")
    private Bebe bebe;

    @ManyToOne
    @JoinColumn(name = "control_vacunacion_id")
    private ControlVacunacion controlVacunacion;

    // Otros campos si son necesarios

    // Constructores, getters y setters


    public BebeControlVacunacion() {
    }

    public BebeControlVacunacion(Long id, Bebe bebe, ControlVacunacion controlVacunacion) {
        this.id = id;
        this.bebe = bebe;
        this.controlVacunacion = controlVacunacion;
    }

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

    public ControlVacunacion getControlVacunacion() {
        return controlVacunacion;
    }

    public void setControlVacunacion(ControlVacunacion controlVacunacion) {
        this.controlVacunacion = controlVacunacion;
    }
}
