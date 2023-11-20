package com.babyboomproyect.babyboom.repository;

import com.babyboomproyect.babyboom.entities.Bebe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BebeRepository extends JpaRepository<Bebe, Long> {
    @Query("SELECT bt.bebe FROM BebeTipoEnfermedad bt JOIN bt.tipoEnfermedad te WHERE te.nombreEnfermedad = :nombreTipoEnfermedad")
    List<Bebe> findByTipoEnfermedad_NombreEnfermedad(@Param("nombreTipoEnfermedad") String nombreTipoEnfermedad);



}

