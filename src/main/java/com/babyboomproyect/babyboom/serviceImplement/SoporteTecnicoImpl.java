package com.babyboomproyect.babyboom.serviceImplement;

import com.babyboomproyect.babyboom.entities.SoporteTecnico;
import com.babyboomproyect.babyboom.repository.SoporteTecnicoRepository;
import com.babyboomproyect.babyboom.service.SoporteTecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SoporteTecnicoImpl implements SoporteTecnicoService {

    @Autowired
    private SoporteTecnicoRepository soporteTecnicoRepository;

    @Override
    public SoporteTecnico saveSoporteTecnico(SoporteTecnico soporteTecnico) {
        return soporteTecnicoRepository.save(soporteTecnico);
    }

    @Override
    public List<SoporteTecnico> listAllSoporteTecnicos() {
        return soporteTecnicoRepository.findAll();
    }

    @Override
    public SoporteTecnico updateSoporteTecnico(Long id, SoporteTecnico updatedSoporteTecnico) {
        Optional<SoporteTecnico> existingSoporteTecnico = soporteTecnicoRepository.findById(id);

        if (existingSoporteTecnico.isPresent()) {
            SoporteTecnico currentSoporteTecnico = existingSoporteTecnico.get();
            currentSoporteTecnico.setNombreSoporte(updatedSoporteTecnico.getNombreSoporte());

            return soporteTecnicoRepository.save(currentSoporteTecnico);
        }

        return null;
    }

    @Override
    public void deleteSoporteTecnico(Long id) {
        soporteTecnicoRepository.deleteById(id);
    }

    @Override
    public SoporteTecnico getSoporteTecnicoById(Long id) {
        return soporteTecnicoRepository.findById(id).orElse(null);
    }
}
