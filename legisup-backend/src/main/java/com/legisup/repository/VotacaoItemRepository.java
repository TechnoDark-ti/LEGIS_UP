package com.legisup.repository;

import com.legisup.model.VotacaoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VotacaoItemRepository extends JpaRepository<VotacaoItem, Integer> {
    List<VotacaoItem> findBySessaoId(Integer sessaoId);
}