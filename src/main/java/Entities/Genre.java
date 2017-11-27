package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Genre")
public class Genre implements Serializable {

    @Id
    @Column(name = "tConst")
    private String tConst;
    @Column(name = "genre")
    private String genre;

    public String getTConst() {
        return tConst;
    }

    public void setTConst(String tConst) {
        this.tConst = tConst;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "ProductionId: ".concat(this.tConst).concat(", Genre: ").concat(this.genre);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Genre) {
            Genre comparison = (Genre) obj;
            return Objects.equals(comparison.tConst, this.tConst);
        } else {
            return false;
        }
    }
}
