package com.babyboomproyect.babyboom.service;

import com.babyboomproyect.babyboom.entities.Problema;

import java.util.List;
import java.util.Optional;

public interface ProblemaService {

    Problema saveProblema(Problema problema);

    List<Problema> listAllProblemas();

    Optional<Problema> getProblemaByTitulo(String titulo);

    List<Problema> getProblemaByDescripcion(String descripcion);

    Optional<Problema> getProblemaById(Long id);

    Problema updateProblema (Long id, Problema problema);

    void deleteProblemaById(Long id);

    // Puedes agregar más métodos según sea necesario
}
