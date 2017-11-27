package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Directs")
public class Directs implements Serializable {

    @Id
    @Column(name = "nConst")
    private String nConst;
    @Id
    @Column(name = "tConst")
    private String tConst;

    public String getNConst() {
        return nConst;
    }

    public void setNConst(String nConst) {
        this.nConst = nConst;
    }

    public String getTConst() {
        return tConst;
    }

    public void setTConst(String tConst) {
        this.tConst = tConst;
    }

    @Override
    public String toString() {
        return ("PersonId: " + this.nConst).concat(", ProductionId: " + this.tConst);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Directs) {
            Directs comparison = (Directs) obj;
            return Objects.equals(comparison.nConst, this.nConst) && Objects.equals(comparison.tConst, this.tConst);
        } else {
            return false;
        }
    }
}
