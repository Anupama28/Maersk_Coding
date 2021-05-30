package com.maersk.dao;

import com.maersk.entity.BoardColumn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColumnRepository extends JpaRepository<BoardColumn, Integer> {
    List<BoardColumn> findByColumnName(String columnName);

    List<BoardColumn> findByBoardId(Integer id);
}
