package com.legisup.repository;

import com.legisup.model.PresencaVereador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PresencaVereadorRepository extends JpaRepository<PresencaVereador, Integer> {
    List<PresencaVereador> findBySessaoId(Integer sessaoId);
    Optional<PresencaVereador> findBySessaoIdAndVereadorId(Integer sessaoId, Integer vereadorId);
}