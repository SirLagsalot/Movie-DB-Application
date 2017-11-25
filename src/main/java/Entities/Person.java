package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Person")
public class Person implements Serializable {

    @Id
    @Column(name = "nConst")
    private String nConst;
    @Column(name = "primaryName")
    private String primaryName;
    @Column(name = "birthYear")
    private Integer birthYear;
    @Column(name = "deathYear")
    private Integer deathYear;

    public String getNConst() {
        return nConst;
    }

    public void setNConst(String nConst) {
        this.nConst = nConst;
    }

    public String getPrimaryName() {
        return primaryName;
    }

    public void setPrimaryName(String primaryName) {
        this.primaryName = primaryName;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }

    public String toString() {
        return ("Id: " + this.nConst)
                .concat(", Name: " + this.primaryName)
                .concat(", BirthYear: " + this.birthYear)
                .concat(", DeathYear: " + this.deathYear);
    }
}

