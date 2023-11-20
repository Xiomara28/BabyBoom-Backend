package com.babyboomproyect.babyboom.Controller;
import com.babyboomproyect.babyboom.entities.ControlVacunacion;
import com.babyboomproyect.babyboom.entities.TipoEnfermedad;
import com.babyboomproyect.babyboom.repository.ApoderadoRepository;
import com.babyboomproyect.babyboom.repository.BebeRepository;
import com.babyboomproyect.babyboom.DTO.BebeDTO;
import com.babyboomproyect.babyboom.entities.Apoderado;
import com.babyboomproyect.babyboom.entities.Bebe;
import com.babyboomproyect.babyboom.service.ApoderadoService;
import com.babyboomproyect.babyboom.service.BebeService;
import com.babyboomproyect.babyboom.service.ControlVacunacionService;
import com.babyboomproyect.babyboom.service.TipoEnfermedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/bebes")
public class BebeController {

    @Autowired
    private BebeService bebeService;

    @Autowired
    private TipoEnfermedadService tipoEnfermedadService;

    @Autowired
    private ControlVacunacionService controlVacunacionService;

    @Autowired
    private BebeRepository bebeRepository;

    @Autowired
    private ApoderadoService apoderadoService;

    @PostMapping
    public ResponseEntity<BebeDTO> createBebe(@RequestBody @Valid BebeDTO bebeDTO) {
        Bebe bebe = convertDTOToEntity(bebeDTO);
        Apoderado apoderado = apoderadoService.getApoderadoById(bebeDTO.getApoderado().getIdApoderado());
        bebe.setApoderado(apoderado);
        Bebe savedBebe = bebeService.saveBebe(bebe);
        BebeDTO savedBebeDTO = convertEntityToDTO(savedBebe);
        return ResponseEntity.ok(savedBebeDTO);
    }


    @GetMapping
    public ResponseEntity<List<BebeDTO>> getAllBebes() {
        List<Bebe> bebes = bebeService.listAllBebes();
        List<BebeDTO> bebeDTOs = convertEntitiesToDTOs(bebes);
        return ResponseEntity.ok(bebeDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BebeDTO> getBebeById(@PathVariable Long id) {
        Bebe bebe = bebeService.getBebeById(id);
        if (bebe != null) {
            BebeDTO bebeDTO = convertEntityToDTO(bebe);
            return ResponseEntity.ok(bebeDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBebeById(@PathVariable Long id) {
        bebeService.deleteBebeById(id);
        return ResponseEntity.noContent().build();
    }



    @GetMapping("/enfermedad/{nombre}")
    public ResponseEntity<List<BebeDTO>> getBebesByTipoEnfermedad(@PathVariable String nombre) {
        List<Bebe> bebes = bebeService.findAllByTipoEnfermedad_NombreTipoEnfermedad(nombre);
        List<BebeDTO> bebeDTOs = convertEntitiesToDTOs(bebes);
        return ResponseEntity.ok(bebeDTOs);
    }

    @PostMapping("/{idBebe}/asignarEnfermedad")
    public ResponseEntity<Void> asignarEnfermedad(@PathVariable Long idBebe, @RequestBody Map<String, Long> ids) {
        Long idEnfermedad = ids.get("idEnfermedad");

        Bebe bebe = bebeService.getBebeById(idBebe);
        TipoEnfermedad enfermedad = tipoEnfermedadService.getTipoEnfermedadById(idEnfermedad);

        if (bebe != null && enfermedad != null) {
            bebeService.asignarEnfermedad(bebe, enfermedad);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{idBebe}/asignarControlVacunacion/{idControlVacunacion}")
    public ResponseEntity<Void> asignarControlVacunacion(
            @PathVariable Long idBebe,
            @PathVariable Long idControlVacunacion) {

        Bebe bebe = bebeService.getBebeById(idBebe);
        ControlVacunacion controlVacunacion = controlVacunacionService.getControlVacunacionById(idControlVacunacion);

        if (bebe != null && controlVacunacion != null) {
            bebeService.asignarControlVacunacion(bebe, controlVacunacion);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<BebeDTO> updateBebe(@PathVariable Long id, @RequestBody BebeDTO bebeDTO) {
        Bebe updatedBebe = bebeService.updateBebe(id, convertDTOToEntity(bebeDTO));
        if (updatedBebe != null) {
            BebeDTO updatedBebeDTO = convertEntityToDTO(updatedBebe);
            return ResponseEntity.ok(updatedBebeDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    // Métodos de conversión DTO a Entidad y viceversa
    private Bebe convertDTOToEntity(BebeDTO bebeDTO) {
        Bebe bebe = new Bebe();
        bebe.setIdBebe(bebeDTO.getIdBebe());
        bebe.setNombreBebe(bebeDTO.getNombreBebe());
        bebe.setFechaBebe(bebeDTO.getFechaBebe());
        // Agrega aquí más asignaciones según la estructura de tu entidad
        return bebe;
    }

    private BebeDTO convertEntityToDTO(Bebe bebe) {
        BebeDTO bebeDTO = new BebeDTO();
        bebeDTO.setIdBebe(bebe.getIdBebe());
        bebeDTO.setNombreBebe(bebe.getNombreBebe());
        bebeDTO.setFechaBebe(bebe.getFechaBebe());
        // Agrega aquí más asignaciones según la estructura de tu DTO
        return bebeDTO;
    }

    private List<BebeDTO> convertEntitiesToDTOs(List<Bebe> bebes) {
        return bebes.stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    // Añade manejo de excepciones para ResponseEntity en lugar de HttpResponse
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Datos de entrada no válidos");
    }
}

