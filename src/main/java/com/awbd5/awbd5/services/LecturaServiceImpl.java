package com.awbd5.awbd5.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awbd5.awbd5.domain.Lectura;
import com.awbd5.awbd5.repositories.LecturaRepository;

@Service
public class LecturaServiceImpl implements LecturaService {

    private final LecturaRepository lecturaRepository;

    @Autowired
    public LecturaServiceImpl(LecturaRepository lecturaRepository) {
        this.lecturaRepository = lecturaRepository;
    }

    @Override
    public List<Lectura> getAllLecturi() {
        return lecturaRepository.findAll();
    }

    @Override
    public Optional<Lectura> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Lectura save(Lectura lectura) {
        return lecturaRepository.save(lectura);
    }

    @Override
    public List<Lectura> findAll() {
        return lecturaRepository.findAll();
    }

}
