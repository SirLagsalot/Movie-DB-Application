package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Ratings")
public class Ratings implements Serializable {

    @Id
    @Column(name = "tConst")
    private String tConst;
    @Column(name = "averageRating")
    private float avgRating;
    @Column(name = "numVotes")
    private int numVotes;

    public String getTConst() {
        return tConst;
    }

    public void setTConst(String tConst) {
        this.tConst = tConst;
    }

    public float getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(float avgRating) {
        this.avgRating = avgRating;
    }

    public int getNumVotes() {
        return numVotes;
    }

    public void setNumVotes(int numVotes) {
        this.numVotes = numVotes;
    }

    @Override
    public String toString() {
        return "Id: ".concat(this.tConst).concat(", Votes: " + this.numVotes).concat(", Rating: " + this.avgRating);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Ratings) {
            Ratings comparison = (Ratings) obj;
            return Objects.equals(comparison.tConst, this.tConst);
        } else {
            return false;
        }
    }

}
