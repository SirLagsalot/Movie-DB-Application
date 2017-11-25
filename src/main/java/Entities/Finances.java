package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Finances")
public class Finances implements Serializable {

    @Id
    @Column(name = "tConst")
    private String tConst;
    @Column(name = "budget")
    private Float budget;
    @Column(name = "revenue")
    private Float revenue;

    public String getTConst() {
        return tConst;
    }

    public void setTConst(String tConst) {
        this.tConst = tConst;
    }

    public Float getBudget() {
        return budget;
    }

    public void setBudget(Float budget) {
        this.budget = budget;
    }

    public Float getRevenue() {
        return revenue;
    }

    public void setRevenue(Float revenue) {
        this.revenue = revenue;
    }

    @Override
    public String toString() {
        return ("ProductionId: ")
                .concat(this.tConst)
                .concat(", Budget: " + this.budget)
                .concat(", Revenue: " + this.revenue);
    }
}
