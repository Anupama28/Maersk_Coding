package com.trello.dao;

import com.trello.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface CardRepository extends JpaRepository<Card, Integer> {
    List<Card> findByTag(String tag);

    List<Card> findByColumnIdIn(Set<Integer> columnId);

    List<Card> findByAssignTo(Integer valueOf);

    List<Card> findByColumnId(Integer columnId);
}
