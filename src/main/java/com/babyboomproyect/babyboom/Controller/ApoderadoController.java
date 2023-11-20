package com.babyboomproyect.babyboom.Controller;

import com.babyboomproyect.babyboom.DTO.ApoderadoDTO;
import com.babyboomproyect.babyboom.entities.Apoderado;
import com.babyboomproyect.babyboom.service.ApoderadoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/apoderados")
public class ApoderadoController {

    @Autowired
    private ApoderadoService apoderadoService;

    @PostMapping
    public ResponseEntity<ApoderadoDTO> createApoderado(@RequestBody ApoderadoDTO apoderadoDTO) {
        Apoderado apoderado = convertDtoToEntity(apoderadoDTO);
        Apoderado savedApoderado = apoderadoService.saveApoderado(apoderado);
        ApoderadoDTO savedApoderadoDTO = convertEntityToDto(savedApoderado);
        return new ResponseEntity<>(savedApoderadoDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ApoderadoDTO>> getAllApoderados() {
        List<Apoderado> apoderados = apoderadoService.listAllApoderados();
        List<ApoderadoDTO> apoderadoDTOs = convertEntitiesToDTOs(apoderados);
        return new ResponseEntity<>(apoderadoDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApoderadoDTO> getApoderadoById(@PathVariable Long id) {
        Apoderado apoderado = apoderadoService.getApoderadoById(id);
        ApoderadoDTO apoderadoDTO = convertEntityToDto(apoderado);
        return new ResponseEntity<>(apoderadoDTO, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApoderadoDTO> updateApoderado(@PathVariable Long id, @RequestBody ApoderadoDTO apoderadoDTO) {
        Apoderado updatedApoderado = apoderadoService.updateApoderado(id, convertDtoToEntity(apoderadoDTO));
        if (updatedApoderado != null) {
            ApoderadoDTO updatedApoderadoDTO = convertEntityToDto(updatedApoderado);
            return ResponseEntity.ok(updatedApoderadoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApoderado(@PathVariable Long id) {
        apoderadoService.deleteApoderado(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




    // Métodos de conversión DTO a Entidad y viceversa
    private Apoderado convertDtoToEntity(ApoderadoDTO apoderadoDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(apoderadoDTO, Apoderado.class);
    }

    private ApoderadoDTO convertEntityToDto(Apoderado apoderado) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(apoderado, ApoderadoDTO.class);
    }

    private List<ApoderadoDTO> convertEntitiesToDTOs(List<Apoderado> apoderados) {
        return apoderados.stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

}
