package com.awbd5.awbd5.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nume;
    private String prenume;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> carti = new ArrayList<>();

    public Autor(String nume, String prenume) {
        this.nume = nume;
        this.prenume = prenume;
    }
    public Autor() {
    }
    public Long getId() {

        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Autor(String nume) {
        this.nume = nume;
    }
}
