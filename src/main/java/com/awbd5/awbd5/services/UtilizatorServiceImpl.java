package com.awbd5.awbd5.services;
import com.awbd5.awbd5.domain.Utilizator;
import com.awbd5.awbd5.repositories.UtilizatorRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UtilizatorServiceImpl implements UtilizatorService {
    private final UtilizatorRepository utilizatorRepository;
    public UtilizatorServiceImpl(UtilizatorRepository utilizatorRepository) {
        this.utilizatorRepository = utilizatorRepository;
    }
    @Override
    public List<Utilizator> findAll() {
        return utilizatorRepository.findAll();
    }
    @Override
    public Optional<Utilizator> findById(Long id) {
        return utilizatorRepository.findById(id);
    }
    @Override
    public Utilizator save(Utilizator utilizator) {
        return utilizatorRepository.save(utilizator);
    }
    @Override
    public void deleteById(Long id) {
        utilizatorRepository.deleteById(id);
    }
    @Override
    public Utilizator findByName(String utilizatorName) {
        return null;
    }
    @Override
    public void saveOrUpdateUtilizator(Utilizator updatedUtilizator) {
    }
}
