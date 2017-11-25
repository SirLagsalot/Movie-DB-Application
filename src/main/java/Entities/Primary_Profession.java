package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Primary_Profession")
public class Primary_Profession implements Serializable {

    @Id
    @Column(name = "nConst")
    private String nConst;
    @Column(name = "profession")
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

    @Override
    public String toString() {
        return "Id: ".concat(this.nConst).concat(", Profession: ").concat(this.profession);
    }
}
