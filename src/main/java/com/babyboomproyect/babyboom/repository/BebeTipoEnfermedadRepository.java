package com.babyboomproyect.babyboom.repository;

import com.babyboomproyect.babyboom.entities.BebeTipoEnfermedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BebeTipoEnfermedadRepository extends JpaRepository<BebeTipoEnfermedad, Long> {
    // Puedes agregar métodos personalizados si es necesario
}
