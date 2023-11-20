package com.babyboomproyect.babyboom.serviceImplement;

import com.babyboomproyect.babyboom.entities.*;
import com.babyboomproyect.babyboom.repository.ApoderadoRepository;
import com.babyboomproyect.babyboom.repository.BebeControlVacunacionRepository;
import com.babyboomproyect.babyboom.repository.BebeRepository;
import com.babyboomproyect.babyboom.repository.BebeTipoEnfermedadRepository;
import com.babyboomproyect.babyboom.service.BebeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class BebeImpl implements BebeService {

    @Autowired
    private BebeRepository bebeRepository;
    @Autowired
    private ApoderadoRepository apoderadoRepository;
    @Autowired
    private BebeTipoEnfermedadRepository bebeTipoEnfermedadRepository;
    @Autowired
    private BebeControlVacunacionRepository bebeControlVacunacionRepository;


    @Override
    @Transactional
    public Bebe saveBebe(Bebe bebe) {
        return bebeRepository.save(bebe);
    }

    @Override
    public List<Bebe> listAllBebes() {
        return bebeRepository.findAll();
    }

    @Override
    public void deleteBebeById(Long id) {
        bebeRepository.deleteById(id);
    }

    @Override
    public Bebe getBebeById(Long id) {
        return bebeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Bebe> findAllByTipoEnfermedad_NombreTipoEnfermedad(String nombreTipoEnfermedad) {
        return bebeRepository.findByTipoEnfermedad_NombreEnfermedad(nombreTipoEnfermedad);
    }

    @Override
    public Bebe updateBebe(Long id, Bebe newBebe) {
        Optional<Bebe> existingBebe = bebeRepository.findById(id);
        if (existingBebe.isPresent()) {
            Bebe bebe = existingBebe.get();
            // Actualiza los campos necesarios
            bebe.setNombreBebe(newBebe.getNombreBebe());
            bebe.setFechaBebe(newBebe.getFechaBebe());
            // Puedes agregar más campos para actualizar según sea necesario

            // Guarda el bebe actualizado
            return bebeRepository.save(bebe);
        } else {
            return null; // O lanza una excepción indicando que el bebe no fue encontrado
        }
    }

    @Override
    @Transactional
    public void asignarEnfermedad(Bebe bebe, TipoEnfermedad enfermedad) {
        BebeTipoEnfermedad bebeTipoEnfermedad = new BebeTipoEnfermedad();
        bebeTipoEnfermedad.setBebe(bebe);
        bebeTipoEnfermedad.setTipoEnfermedad(enfermedad);
        bebeTipoEnfermedadRepository.save(bebeTipoEnfermedad);
    }

    @Override
    @Transactional
    public void asignarControlVacunacion(Bebe bebe, ControlVacunacion controlVacunacion) {
        BebeControlVacunacion bebeControlVacunacion = new BebeControlVacunacion();
        bebeControlVacunacion.setBebe(bebe);
        bebeControlVacunacion.setControlVacunacion(controlVacunacion);
        bebeControlVacunacionRepository.save(bebeControlVacunacion);
    }



}
