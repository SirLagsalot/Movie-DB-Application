package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Production")
public class Production implements Serializable {

    @Id
    @Column(name = "tConst")
    private String tConst;
    @Column(name = "titleType")
    private String titleType;
    @Column(name = "primaryTitle")
    private String primaryTitle;
    @Column(name = "originalTitle")
    private String originalTitle;
    @Column(name = "adult")
    private boolean adult;
    @Column(name = "startYear")
    private Integer startYear;
    @Column(name = "endYear")
    private Integer endYear;
    @Column(name = "runtime")
    private Float runtime;

    public String getTConst() {
        return tConst;
    }

    public void setTConst(String tConst) {
        this.tConst = tConst;
    }

    public String getTitleType() {
        return titleType;
    }

    public void setTitleType(String titleType) {
        this.titleType = titleType;
    }

    public String getPrimaryTitle() {
        return primaryTitle;
    }

    public void setPrimaryTitle(String primaryTitle) {
        this.primaryTitle = primaryTitle;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }

    public Float getRuntime() {
        return runtime;
    }

    public void setRuntime(Float runtime) {
        this.runtime = runtime;
    }

    @Override
    public String toString() {
        return "Id: ".concat(this.tConst)
                .concat(", Title: ")
                .concat(this.primaryTitle)
                .concat(", Year: " + this.startYear);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Production) {
            Production comparison = (Production) obj;
            return Objects.equals(comparison.tConst, this.tConst);
        } else {
            return false;
        }
    }
}
