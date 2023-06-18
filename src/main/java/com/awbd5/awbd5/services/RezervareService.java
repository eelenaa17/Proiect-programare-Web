package com.awbd5.awbd5.services;

import com.awbd5.awbd5.domain.Rezervare;
import java.util.List;

public interface RezervareService {

    List<Rezervare> findAll();
    boolean findById(Long id);
    Rezervare save(Rezervare rezervare);
    void deleteById(Long id);
    void addReservation(Rezervare rezervare);
    boolean existsByUtilizatorId(Long utilizatorId);
}
