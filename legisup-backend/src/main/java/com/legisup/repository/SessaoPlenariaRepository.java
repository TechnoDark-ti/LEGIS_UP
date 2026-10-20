package com.legisup.repository;

import com.legisup.model.SessaoPlenaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessaoPlenariaRepository extends JpaRepository<SessaoPlenaria, Integer> {
}