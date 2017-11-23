package Entities;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Table(name = "Production")
public class Production {

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
    private Date startYear;
    @Column(name = "endYear")
    private Date endYear;
    @Column(name = "runtime")
    private float runtime;

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

    public Date getStartYear() {
        return startYear;
    }

    public void setStartYear(Date startYear) {
        this.startYear = startYear;
    }

    public Date getEndYear() {
        return endYear;
    }

    public void setEndYear(Date endYear) {
        this.endYear = endYear;
    }

    public float getRuntime() {
        return runtime;
    }

    public void setRuntime(float runtime) {
        this.runtime = runtime;
    }
}
