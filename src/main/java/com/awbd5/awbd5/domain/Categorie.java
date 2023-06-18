package com.awbd5.awbd5.domain;

import jakarta.persistence.*;
@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descriere;
    public Categorie() {
    }
    public Categorie(String descriere) {
        this.descriere = descriere;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDescriere() {
        return descriere;
    }

}
