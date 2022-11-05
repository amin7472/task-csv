package com.gerimedica.task.service.dto;


import com.opencsv.bean.CsvBindByName;

import java.io.Serializable;


public class CsvHistoryDTO implements Serializable {
    private long id;
    @CsvBindByName
    private String source;
    @CsvBindByName
    private String codeListCode;
    @CsvBindByName
    private String code;
    @CsvBindByName
    private String displayValue;
    @CsvBindByName
    private String longDescription;
    @CsvBindByName
    private String fromDate;
    @CsvBindByName
    private String toDate;
    @CsvBindByName
    private int sortingPriority;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCodeListCode() {
        return codeListCode;
    }

    public void setCodeListCode(String codeListCode) {
        this.codeListCode = codeListCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public int getSortingPriority() {
        return sortingPriority;
    }

    public void setSortingPriority(int sortingPriority) {
        this.sortingPriority = sortingPriority;
    }
}
