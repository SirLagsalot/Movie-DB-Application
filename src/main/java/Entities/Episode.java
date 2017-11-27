package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Episode")
public class Episode implements Serializable {

    @Id
    @Column(name = "tConst")
    private String tConst;
    @Column(name = "parentTConst")
    private String parentTConst;
    @Column(name = "seasonNumber")
    private Integer seasonNumber;
    @Column(name = "episodeNumber")
    private Integer episodeNumber;

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

    public Integer getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(Integer seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public Integer getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(Integer episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    @Override
    public String toString() {
        return ("EpisodeId: " + this.tConst)
                .concat(", SeriesId: " + this.parentTConst)
                .concat(", Season: " + this.seasonNumber)
                .concat(", Episode: " + this.episodeNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Episode) {
            Episode comparison = (Episode) obj;
            return Objects.equals(comparison.tConst, this.tConst);
        } else {
            return false;
        }
    }
}
