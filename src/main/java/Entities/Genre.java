package Entities;

import javax.persistence.Table;

@Table(name = "Genre")
public class Genre extends Entity {

    private String tConst;
    private String genre;

    public String getTConst() {
        return tConst;
    }

    public void setTConst(String tConst) {
        this.tConst = tConst;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
