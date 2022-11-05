package com.gerimedica.task.service;


import com.gerimedica.task.service.dto.CsvHistoryDTO;

import java.util.List;
import java.util.Optional;


public interface CsvHistoryService {

    void saveAll(List<CsvHistoryDTO> csvHistory);

    List<CsvHistoryDTO> findAll();

    Optional<CsvHistoryDTO> findByCode(String code);

    void deleteAll();

    Optional<CsvHistoryDTO> partialUpdate(CsvHistoryDTO csvHistoryDTO);


}
