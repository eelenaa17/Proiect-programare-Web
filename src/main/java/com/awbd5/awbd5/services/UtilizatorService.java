package com.awbd5.awbd5.services;

import com.awbd5.awbd5.domain.Utilizator;
import java.util.List;
import java.util.Optional;


public interface UtilizatorService {
    List<Utilizator> findAll();
    Optional<Utilizator> findById(Long id);
    Utilizator save(Utilizator utilizator);
    void deleteById(Long id);
    Utilizator findByName(String utilizatorName);
    void saveOrUpdateUtilizator(Utilizator updatedUtilizator);

}