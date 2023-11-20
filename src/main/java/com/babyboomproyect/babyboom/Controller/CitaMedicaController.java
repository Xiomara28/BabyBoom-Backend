package com.babyboomproyect.babyboom.Controller;

import com.babyboomproyect.babyboom.DTO.CitaMedicaDTO;
import com.babyboomproyect.babyboom.entities.Apoderado;
import com.babyboomproyect.babyboom.entities.CitaMedica;
import com.babyboomproyect.babyboom.entities.Medico;
import com.babyboomproyect.babyboom.service.ApoderadoService;
import com.babyboomproyect.babyboom.service.CitaMedicaService;
import com.babyboomproyect.babyboom.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/citasmedicas")
public class CitaMedicaController {

    @Autowired
    private CitaMedicaService citaMedicaService;
    @Autowired
    private MedicoService medicoService;  // Asegúrate de inyectar este servicio

    @Autowired
    private ApoderadoService apoderadoService;

    @PostMapping
    public ResponseEntity<CitaMedicaDTO> createCitaMedica(@RequestBody CitaMedicaDTO citaMedicaDTO) {
        CitaMedica citaMedica = convertDTOToEntity(citaMedicaDTO);
        CitaMedica savedCitaMedica = citaMedicaService.saveCitaMedica(citaMedica);
        CitaMedicaDTO savedCitaMedicaDTO = convertEntityToDTO(savedCitaMedica);
        return ResponseEntity.ok(savedCitaMedicaDTO);
    }

    @GetMapping
    public ResponseEntity<List<CitaMedicaDTO>> getAllCitasMedicas() {
        List<CitaMedica> citasMedicas = citaMedicaService.listAllCitasMedicas();
        List<CitaMedicaDTO> citaMedicaDTOs = convertEntitiesToDTOs(citasMedicas);
        return ResponseEntity.ok(citaMedicaDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CitaMedicaDTO> getCitaMedicaById(@PathVariable Long id) {
        Optional<CitaMedica> optionalCitaMedica = citaMedicaService.getCitaMedicaById(id);
        if (optionalCitaMedica.isPresent()) {
            CitaMedicaDTO citaMedicaDTO = convertEntityToDTO(optionalCitaMedica.get());
            return ResponseEntity.ok(citaMedicaDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CitaMedicaDTO> updateCitaMedica(@PathVariable Long id, @RequestBody CitaMedicaDTO citaMedicaDTO) {
        Optional<CitaMedica> existingCitaMedica = citaMedicaService.getCitaMedicaById(id);
        if (existingCitaMedica.isPresent()) {
            CitaMedica updatedCitaMedica = citaMedicaService.updateCitaMedica(id, convertDTOToEntity(citaMedicaDTO));
            if (updatedCitaMedica != null) {
                CitaMedicaDTO updatedCitaMedicaDTO = convertEntityToDTO(updatedCitaMedica);
                return ResponseEntity.ok(updatedCitaMedicaDTO);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCitaMedicaById(@PathVariable Long id) {
        citaMedicaService.deleteCitaMedicaById(id);
        return ResponseEntity.noContent().build();
    }

    // Métodos de conversión DTO a Entidad y viceversa


    private CitaMedica convertDTOToEntity(CitaMedicaDTO citaMedicaDTO) {
        CitaMedica citaMedica = new CitaMedica();
        citaMedica.setIdCitaMedica(citaMedicaDTO.getIdCitaMedica());

        Medico medico = medicoService.getMedicoById(citaMedicaDTO.getIdMedico());
        Apoderado apoderado = apoderadoService.getApoderadoById(citaMedicaDTO.getIdApoderado());

        citaMedica.setMedico(medico);
        citaMedica.setApoderado(apoderado);

        citaMedica.setTituloCita(citaMedicaDTO.getTituloCita());
        citaMedica.setFecha(new java.sql.Date(citaMedicaDTO.getFecha().getTime())); // Convirtiendo a java.sql.Date
        citaMedica.setLugar(citaMedicaDTO.getLugar());
        citaMedica.setNombreClinica(citaMedicaDTO.getNombreClinica());
        return citaMedica;
    }

    private CitaMedicaDTO convertEntityToDTO(CitaMedica citaMedica) {
        CitaMedicaDTO citaMedicaDTO = new CitaMedicaDTO();
        citaMedicaDTO.setIdCitaMedica(citaMedica.getIdCitaMedica());
        citaMedicaDTO.setIdMedico(citaMedica.getIdMedico());
        citaMedicaDTO.setIdApoderado(citaMedica.getIdApoderado());
        citaMedicaDTO.setTituloCita(citaMedica.getTituloCita());
        // Asumiendo que 'getFecha()' en tu DTO devuelve un java.util.Date
        citaMedicaDTO.setFecha(new java.util.Date(citaMedica.getFecha().getTime()));
        citaMedicaDTO.setLugar(citaMedica.getLugar());
        citaMedicaDTO.setNombreClinica(citaMedica.getNombreClinica());
        return citaMedicaDTO;
    }


    private List<CitaMedicaDTO> convertEntitiesToDTOs(List<CitaMedica> citasMedicas) {
        return citasMedicas.stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }
}
