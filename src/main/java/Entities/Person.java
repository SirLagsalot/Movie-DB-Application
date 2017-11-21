package Entities;

import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Table(name = "Person")
public class Person extends Entity {

    @Id
    private String nConst;
    private String primaryName;
    private Date birthYear;
    private Date deathYear;

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

    public Date getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Date birthYear) {
        this.birthYear = birthYear;
    }

    public Date getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Date deathYear) {
        this.deathYear = deathYear;
    }
}

