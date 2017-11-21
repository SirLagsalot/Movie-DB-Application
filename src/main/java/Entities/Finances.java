package Entities;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Finances")
public class Finances extends Entity {

    @Id
    private String tConst;
    private float budget;
    private float revenue;


    public String getTConst() {
        return tConst;
    }

    public void setTConst(String tConst) {
        this.tConst = tConst;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public float getRevenue() {
        return revenue;
    }

    public void setRevenue(float revenue) {
        this.revenue = revenue;
    }
}
