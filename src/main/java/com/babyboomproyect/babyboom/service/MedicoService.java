package com.babyboomproyect.babyboom.service;

import com.babyboomproyect.babyboom.entities.Medico;

import java.util.List;

public interface MedicoService {
    Medico saveMedico(Medico medico);
    List<Medico> listAllMedicos();

    Medico updateMedico (Long id, Medico medico);
    void deleteMedico(Long id);

    Medico getMedicoById(Long id);
}
