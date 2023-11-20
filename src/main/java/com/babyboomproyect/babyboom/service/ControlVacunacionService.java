package com.babyboomproyect.babyboom.service;

import com.babyboomproyect.babyboom.entities.ControlVacunacion;

import java.util.List;

public interface ControlVacunacionService {

    ControlVacunacion saveControlVacunacion(ControlVacunacion controlVacunacion);

    List<ControlVacunacion> listAllControlVacunaciones();

    ControlVacunacion updateControlVacunacion (Long id, ControlVacunacion controlVacunacion);

    void deleteControlVacunacion(Long id);

    ControlVacunacion getControlVacunacionById(Long id);

    List<ControlVacunacion> getListTipo(String prefix);

    List<ControlVacunacion> getListEstado(String prefix);

    List<ControlVacunacion> getListNombre(String prefix);

    List<ControlVacunacion> getListLugar(String prefix);
}
