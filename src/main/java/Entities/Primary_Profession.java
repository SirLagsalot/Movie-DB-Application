package Entities;

import javax.persistence.Table;

@Table(name = "Primary_Profession")
public class Primary_Profession extends Entity {

    private String nConst;
    private String profession;

    public String getNConst() {
        return nConst;
    }

    public void setNConst(String nConst) {
        this.nConst = nConst;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
