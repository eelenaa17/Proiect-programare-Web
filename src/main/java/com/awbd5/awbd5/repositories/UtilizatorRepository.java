package com.awbd5.awbd5.repositories;

import com.awbd5.awbd5.domain.Utilizator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilizatorRepository extends JpaRepository<Utilizator, Long> {

}