package Entities;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "Episode")
public class Episode {

    @Id
    @Column(name = "tConst")
    private String tConst;
    @Column(name = "parentTConst")
    private String parentTConst;
    @Column(name = "seasonNumber")
    private int seasonNumber;
    @Column(name = "episodeNumber")
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
