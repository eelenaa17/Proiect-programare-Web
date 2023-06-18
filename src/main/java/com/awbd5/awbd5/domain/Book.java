package com.awbd5.awbd5.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bookName;
    private int year;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rezervare> rezervari = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idau", nullable = false)
    private Autor autor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idca", nullable = false)
    private Categorie categorie;


    public Book(Long id, String bookName, int year, Autor autor , Categorie categorie) {
        this.id = id;
        this.bookName = bookName;
        this.year = year;
        this.autor = autor;
        this.categorie = categorie;
    }

    public Book() {
    }

    public String getDescriere() {
        return categorie.getDescriere();
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public List<Rezervare> getRezervari() {
        return rezervari;
    }
    public void setRezervari(List<Rezervare> rezervari) {
        this.rezervari = rezervari;
    }
}
