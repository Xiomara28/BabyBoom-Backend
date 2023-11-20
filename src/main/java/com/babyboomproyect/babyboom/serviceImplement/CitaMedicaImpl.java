package com.babyboomproyect.babyboom.serviceImplement;

import com.babyboomproyect.babyboom.entities.CitaMedica;
import com.babyboomproyect.babyboom.repository.CitaMedicaRepository;
import com.babyboomproyect.babyboom.service.CitaMedicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitaMedicaImpl implements CitaMedicaService {

    @Autowired
    private CitaMedicaRepository citaMedicaRepository;

    @Override
    public CitaMedica saveCitaMedica(CitaMedica citaMedica) {
        return citaMedicaRepository.save(citaMedica);
    }

    @Override
    public List<CitaMedica> listAllCitasMedicas() {
        return citaMedicaRepository.findAll();
    }

    @Override
    public Optional<CitaMedica> getCitaMedicaById(Long id) {
        return citaMedicaRepository.findById(id);
    }

    @Override
    public void deleteCitaMedicaById(Long id) {
        citaMedicaRepository.deleteById(id);
    }

    @Override
    public CitaMedica updateCitaMedica(Long id, CitaMedica updatedCitaMedica) {
        Optional<CitaMedica> existingCitaMedica = getCitaMedicaById(id);
        if (existingCitaMedica.isPresent()) {
            updatedCitaMedica.setIdCitaMedica(id);
            return saveCitaMedica(updatedCitaMedica);
        }
        return null; // Puedes manejar de otra manera si lo prefieres (lanzar excepción, etc.)
    }

    // Puedes agregar más métodos según sea necesario
}
