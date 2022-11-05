package com.gerimedica.task.domain;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "csv_history")
public class CsvHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "csv_id")
    private Long id;
    @Column(name = "source")
    private String source;
    @Column(name = "code_list_code")
    private String codeListCode;
    @Column(name = "code")
    private String code;
    @Column(name = "display_value")
    private String displayValue;
    @Column(name = "long_description")
    private String longDescription;
    @Column(name = "from_date")
    private String fromDate;
    @Column(name = "to_date")
    private String toDate;
    @Column(name = "sorting_priority")
    private int sortingPriority;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CsvHistory)) {
            return false;
        }
        return id != null && id.equals(((CsvHistory) o).id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "CsvHistory{" +
                "id=" + id +
                ", source='" + source + '\'' +
                ", codeListCode='" + codeListCode + '\'' +
                ", code='" + code + '\'' +
                ", displayValue='" + displayValue + '\'' +
                ", longDescription='" + longDescription + '\'' +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", sortingPriority=" + sortingPriority +
                '}';
    }
}
