package com.babyboomproyect.babyboom.serviceImplement;

import com.babyboomproyect.babyboom.entities.Apoderado;
import com.babyboomproyect.babyboom.repository.ApoderadoRepository;
import com.babyboomproyect.babyboom.service.ApoderadoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApoderadoImpl implements ApoderadoService {

    @Autowired
    private ApoderadoRepository apoderadoRepository;

    @Override
    public Apoderado saveApoderado(Apoderado apoderado) {
        return apoderadoRepository.save(apoderado);
    }

    @Override
    public List<Apoderado> listAllApoderados() {
        return apoderadoRepository.findAll();
    }

    @Override
    public void deleteApoderado(Long id) {
        apoderadoRepository.deleteById(id);
    }

    @Override
    public Apoderado getApoderadoById(Long id) {
        return apoderadoRepository.findById(id).orElse(null);
    }
    @Override
    public Apoderado updateApoderado(Long id, Apoderado apoderado) {
        Apoderado existingApoderado = apoderadoRepository.findById(id).orElse(null);

        if (existingApoderado != null) {
            // Actualizar propiedades según sea necesario
            existingApoderado.setNombre(apoderado.getNombre());
            existingApoderado.setApellido(apoderado.getApellido());
            existingApoderado.setEmail(apoderado.getEmail());

            return apoderadoRepository.save(existingApoderado);
        }

        return null; // o lanzar una excepción si prefieres
    }


}
