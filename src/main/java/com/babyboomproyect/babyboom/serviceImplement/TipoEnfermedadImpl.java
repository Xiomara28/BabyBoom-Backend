package com.babyboomproyect.babyboom.serviceImplement;

import com.babyboomproyect.babyboom.entities.TipoEnfermedad;
import com.babyboomproyect.babyboom.repository.TipoEnfermedadRepository;
import com.babyboomproyect.babyboom.service.TipoEnfermedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoEnfermedadImpl implements TipoEnfermedadService {

    @Autowired
    private TipoEnfermedadRepository tipoEnfermedadRepository;

    @Override
    public TipoEnfermedad saveTipoEnfermedad(TipoEnfermedad tipoEnfermedad) {
        return tipoEnfermedadRepository.save(tipoEnfermedad);
    }

    @Override
    public List<TipoEnfermedad> listAllTipoEnfermedades() {
        return tipoEnfermedadRepository.findAll();
    }

    @Override
    public TipoEnfermedad updateTipoEnfermedad(Long id, TipoEnfermedad updatedTipoEnfermedad) {
        Optional<TipoEnfermedad> existingTipoEnfermedad = tipoEnfermedadRepository.findById(id);

        if (existingTipoEnfermedad.isPresent()) {
            TipoEnfermedad currentTipoEnfermedad = existingTipoEnfermedad.get();
            currentTipoEnfermedad.setNombreEnfermedad(updatedTipoEnfermedad.getNombreEnfermedad());
            currentTipoEnfermedad.setTipoTipoEnfermedad(updatedTipoEnfermedad.getTipoTipoEnfermedad());

            return tipoEnfermedadRepository.save(currentTipoEnfermedad);
        }

        return null;
    }

    @Override
    public void deleteTipoEnfermedad(Long id) {
        tipoEnfermedadRepository.deleteById(id);
    }

    @Override
    public TipoEnfermedad getTipoEnfermedadById(Long id) {
        return tipoEnfermedadRepository.findById(id).orElse(null);
    }

    @Override
    public List<TipoEnfermedad> findAllByTipoTipoEnfermedad(String tipoTipoEnfermedad) {
        return tipoEnfermedadRepository.findAllByTipoTipoEnfermedad(tipoTipoEnfermedad);
    }

    @Override
    public List<TipoEnfermedad> findByNombreTipoEnfermedad(String nombreTipoEnfermedad) {
        return tipoEnfermedadRepository.findByNombreEnfermedad(nombreTipoEnfermedad);
    }
}
