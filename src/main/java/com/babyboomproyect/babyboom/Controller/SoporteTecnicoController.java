package com.babyboomproyect.babyboom.Controller;

import com.babyboomproyect.babyboom.DTO.SoporteTecnicoDTO;
import com.babyboomproyect.babyboom.entities.SoporteTecnico;
import com.babyboomproyect.babyboom.service.SoporteTecnicoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/soporteTecnico")
public class SoporteTecnicoController {

    @Autowired
    private SoporteTecnicoService soporteTecnicoService;

    @PostMapping
    public ResponseEntity<SoporteTecnicoDTO> createSoporteTecnico(@RequestBody SoporteTecnicoDTO soporteTecnicoDTO) {
        SoporteTecnico soporteTecnico = convertDtoToEntity(soporteTecnicoDTO);
        SoporteTecnico savedSoporteTecnico = soporteTecnicoService.saveSoporteTecnico(soporteTecnico);
        SoporteTecnicoDTO savedSoporteTecnicoDTO = convertEntityToDto(savedSoporteTecnico);
        return new ResponseEntity<>(savedSoporteTecnicoDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SoporteTecnicoDTO>> getAllSoporteTecnicos() {
        List<SoporteTecnico> soporteTecnicos = soporteTecnicoService.listAllSoporteTecnicos();
        List<SoporteTecnicoDTO> soporteTecnicoDTOs = convertEntitiesToDTOs(soporteTecnicos);
        return new ResponseEntity<>(soporteTecnicoDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SoporteTecnicoDTO> getSoporteTecnicoById(@PathVariable Long id) {
        SoporteTecnico soporteTecnico = soporteTecnicoService.getSoporteTecnicoById(id);
        SoporteTecnicoDTO soporteTecnicoDTO = convertEntityToDto(soporteTecnico);
        return new ResponseEntity<>(soporteTecnicoDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SoporteTecnicoDTO> updateSoporteTecnico(@PathVariable Long id, @RequestBody SoporteTecnicoDTO soporteTecnicoDTO) {
        SoporteTecnico updatedSoporteTecnico = soporteTecnicoService.updateSoporteTecnico(id, convertDtoToEntity(soporteTecnicoDTO));
        if (updatedSoporteTecnico != null) {
            SoporteTecnicoDTO updatedSoporteTecnicoDTO = convertEntityToDto(updatedSoporteTecnico);
            return ResponseEntity.ok(updatedSoporteTecnicoDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSoporteTecnico(@PathVariable Long id) {
        soporteTecnicoService.deleteSoporteTecnico(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Métodos de conversión DTO a Entidad y viceversa
    private SoporteTecnico convertDtoToEntity(SoporteTecnicoDTO soporteTecnicoDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(soporteTecnicoDTO, SoporteTecnico.class);
    }

    private SoporteTecnicoDTO convertEntityToDto(SoporteTecnico soporteTecnico) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(soporteTecnico, SoporteTecnicoDTO.class);
    }

    private List<SoporteTecnicoDTO> convertEntitiesToDTOs(List<SoporteTecnico> soporteTecnicos) {
        return soporteTecnicos.stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }
}
