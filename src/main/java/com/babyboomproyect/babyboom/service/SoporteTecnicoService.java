package com.babyboomproyect.babyboom.service;

import com.babyboomproyect.babyboom.entities.SoporteTecnico;

import java.util.List;

public interface SoporteTecnicoService {
    SoporteTecnico saveSoporteTecnico(SoporteTecnico soporteTecnico);
    List<SoporteTecnico> listAllSoporteTecnicos();

    SoporteTecnico updateSoporteTecnico (Long id, SoporteTecnico soporteTecnico);
    void deleteSoporteTecnico(Long id);
    SoporteTecnico getSoporteTecnicoById(Long id);
}
