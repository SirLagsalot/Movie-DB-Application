package Entities;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Episode")
public class Episode extends Entity {

    @Id
    private String tConst;
    private String parentTConst;
    private int seasonNumber;
    private int episodeNumber;

    public String getTConst() {
        return tConst;
    }

    public void setTConst(String tConst) {
        this.tConst = tConst;
    }

    public String getParentTConst() {
        return parentTConst;
    }

    public void setParentTConst(String parentTConst) {
        this.parentTConst = parentTConst;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }
}
