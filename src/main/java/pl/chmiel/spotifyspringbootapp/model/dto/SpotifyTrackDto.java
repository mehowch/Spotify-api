package pl.chmiel.spotifyspringbootapp.model.dto;

public class SpotifyTrackDto {

    private String trackName;
    private int duration;
    private String url;

    public SpotifyTrackDto(String trackName, int duration, String url) {
        this.trackName = trackName;
        this.duration = duration;
        this.url = url;

    }

    public SpotifyTrackDto() {
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
