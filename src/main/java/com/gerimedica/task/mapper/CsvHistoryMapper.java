package com.gerimedica.task.mapper;


import com.gerimedica.task.domain.CsvHistory;
import com.gerimedica.task.service.dto.CsvHistoryDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = {})
public interface CsvHistoryMapper extends EntityMapper<CsvHistoryDTO, CsvHistory> {

}
