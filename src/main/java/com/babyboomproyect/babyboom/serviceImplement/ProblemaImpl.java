package com.babyboomproyect.babyboom.serviceImplement;

import com.babyboomproyect.babyboom.entities.Problema;
import com.babyboomproyect.babyboom.repository.ProblemaRepository;
import com.babyboomproyect.babyboom.service.ProblemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProblemaImpl implements ProblemaService {

    @Autowired
    private ProblemaRepository problemaRepository;

    @Override
    public Problema saveProblema(Problema problema) {
        return problemaRepository.save(problema);
    }

    @Override
    public List<Problema> listAllProblemas() {
        return problemaRepository.findAll();
    }

    @Override
    public Optional<Problema> getProblemaByTitulo(String titulo) {
        return problemaRepository.findByTitulo(titulo);
    }

    @Override
    public List<Problema> getProblemaByDescripcion(String descripcion) {
        return problemaRepository.findByDescripcion(descripcion);
    }

    @Override
    public Optional<Problema> getProblemaById(Long id) {
        return problemaRepository.findById(id);
    }

    @Override
    public Problema updateProblema(Long id, Problema updatedProblema) {
        Optional<Problema> existingProblema = problemaRepository.findById(id);

        if (existingProblema.isPresent()) {
            Problema currentProblema = existingProblema.get();
            currentProblema.setTitulo(updatedProblema.getTitulo());
            currentProblema.setDescripcion(updatedProblema.getDescripcion());
            currentProblema.setFechaInicio(updatedProblema.getFechaInicio());
            currentProblema.setFechaFin(updatedProblema.getFechaFin());

            return problemaRepository.save(currentProblema);
        }

        return null;
    }

    @Override
    public void deleteProblemaById(Long id) {
        problemaRepository.deleteById(id);
    }

    // Puedes agregar más métodos según sea necesario
}
