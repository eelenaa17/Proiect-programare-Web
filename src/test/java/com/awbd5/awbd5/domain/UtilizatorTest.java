package com.awbd5.awbd5.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UtilizatorTest {
    @Test
    void testConstructorAndGetters() {
        Utilizator utilizator = new Utilizator(1L, "John", "Doe", 123456789, 756789123);
        assertEquals(1L, utilizator.getId());
        assertEquals("John", utilizator.getFirstName());
        assertEquals("Doe", utilizator.getLastName());
        assertEquals(123456789, utilizator.getCnp());
        assertEquals(756789123, utilizator.getPhone());
    }

    @Test
    void testSetters() {
        Utilizator utilizator = new Utilizator();
        utilizator.setId(2L);
        assertEquals(2L, utilizator.getId());
        utilizator.setFirstName("Jane");
        assertEquals("Jane", utilizator.getFirstName());
        utilizator.setLastName("Doe");
        assertEquals("Doe", utilizator.getLastName());
        utilizator.setCnp(123456788);
        assertEquals(123456788, utilizator.getCnp());
        utilizator.setPhone(756789124);
        assertEquals(756789124, utilizator.getPhone());
    }
}
