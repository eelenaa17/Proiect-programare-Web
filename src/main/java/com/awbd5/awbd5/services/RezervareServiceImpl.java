package com.awbd5.awbd5.services;

import com.awbd5.awbd5.domain.Rezervare;
import com.awbd5.awbd5.repositories.RezervareRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RezervareServiceImpl implements RezervareService{
    private final RezervareRepository rezervareRepository;

    public RezervareServiceImpl(RezervareRepository rezervareRepository) {
        this.rezervareRepository = rezervareRepository;
    }

    public List<Rezervare> findAll() {
        return rezervareRepository.findAll();
    }

    @Override
    public boolean findById(Long id) {
        return false;
    }


    public Rezervare save(Rezervare rezervare) {
        rezervareRepository.save(rezervare);
        return rezervare;
    }
    public void deleteById(Long id) {
        rezervareRepository.deleteById(id);
    }
    @Override
    public void addReservation(Rezervare rezervare) {
    }
    @Override
    public boolean existsByUtilizatorId(Long utilizatorId) {
        return false;
    }

}
