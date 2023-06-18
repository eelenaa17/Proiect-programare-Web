package com.awbd5.awbd5.services;

import com.awbd5.awbd5.domain.Categorie;
import com.awbd5.awbd5.repositories.CategorieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieServiceImpl implements CategorieService {

    private final CategorieRepository categorieRepository;

    public CategorieServiceImpl(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    @Override
    public List<Categorie> findAll() {
        return categorieRepository.findAll();
    }
}