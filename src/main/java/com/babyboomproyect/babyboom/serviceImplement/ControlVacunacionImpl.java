package com.babyboomproyect.babyboom.serviceImplement;

import com.babyboomproyect.babyboom.entities.ControlVacunacion;
import com.babyboomproyect.babyboom.repository.ControlVacunacionRepository;
import com.babyboomproyect.babyboom.service.ControlVacunacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ControlVacunacionImpl implements ControlVacunacionService {

    @Autowired
    private ControlVacunacionRepository controlVacunacionRepository;

    @Override
    public ControlVacunacion saveControlVacunacion(ControlVacunacion controlVacunacion) {
        return controlVacunacionRepository.save(controlVacunacion);
    }

    @Override
    public List<ControlVacunacion> listAllControlVacunaciones() {
        return controlVacunacionRepository.findAll();
    }

    @Override
    public ControlVacunacion updateControlVacunacion(Long id, ControlVacunacion updatedControlVacunacion) {
        // Implementa lógica para la actualización
        Optional<ControlVacunacion> existingControlVacunacion = controlVacunacionRepository.findById(id);

        if (existingControlVacunacion.isPresent()) {
            // Realiza la actualización de los campos necesarios
            ControlVacunacion currentControlVacunacion = existingControlVacunacion.get();
            currentControlVacunacion.setFecha(updatedControlVacunacion.getFecha());
            currentControlVacunacion.setTipoVacuna(updatedControlVacunacion.getTipoVacuna());
            currentControlVacunacion.setEstadoVacunacion(updatedControlVacunacion.getEstadoVacunacion());
            currentControlVacunacion.setNombreVacunador(updatedControlVacunacion.getNombreVacunador());
            currentControlVacunacion.setLugar(updatedControlVacunacion.getLugar());

            // Guarda los cambios en la base de datos
            return controlVacunacionRepository.save(currentControlVacunacion);
        }

        return null; // O maneja el caso en que no se encuentra el registro
    }
    @Override
    public void deleteControlVacunacion(Long id) {
        controlVacunacionRepository.deleteById(id);
    }

    @Override
    public ControlVacunacion getControlVacunacionById(Long id) {
        return controlVacunacionRepository.findById(id).orElse(null);
    }

    @Override
    public List<ControlVacunacion> getListTipo(String prefix) {
        return controlVacunacionRepository.getListTipo(prefix);
    }

    @Override
    public List<ControlVacunacion> getListEstado(String prefix) {
        return controlVacunacionRepository.getListEstado(prefix);
    }

    @Override
    public List<ControlVacunacion> getListNombre(String prefix) {
        return controlVacunacionRepository.getListNombre(prefix);
    }

    @Override
    public List<ControlVacunacion> getListLugar(String prefix) {
        return controlVacunacionRepository.getListLugar(prefix);
    }
}
