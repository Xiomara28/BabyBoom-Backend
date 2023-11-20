package com.babyboomproyect.babyboom.repository;

import com.babyboomproyect.babyboom.entities.BebeControlVacunacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BebeControlVacunacionRepository extends JpaRepository<BebeControlVacunacion, Long> {
    // Agrega métodos específicos si es necesario
}
