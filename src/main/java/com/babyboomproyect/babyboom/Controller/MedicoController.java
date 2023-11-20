package com.babyboomproyect.babyboom.Controller;

import com.babyboomproyect.babyboom.DTO.MedicoDTO;
import com.babyboomproyect.babyboom.entities.Medico;
import com.babyboomproyect.babyboom.service.MedicoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @PostMapping
    public ResponseEntity<MedicoDTO> createMedico(@RequestBody MedicoDTO medicoDTO) {
        Medico medico = convertDtoToEntity(medicoDTO);
        Medico savedMedico = medicoService.saveMedico(medico);
        MedicoDTO savedMedicoDTO = convertEntityToDto(savedMedico);
        return new ResponseEntity<>(savedMedicoDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MedicoDTO>> getAllMedicos() {
        List<Medico> medicos = medicoService.listAllMedicos();
        List<MedicoDTO> medicoDTOs = convertEntitiesToDTOs(medicos);
        return new ResponseEntity<>(medicoDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoDTO> getMedicoById(@PathVariable Long id) {
        Medico medico = medicoService.getMedicoById(id);
        MedicoDTO medicoDTO = convertEntityToDto(medico);
        return new ResponseEntity<>(medicoDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicoDTO> updateMedico(@PathVariable Long id, @RequestBody MedicoDTO medicoDTO) {
        Medico updatedMedico = medicoService.updateMedico(id, convertDtoToEntity(medicoDTO));
        if (updatedMedico != null) {
            MedicoDTO updatedMedicoDTO = convertEntityToDto(updatedMedico);
            return ResponseEntity.ok(updatedMedicoDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedico(@PathVariable Long id) {
        medicoService.deleteMedico(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Métodos de conversión DTO a Entidad y viceversa
    private Medico convertDtoToEntity(MedicoDTO medicoDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(medicoDTO, Medico.class);
    }

    private MedicoDTO convertEntityToDto(Medico medico) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(medico, MedicoDTO.class);
    }

    private List<MedicoDTO> convertEntitiesToDTOs(List<Medico> medicos) {
        return medicos.stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }
}
