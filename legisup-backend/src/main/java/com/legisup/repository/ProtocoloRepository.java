package com.legisup.repository;

import com.legisup.model.Protocolo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProtocoloRepository extends JpaRepository<Protocolo, Integer> {
}