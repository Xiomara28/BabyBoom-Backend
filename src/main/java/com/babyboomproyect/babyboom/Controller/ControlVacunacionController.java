package com.babyboomproyect.babyboom.Controller;

import com.babyboomproyect.babyboom.DTO.ControlVacunacionDTO;
import com.babyboomproyect.babyboom.entities.ControlVacunacion;
import com.babyboomproyect.babyboom.service.ControlVacunacionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/controlVacunacion")
public class ControlVacunacionController {

    @Autowired
    private ControlVacunacionService controlVacunacionService;

    @PostMapping
    public ResponseEntity<ControlVacunacionDTO> createControlVacunacion(@RequestBody ControlVacunacionDTO controlVacunacionDTO) {
        ControlVacunacion controlVacunacion = convertDtoToEntity(controlVacunacionDTO);
        ControlVacunacion savedControlVacunacion = controlVacunacionService.saveControlVacunacion(controlVacunacion);
        ControlVacunacionDTO savedControlVacunacionDTO = convertEntityToDto(savedControlVacunacion);
        return new ResponseEntity<>(savedControlVacunacionDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ControlVacunacionDTO>> getAllControlVacunaciones() {
        List<ControlVacunacion> controlVacunaciones = controlVacunacionService.listAllControlVacunaciones();
        List<ControlVacunacionDTO> controlVacunacionDTOs = convertEntitiesToDTOs(controlVacunaciones);
        return new ResponseEntity<>(controlVacunacionDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ControlVacunacionDTO> getControlVacunacionById(@PathVariable Long id) {
        ControlVacunacion controlVacunacion = controlVacunacionService.getControlVacunacionById(id);
        ControlVacunacionDTO controlVacunacionDTO = convertEntityToDto(controlVacunacion);
        return new ResponseEntity<>(controlVacunacionDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ControlVacunacionDTO> updateControlVacunacion(@PathVariable Long id, @RequestBody ControlVacunacionDTO controlVacunacionDTO) {
        ControlVacunacion updatedControlVacunacion = controlVacunacionService.updateControlVacunacion(id, convertDtoToEntity(controlVacunacionDTO));
        if (updatedControlVacunacion != null) {
            ControlVacunacionDTO updatedControlVacunacionDTO = convertEntityToDto(updatedControlVacunacion);
            return ResponseEntity.ok(updatedControlVacunacionDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteControlVacunacion(@PathVariable Long id) {
        controlVacunacionService.deleteControlVacunacion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/tipo/{prefix}")
    public ResponseEntity<List<ControlVacunacionDTO>> getListTipo(@PathVariable String prefix) {
        List<ControlVacunacion> controlVacunaciones = controlVacunacionService.getListTipo(prefix);
        List<ControlVacunacionDTO> controlVacunacionDTOs = convertEntitiesToDTOs(controlVacunaciones);
        return new ResponseEntity<>(controlVacunacionDTOs, HttpStatus.OK);
    }

    @GetMapping("/estado/{prefix}")
    public ResponseEntity<List<ControlVacunacionDTO>> getListEstado(@PathVariable String prefix) {
        List<ControlVacunacion> controlVacunaciones = controlVacunacionService.getListEstado(prefix);
        List<ControlVacunacionDTO> controlVacunacionDTOs = convertEntitiesToDTOs(controlVacunaciones);
        return new ResponseEntity<>(controlVacunacionDTOs, HttpStatus.OK);
    }

    @GetMapping("/nombre/{prefix}")
    public ResponseEntity<List<ControlVacunacionDTO>> getListNombre(@PathVariable String prefix) {
        List<ControlVacunacion> controlVacunaciones = controlVacunacionService.getListNombre(prefix);
        List<ControlVacunacionDTO> controlVacunacionDTOs = convertEntitiesToDTOs(controlVacunaciones);
        return new ResponseEntity<>(controlVacunacionDTOs, HttpStatus.OK);
    }

    @GetMapping("/lugar/{prefix}")
    public ResponseEntity<List<ControlVacunacionDTO>> getListLugar(@PathVariable String prefix) {
        List<ControlVacunacion> controlVacunaciones = controlVacunacionService.getListLugar(prefix);
        List<ControlVacunacionDTO> controlVacunacionDTOs = convertEntitiesToDTOs(controlVacunaciones);
        return new ResponseEntity<>(controlVacunacionDTOs, HttpStatus.OK);
    }

    // Métodos de conversión DTO a Entidad y viceversa
    private ControlVacunacion convertDtoToEntity(ControlVacunacionDTO controlVacunacionDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(controlVacunacionDTO, ControlVacunacion.class);
    }

    private ControlVacunacionDTO convertEntityToDto(ControlVacunacion controlVacunacion) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(controlVacunacion, ControlVacunacionDTO.class);
    }

    private List<ControlVacunacionDTO> convertEntitiesToDTOs(List<ControlVacunacion> controlVacunaciones) {
        return controlVacunaciones.stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }
}
