package Entities;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "Writes")
public class Writes implements Serializable {

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
}
