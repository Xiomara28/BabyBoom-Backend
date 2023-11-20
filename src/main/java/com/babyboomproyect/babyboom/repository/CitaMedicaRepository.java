package com.babyboomproyect.babyboom.repository;

import com.babyboomproyect.babyboom.entities.CitaMedica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaMedicaRepository extends JpaRepository<CitaMedica, Long> {
    // Puedes agregar consultas específicas si es necesario
}
