package com.awbd5.awbd5.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Utilizator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private int cnp;
    private int phone;

    @OneToOne(mappedBy = "utilizator", cascade = CascadeType.ALL)
    private Rezervare rezervare;


    public Utilizator(Long id, String firstName, String lastName, int cnp, int phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cnp = cnp;
        this.phone = phone;
    }

    public int getCnp() {
        return this.cnp;
    }
    public void setCnp(int cnp) {
        this.cnp = cnp;
    }
    public int getPhone() {
        return this.phone;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }
}
