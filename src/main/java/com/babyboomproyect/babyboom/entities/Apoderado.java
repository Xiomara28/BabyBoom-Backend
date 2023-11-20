package com.babyboomproyect.babyboom.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.internal.util.stereotypes.Lazy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "apoderados")
public class Apoderado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idApoderado;

    private String nombre;
    private String apellido;
    private String email;

    @OneToMany(mappedBy = "apoderado")
    private List<Problema> problemas;

    @OneToMany(mappedBy = "apoderado",fetch = FetchType.LAZY)
    private List<Bebe> bebes;

    // Constructores (vacío y lleno)
    public Apoderado() {
    }

    public Apoderado(Long idApoderado, String nombre, String apellido, String email) {
        this.idApoderado = idApoderado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }



    // Getters y Setters
    public Long getIdApoderado() {
        return idApoderado;
    }

    public void setIdApoderado(Long idApoderado) {
        this.idApoderado = idApoderado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public List<Bebe> getBebes() {
        return bebes;
    }

    public void setBebes(List<Bebe> bebes) {
        this.bebes = bebes;
    }
}






