package Entities;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Known_For")
public class Known_For extends Entity {

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
