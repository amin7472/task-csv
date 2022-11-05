package com.gerimedica.task.v1;

import com.gerimedica.task.domain.enums.CsvColumnType;
import com.gerimedica.task.exception.ExceptionMessagesEnum;
import com.gerimedica.task.exception.NotFoundException;
import com.gerimedica.task.exception.UnknownException;
import com.gerimedica.task.exception.ValidationException;
import com.gerimedica.task.service.CsvHistoryService;
import com.gerimedica.task.service.dto.CsvHistoryDTO;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class FacadeCsvFileServiceV1 {
    private final static String FILE_NAME = "history.csv";
    private final static String CONTENT_TYPE = "text/csv";


    private final CsvHistoryService csvHistoryService;

    public FacadeCsvFileServiceV1(CsvHistoryService csvHistoryService) {
        this.csvHistoryService = csvHistoryService;
    }

    public void uploadFile(MultipartFile file) {
        if (file.isEmpty()) {
            throw new ValidationException(ExceptionMessagesEnum.FILE_IS_EMPTY.getMessage());
        } else {

            try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
                CsvToBean<CsvHistoryDTO> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(CsvHistoryDTO.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();
                List<CsvHistoryDTO> users = csvToBean.parse();
                csvHistoryService.saveAll(users);
            } catch (Exception ex) {
                throw new UnknownException(ExceptionMessagesEnum.UNKNOWN_EXCEPTION.getMessage());
            }
        }
    }

    public void downloadFile(HttpServletResponse response) throws Exception {
        response.setContentType(CONTENT_TYPE);
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + FILE_NAME + "\"");
        CSVWriter csvWriter = new CSVWriter(response.getWriter());

        List<CsvHistoryDTO> csvHistoryDTOS = csvHistoryService.findAll();

        List<String[]> data = toStringArray(csvHistoryDTOS);

        csvWriter.writeAll(data);

        csvWriter.close();
    }

    public CsvHistoryDTO updateHistory(CsvHistoryDTO csvHistoryDTO) {
        return csvHistoryService.partialUpdate(csvHistoryDTO).orElseThrow(() -> {
            throw new NotFoundException(ExceptionMessagesEnum.NOT_FOUND.getMessage());
        });
    }

    public void deleteHistories() {
        csvHistoryService.deleteAll();
    }

    public List<CsvHistoryDTO> findAll() {
        return csvHistoryService.findAll();
    }

    public CsvHistoryDTO findByCode(String code) {
        return csvHistoryService.findByCode(code).orElseThrow(() -> {
            throw new NotFoundException(ExceptionMessagesEnum.NOT_FOUND.getMessage());
        });
    }
    private static List<String[]> toStringArray(List<CsvHistoryDTO> csvHistoryDTOS) {
        List<String[]> records = new ArrayList<String[]>();

        records.add(new String[]{CsvColumnType.SOURCE.getTitle(),
                CsvColumnType.CODE_LIST_CODE.getTitle(),
                CsvColumnType.CODE.getTitle(),
                CsvColumnType.DISPLAY_VALUE.getTitle(),
                CsvColumnType.LONG_DESCRIPTION.getTitle(),
                CsvColumnType.FROM_DATE.getTitle(),
                CsvColumnType.TO_DATE.getTitle(),
                CsvColumnType.SORTING_PRIORITY.getTitle()});

        Iterator<CsvHistoryDTO> it = csvHistoryDTOS.iterator();
        while (it.hasNext()) {
            CsvHistoryDTO emp = it.next();
            records.add(new String[]{
                    emp.getSource(),
                    emp.getCodeListCode(),
                    emp.getCode(),
                    emp.getDisplayValue(),
                    emp.getLongDescription(),
                    emp.getFromDate(),
                    emp.getToDate(),
                    String.valueOf(emp.getSortingPriority())});
        }
        return records;
    }
}
