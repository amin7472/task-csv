package com.gerimedica.task.v1;


import com.gerimedica.task.service.dto.CsvHistoryDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@RequestMapping("/v1")
public class CsvFileControllerV1 {
    private final FacadeCsvFileServiceV1 facadeCsvFileServiceV1;

    public CsvFileControllerV1(FacadeCsvFileServiceV1 facadeCsvFileServiceV1) {
        this.facadeCsvFileServiceV1 = facadeCsvFileServiceV1;
    }

    @PostMapping("/upload-file")
    public ResponseEntity<Void> uploadCSVFile(@RequestParam("file") MultipartFile file) {
        facadeCsvFileServiceV1.uploadFile(file);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/download-file")
    public ResponseEntity<Void> exportCSV(HttpServletResponse response) throws Exception {
        facadeCsvFileServiceV1.downloadFile(response);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Void> update(@RequestBody() CsvHistoryDTO csvHistoryDTO) {
        facadeCsvFileServiceV1.updateHistory(csvHistoryDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<Void> deleteAll() {
        facadeCsvFileServiceV1.deleteHistories();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<CsvHistoryDTO>> findAll() {
        return new ResponseEntity<>(facadeCsvFileServiceV1.findAll(), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<CsvHistoryDTO> findByFilter(@RequestParam(name = "code") String code) {
        return new ResponseEntity<>(facadeCsvFileServiceV1.findByCode(code), HttpStatus.OK);
    }
}
