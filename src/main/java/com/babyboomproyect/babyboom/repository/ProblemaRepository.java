package com.babyboomproyect.babyboom.repository;

import com.babyboomproyect.babyboom.entities.Problema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProblemaRepository extends JpaRepository<Problema, Long> {

    @Query("SELECT p FROM Problema p WHERE p.titulo = :titulo")
    Optional<Problema> findByTitulo(@Param("titulo") String titulo);

    @Query("SELECT p FROM Problema p WHERE p.descripcion = :descripcion")
    List<Problema> findByDescripcion(@Param("descripcion") String descripcion);
}
