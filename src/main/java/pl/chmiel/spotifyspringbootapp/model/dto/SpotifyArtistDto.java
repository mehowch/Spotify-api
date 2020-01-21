package pl.chmiel.spotifyspringbootapp.model.dto;

public class SpotifyArtistDto {

    private String artistName;
    private SpotifyAlbumDto artistAlbums;
    private String imageUrl;

    public SpotifyArtistDto() {
    }

    public SpotifyArtistDto(String artistName, SpotifyAlbumDto artistAlbums, String imageUrl) {
        this.artistName = artistName;
        this.artistAlbums = artistAlbums;
        this.imageUrl = imageUrl;
    }

    public SpotifyArtistDto(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public SpotifyAlbumDto getArtistAlbums() {
        return artistAlbums;
    }

    public void setArtistAlbums(SpotifyAlbumDto artistAlbums) {
        this.artistAlbums = artistAlbums;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}