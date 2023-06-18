package com.awbd5.awbd5.repositories;

import com.awbd5.awbd5.domain.Rezervare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RezervareRepository extends JpaRepository<Rezervare, Long> {
    boolean existsByUtilizatorId(Long utilizatorId);
}
