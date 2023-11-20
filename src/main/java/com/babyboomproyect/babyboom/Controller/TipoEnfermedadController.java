package com.babyboomproyect.babyboom.Controller;

import com.babyboomproyect.babyboom.DTO.TipoEnfermedadDTO;
import com.babyboomproyect.babyboom.entities.TipoEnfermedad;
import com.babyboomproyect.babyboom.service.TipoEnfermedadService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tipoEnfermedad")
public class TipoEnfermedadController {

    @Autowired
    private TipoEnfermedadService tipoEnfermedadService;

    @PostMapping
    public ResponseEntity<TipoEnfermedadDTO> createTipoEnfermedad(@RequestBody @Valid TipoEnfermedadDTO tipoEnfermedadDTO) {
        TipoEnfermedad tipoEnfermedad = convertDtoToEntity(tipoEnfermedadDTO);
        TipoEnfermedad savedTipoEnfermedad = tipoEnfermedadService.saveTipoEnfermedad(tipoEnfermedad);
        TipoEnfermedadDTO savedTipoEnfermedadDTO = convertEntityToDto(savedTipoEnfermedad);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTipoEnfermedadDTO);
    }

    @GetMapping
    public ResponseEntity<List<TipoEnfermedadDTO>> getAllTipoEnfermedades() {
        List<TipoEnfermedad> tipoEnfermedades = tipoEnfermedadService.listAllTipoEnfermedades();
        List<TipoEnfermedadDTO> tipoEnfermedadDTOs = convertEntitiesToDTOs(tipoEnfermedades);
        return new ResponseEntity<>(tipoEnfermedadDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoEnfermedadDTO> getTipoEnfermedadById(@PathVariable Long id) {
        TipoEnfermedad tipoEnfermedad = tipoEnfermedadService.getTipoEnfermedadById(id);
        TipoEnfermedadDTO tipoEnfermedadDTO = convertEntityToDto(tipoEnfermedad);
        return new ResponseEntity<>(tipoEnfermedadDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoEnfermedadDTO> updateTipoEnfermedad(@PathVariable Long id, @RequestBody TipoEnfermedadDTO tipoEnfermedadDTO) {
        TipoEnfermedad updatedTipoEnfermedad = tipoEnfermedadService.updateTipoEnfermedad(id, convertDtoToEntity(tipoEnfermedadDTO));
        if (updatedTipoEnfermedad != null) {
            TipoEnfermedadDTO updatedTipoEnfermedadDTO = convertEntityToDto(updatedTipoEnfermedad);
            return ResponseEntity.ok(updatedTipoEnfermedadDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoEnfermedad(@PathVariable Long id) {
        tipoEnfermedadService.deleteTipoEnfermedad(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/tipo/{tipoTipoEnfermedad}")
    public ResponseEntity<List<TipoEnfermedadDTO>> findAllByTipoTipoEnfermedad(@PathVariable String tipoTipoEnfermedad) {
        List<TipoEnfermedad> tipoEnfermedades = tipoEnfermedadService.findAllByTipoTipoEnfermedad(tipoTipoEnfermedad);
        List<TipoEnfermedadDTO> tipoEnfermedadDTOs = convertEntitiesToDTOs(tipoEnfermedades);
        return new ResponseEntity<>(tipoEnfermedadDTOs, HttpStatus.OK);
    }

    @GetMapping("/nombre/{nombreTipoEnfermedad}")
    public ResponseEntity<List<TipoEnfermedadDTO>> findByNombreTipoEnfermedad(@PathVariable String nombreTipoEnfermedad) {
        List<TipoEnfermedad> tipoEnfermedades = tipoEnfermedadService.findByNombreTipoEnfermedad(nombreTipoEnfermedad);
        List<TipoEnfermedadDTO> tipoEnfermedadDTOs = convertEntitiesToDTOs(tipoEnfermedades);
        return new ResponseEntity<>(tipoEnfermedadDTOs, HttpStatus.OK);
    }

    // Métodos de conversión DTO a Entidad y viceversa
    private TipoEnfermedad convertDtoToEntity(TipoEnfermedadDTO tipoEnfermedadDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(tipoEnfermedadDTO, TipoEnfermedad.class);
    }

    private TipoEnfermedadDTO convertEntityToDto(TipoEnfermedad tipoEnfermedad) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(tipoEnfermedad, TipoEnfermedadDTO.class);
    }

    private List<TipoEnfermedadDTO> convertEntitiesToDTOs(List<TipoEnfermedad> tipoEnfermedades) {
        return tipoEnfermedades.stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    // Añade manejo de excepciones para ResponseEntity en lugar de HttpResponse
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
