package com.babyboomproyect.babyboom.serviceImplement;

import com.babyboomproyect.babyboom.entities.Medico;
import com.babyboomproyect.babyboom.repository.MedicoRepository;
import com.babyboomproyect.babyboom.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoImpl implements MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Override
    public Medico saveMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    @Override
    public List<Medico> listAllMedicos() {
        return medicoRepository.findAll();
    }

    @Override
    public Medico updateMedico(Long id, Medico updatedMedico) {
        Optional<Medico> existingMedico = medicoRepository.findById(id);

        if (existingMedico.isPresent()) {
            Medico currentMedico = existingMedico.get();
            currentMedico.setNombre(updatedMedico.getNombre());
            currentMedico.setApellido(updatedMedico.getApellido());
            currentMedico.setEspecialidad(updatedMedico.getEspecialidad());
            currentMedico.setEmail(updatedMedico.getEmail());

            return medicoRepository.save(currentMedico);
        }

        return null;
    }

    @Override
    public void deleteMedico(Long id) {
        medicoRepository.deleteById(id);
    }

    @Override
    public Medico getMedicoById(Long id) {
        return medicoRepository.findById(id).orElse(null);
    }
}
