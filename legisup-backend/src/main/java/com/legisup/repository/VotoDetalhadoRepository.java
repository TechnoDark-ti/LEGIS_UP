package com.legisup.repository;

import com.legisup.model.VotoDetalhado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VotoDetalhadoRepository extends JpaRepository<VotoDetalhado, Integer> {
    List<VotoDetalhado> findByVotacaoItemId(Integer votacaoItemId);
    Optional<VotoDetalhado> findByVotacaoItemIdAndVereadorId(Integer votacaoItemId, Integer vereadorId);
}