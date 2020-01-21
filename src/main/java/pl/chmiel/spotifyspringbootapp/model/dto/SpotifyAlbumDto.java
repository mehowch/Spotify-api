package pl.chmiel.spotifyspringbootapp.model.dto;

public class SpotifyAlbumDto {

    private String albumName;
    private String imageUrl;
    private String url;


    public SpotifyAlbumDto(String albumName, String imageUrl, String url) {
        this.albumName = albumName;
        this.imageUrl = imageUrl;
        this.url = url;
    }

    public SpotifyAlbumDto(String name) {
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
