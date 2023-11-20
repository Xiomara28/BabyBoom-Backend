package com.babyboomproyect.babyboom.repository;

import com.babyboomproyect.babyboom.entities.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    // Puedes agregar métodos personalizados si es necesario
}
