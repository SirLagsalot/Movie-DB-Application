package Entities;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Writes")
public class Writes extends Entity {

    @Id
    private String nConst;
    @Id
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
