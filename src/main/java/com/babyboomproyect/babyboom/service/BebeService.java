package com.babyboomproyect.babyboom.service;

import com.babyboomproyect.babyboom.entities.Bebe;
import com.babyboomproyect.babyboom.entities.ControlVacunacion;
import com.babyboomproyect.babyboom.entities.TipoEnfermedad;

import java.util.List;

public interface BebeService {

    Bebe saveBebe(Bebe bebe);

    List<Bebe> listAllBebes();

    Bebe updateBebe (Long id, Bebe bebe);

    void deleteBebeById(Long id);

    Bebe getBebeById(Long id);


    List<Bebe> findAllByTipoEnfermedad_NombreTipoEnfermedad(String nombreTipoEnfermedad);

    void asignarEnfermedad(Bebe bebe, TipoEnfermedad enfermedad);

    void asignarControlVacunacion(Bebe bebe, ControlVacunacion controlVacunacion);





}
