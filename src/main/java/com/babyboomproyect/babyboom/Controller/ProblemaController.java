package com.babyboomproyect.babyboom.Controller;

import com.babyboomproyect.babyboom.DTO.ProblemaDTO;
import com.babyboomproyect.babyboom.entities.Apoderado;
import com.babyboomproyect.babyboom.entities.Problema;
import com.babyboomproyect.babyboom.entities.SoporteTecnico;
import com.babyboomproyect.babyboom.service.ApoderadoService;
import com.babyboomproyect.babyboom.service.ProblemaService;
import com.babyboomproyect.babyboom.service.SoporteTecnicoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/problemas")
public class ProblemaController {

    @Autowired
    private ProblemaService problemaService;
    @Autowired
    private ApoderadoService apoderadoService;
    @Autowired
    private SoporteTecnicoService soporteTecnicoService;

    @PostMapping
    public ResponseEntity<ProblemaDTO> createProblema(@RequestBody ProblemaDTO problemaDTO) {
        Problema problema = convertDTOToEntity(problemaDTO);

        // Obtener instancias de Apoderado y SoporteTecnico
        Apoderado apoderado = apoderadoService.getApoderadoById(problemaDTO.getIdApoderado());
        SoporteTecnico soporteTecnico = soporteTecnicoService.getSoporteTecnicoById(problemaDTO.getIdSoporteTecnico());

        // Asignar las instancias a la entidad Problema
        problema.setApoderado(apoderado);
        problema.setSoporteTecnico(soporteTecnico);

        Problema savedProblema = problemaService.saveProblema(problema);
        ProblemaDTO savedProblemaDTO = convertEntityToDTO(savedProblema);
        return ResponseEntity.ok(savedProblemaDTO);
    }


    @GetMapping
    public ResponseEntity<List<ProblemaDTO>> getAllProblemas() {
        List<Problema> problemas = problemaService.listAllProblemas();
        List<ProblemaDTO> problemaDTOs = convertEntitiesToDTOs(problemas);
        return ResponseEntity.ok(problemaDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProblemaDTO> getProblemaById(@PathVariable Long id) {
        Optional<Problema> optionalProblema = problemaService.getProblemaById(id);
        if (optionalProblema.isPresent()) {
            ProblemaDTO problemaDTO = convertEntityToDTO(optionalProblema.get());
            return ResponseEntity.ok(problemaDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/byTitulo/{titulo}")
    public ResponseEntity<ProblemaDTO> getProblemaByTitulo(@PathVariable String titulo) {
        Optional<Problema> optionalProblema = problemaService.getProblemaByTitulo(titulo);
        if (optionalProblema.isPresent()) {
            ProblemaDTO problemaDTO = convertEntityToDTO(optionalProblema.get());
            return ResponseEntity.ok(problemaDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/byDescripcion/{descripcion}")
    public ResponseEntity<List<ProblemaDTO>> getProblemaByDescripcion(@PathVariable String descripcion) {
        List<Problema> problemas = problemaService.getProblemaByDescripcion(descripcion);
        List<ProblemaDTO> problemaDTOs = convertEntitiesToDTOs(problemas);
        return ResponseEntity.ok(problemaDTOs);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProblemaDTO> updateProblema(@PathVariable Long id, @RequestBody ProblemaDTO problemaDTO) {
        Problema updatedProblema = problemaService.updateProblema(id, convertDTOToEntity(problemaDTO));
        if (updatedProblema != null) {
            ProblemaDTO updatedProblemaDTO = convertEntityToDTO(updatedProblema);
            return ResponseEntity.ok(updatedProblemaDTO);
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProblemaById(@PathVariable Long id) {
        problemaService.deleteProblemaById(id);
        return ResponseEntity.noContent().build();
    }

    // Métodos de conversión DTO a Entidad y viceversa
    private Problema convertDTOToEntity(ProblemaDTO problemaDTO) {
        Problema problema = new Problema();
        BeanUtils.copyProperties(problemaDTO, problema);
        // Puedes realizar otras asignaciones específicas si es necesario
        return problema;
    }

    private ProblemaDTO convertEntityToDTO(Problema problema) {
        ProblemaDTO problemaDTO = new ProblemaDTO();
        BeanUtils.copyProperties(problema, problemaDTO);
        // Puedes realizar otras asignaciones específicas si es necesario
        return problemaDTO;
    }

    private List<ProblemaDTO> convertEntitiesToDTOs(List<Problema> problemas) {
        return problemas.stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }
}
