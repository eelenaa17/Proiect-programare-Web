package com.awbd5.awbd5.services;

import java.util.List;
import java.util.Optional;

import com.awbd5.awbd5.domain.Lectura;

public interface LecturaService {


    Optional<Lectura> findById(Long id);
    Lectura save(Lectura lectura);
    List<Lectura> findAll();
    List<Lectura> getAllLecturi();
}
