package com.babyboomproyect.babyboom.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "soporte_tecnico")
public class SoporteTecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSoporte;

    private String nombreSoporte;

    @OneToMany(mappedBy = "soporteTecnico")
    private List<Problema> problemas;

    // Constructores (vacío y lleno)

    public SoporteTecnico() {
    }

    public SoporteTecnico(Long idSoporte, String nombreSoporte) {
        this.idSoporte = idSoporte;
        this.nombreSoporte = nombreSoporte;
    }

    // Getters y Setters

    public Long getIdSoporte() {
        return idSoporte;
    }

    public void setIdSoporte(Long idSoporte) {
        this.idSoporte = idSoporte;
    }

    public String getNombreSoporte() {
        return nombreSoporte;
    }

    public void setNombreSoporte(String nombreSoporte) {
        this.nombreSoporte = nombreSoporte;
    }
}
