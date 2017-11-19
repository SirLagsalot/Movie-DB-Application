package Entities;

import javax.persistence.Table;

@Table(name = "Acts_In")
public class Acts_In extends Entity {

    private String nConst;
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
