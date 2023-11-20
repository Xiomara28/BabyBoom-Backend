package com.babyboomproyect.babyboom.repository;

import com.babyboomproyect.babyboom.entities.Apoderado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApoderadoRepository extends JpaRepository<Apoderado, Long> {
}
