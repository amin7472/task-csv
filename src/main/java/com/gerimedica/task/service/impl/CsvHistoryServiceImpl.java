package com.gerimedica.task.service.impl;

import com.gerimedica.task.domain.CsvHistory;
import com.gerimedica.task.mapper.CsvHistoryMapper;
import com.gerimedica.task.repository.CsvHistoryRepository;
import com.gerimedica.task.service.CsvHistoryService;
import com.gerimedica.task.service.dto.CsvHistoryDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Transactional
public class CsvHistoryServiceImpl implements CsvHistoryService {

    private final Logger log = LoggerFactory.getLogger(CsvHistoryServiceImpl.class);

    private final CsvHistoryRepository csvHistoryRepository;

    private final CsvHistoryMapper csvHistoryMapper;

    public CsvHistoryServiceImpl(CsvHistoryRepository csvHistoryRepository, CsvHistoryMapper csvHistoryMapper) {
        this.csvHistoryRepository = csvHistoryRepository;
        this.csvHistoryMapper = csvHistoryMapper;
    }

    @Override
    public void saveAll(List<CsvHistoryDTO> csvHistoryDTO) {
        log.debug("Request to save : {}", csvHistoryDTO);
        List<CsvHistory> csvHistories = csvHistoryDTO.stream().map(csvHistoryMapper::toEntity)
                .collect(Collectors.toList());
        csvHistoryRepository.saveAll(csvHistories);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CsvHistoryDTO> findAll() {
        log.debug("Request to get all files");
        return csvHistoryRepository.findAll().stream().map(csvHistoryMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CsvHistoryDTO> findByCode(String code) {
        log.debug("Request to get : {}", code);
        return csvHistoryRepository.findByCode(code).map(csvHistoryMapper::toDto);
    }

    @Override
    public void deleteAll() {
        log.debug("Request to delete all");
        csvHistoryRepository.deleteAll();
    }


    @Override
    public Optional<CsvHistoryDTO> partialUpdate(CsvHistoryDTO csvHistoryDTO) {
        return csvHistoryRepository
                .findById(csvHistoryDTO.getId())
                .map(existingBusinesses -> {
                    csvHistoryMapper.partialUpdate(existingBusinesses, csvHistoryDTO);
                    return existingBusinesses;
                })
                .map(csvHistoryRepository::save)
                .map(csvHistoryMapper::toDto);
    }
}
