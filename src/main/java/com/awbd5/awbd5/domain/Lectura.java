package com.awbd5.awbd5.domain;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Lectura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String denumire;
    private int perioada;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idc", nullable = false)
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idu", nullable = false)
    private Utilizator utilizator;

    @Column(name = "datasala")
    private LocalDate datasala;
    public LocalDate getDatasala() {
        return datasala;
    }
    public Lectura() {    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDenumire() {
        return denumire;
    }
    public int getPerioada() {
        return perioada;
    }
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    public Utilizator getUtilizator() {
        return utilizator;
    }
    public void setUtilizator(Utilizator utilizator) {
        this.utilizator = utilizator;
    }

    public Lectura(Long id, String denumire, int perioada,LocalDate datasala, Book book, Utilizator utilizator) {
        this.id = id;
        this.denumire = denumire;
        this.perioada = perioada;
        this.datasala = datasala;
        this.book = book;
        this.utilizator = utilizator;
    }
    public void setPerioada(int perioada) {
        this.perioada = perioada;
    }
    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }
    public void setDatasala(LocalDate datasala) {
        this.datasala = datasala;
    }
}
