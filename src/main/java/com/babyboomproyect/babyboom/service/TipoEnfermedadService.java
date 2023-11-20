package com.babyboomproyect.babyboom.service;

import com.babyboomproyect.babyboom.entities.TipoEnfermedad;

import java.util.List;

public interface TipoEnfermedadService {

    TipoEnfermedad saveTipoEnfermedad(TipoEnfermedad tipoEnfermedad);

    List<TipoEnfermedad> listAllTipoEnfermedades();

    TipoEnfermedad updateTipoEnfermedad (Long id, TipoEnfermedad tipoEnfermedad);

    void deleteTipoEnfermedad(Long id);

    TipoEnfermedad getTipoEnfermedadById(Long id);

    List<TipoEnfermedad> findAllByTipoTipoEnfermedad(String tipoTipoEnfermedad);

    List<TipoEnfermedad> findByNombreTipoEnfermedad(String nombreTipoEnfermedad);
}
