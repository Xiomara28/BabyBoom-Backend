package com.babyboomproyect.babyboom.service;

import com.babyboomproyect.babyboom.entities.Apoderado;

import java.util.List;

public interface ApoderadoService {
    Apoderado saveApoderado(Apoderado apoderado);
    List<Apoderado> listAllApoderados();
    void deleteApoderado(Long id);
    Apoderado getApoderadoById(Long id);
    Apoderado updateApoderado(Long id, Apoderado apoderado);

}
