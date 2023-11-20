package com.babyboomproyect.babyboom.repository;

import com.babyboomproyect.babyboom.entities.TipoEnfermedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoEnfermedadRepository extends JpaRepository<TipoEnfermedad, Long> {

    @Query("SELECT te FROM TipoEnfermedad te WHERE te.tipoTipoEnfermedad = :tipoTipoEnfermedad")
    List<TipoEnfermedad> findAllByTipoTipoEnfermedad(@Param("tipoTipoEnfermedad") String tipoTipoEnfermedad);

    // Actualiza el nombre del método para que coincida con el campo en la entidad
    List<TipoEnfermedad> findByNombreEnfermedad(String nombreEnfermedad);
}


