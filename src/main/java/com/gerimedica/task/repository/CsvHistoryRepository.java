package com.gerimedica.task.repository;

import com.gerimedica.task.domain.CsvHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CsvHistoryRepository extends JpaRepository<CsvHistory, Long> {
    Optional<CsvHistory> findByCode(String code);
}
