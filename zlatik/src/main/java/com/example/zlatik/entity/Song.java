package com.example.zlatik.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.sql.Time;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "song")
public class Song {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGSERIAL", name = "id_song")
    @Id
    private Long id;
    @Column(columnDefinition = "TEXT", name = "song_name")
    private String songName;
    @Column(columnDefinition = "TEXT", name = "author")
    private String author;
    @Column(columnDefinition = "TIME", name = "song_duration")
    private Time songDuration;
    @ManyToOne
    @JoinColumn(columnDefinition = "BIGSERIAL", name = "fk_id_genre", referencedColumnName = "id_genre", foreignKey = @ForeignKey(name = "fk_id_genre"))
    private Genre genre;
    @OneToMany(mappedBy = "song", cascade = CascadeType.REMOVE)
    private List<ContainsSong> containsSongs;
    @OneToMany(mappedBy = "song", cascade = CascadeType.REMOVE)
    private List<PerformsArtist> performsArtists;
    @OneToMany(mappedBy = "song", cascade = CascadeType.REMOVE)
    private List<PerformsBand> performsBands;

    public Song() {
    }
    public Song(Long id, String songName, String author, Time songDuration, Genre genre) {
        this.id = id;
        this.songName = songName;
        this.author = author;
        this.songDuration = songDuration;
        this.genre = genre;
    }
    public Song(String songName, String author, Time songDuration, Genre genre) {
        this.songName = songName;
        this.author = author;
        this.songDuration = songDuration;
        this.genre = genre;
    }

    public String getGenreName() {
        if (genre != null) {
            return genre.getGenreName();
        }
        return null;
    }
}

