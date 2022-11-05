package com.gerimedica.task.domain.enums;

public enum CsvColumnType {
    SOURCE("source"),
    CODE_LIST_CODE("codeListCode"),
    CODE("code"),
    DISPLAY_VALUE("displayValue"),
    LONG_DESCRIPTION("longDescription"),
    FROM_DATE("fromDate"),
    TO_DATE("toDate"),
    SORTING_PRIORITY("sortingPriority");

    private final String title;

    CsvColumnType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
