package com.awbd5.awbd5.domain;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "rezervari")
public class Rezervare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idc", nullable = false)
    private Book book;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idu")
    private Utilizator utilizator;

    @Column(name = "datastart")
    private LocalDate dataStart;

    @Column(name = "datastop")
    private LocalDate dataStop;

    public Rezervare() {
    }

    public Rezervare(Book book, Utilizator utilizator, LocalDate dataStart, LocalDate dataStop) {
        this.book = book;
        this.utilizator = utilizator;
        this.dataStart = dataStart;
        this.dataStop = dataStop;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public LocalDate getDataStart() {
        return dataStart;
    }
    public void setDataStart(LocalDate dataStart) {
        this.dataStart = dataStart;
    }
    public LocalDate getDataStop() {
        return dataStop;
    }
    public void setDataStop(LocalDate dataStop) {
        this.dataStop = dataStop;
    }
}
