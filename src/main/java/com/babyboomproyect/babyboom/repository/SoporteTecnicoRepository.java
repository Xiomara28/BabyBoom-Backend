package com.babyboomproyect.babyboom.repository;

import com.babyboomproyect.babyboom.entities.SoporteTecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoporteTecnicoRepository extends JpaRepository<SoporteTecnico, Long> {
    // Puedes agregar métodos personalizados si es necesario
}
