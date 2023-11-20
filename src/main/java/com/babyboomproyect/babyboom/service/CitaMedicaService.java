package com.babyboomproyect.babyboom.service;

import com.babyboomproyect.babyboom.entities.CitaMedica;

import java.util.List;
import java.util.Optional;

public interface CitaMedicaService {

    CitaMedica saveCitaMedica(CitaMedica citaMedica);

    List<CitaMedica> listAllCitasMedicas();

    Optional<CitaMedica> getCitaMedicaById(Long id);

    CitaMedica updateCitaMedica (Long id, CitaMedica citaMedica);

    void deleteCitaMedicaById(Long id);

    // Puedes agregar más métodos según sea necesario
}
