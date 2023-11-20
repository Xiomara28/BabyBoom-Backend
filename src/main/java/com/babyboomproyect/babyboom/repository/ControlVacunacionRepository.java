package com.babyboomproyect.babyboom.repository;

import com.babyboomproyect.babyboom.entities.ControlVacunacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ControlVacunacionRepository extends JpaRepository<ControlVacunacion, Long> {

    @Query("select c from ControlVacunacion c where c.tipoVacuna like %:prefix%")
    List<ControlVacunacion> getListTipo(@Param("prefix") String prefix);

    @Query("select c from ControlVacunacion c where c.estadoVacunacion like %:prefix%")
    List<ControlVacunacion> getListEstado(@Param("prefix") String prefix);

    @Query("select c from ControlVacunacion c where c.nombreVacunador like %:prefix%")
    List<ControlVacunacion> getListNombre(@Param("prefix") String prefix);

    @Query("select c from ControlVacunacion c where c.lugar like %:prefix%")
    List<ControlVacunacion> getListLugar(@Param("prefix") String prefix);
}
