package pl.chmiel.spotifyspringbootapp;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.chmiel.spotifyspringbootapp.model.album.SpotifyAlbum;
import pl.chmiel.spotifyspringbootapp.model.dto.SpotifyAlbumDto;
import pl.chmiel.spotifyspringbootapp.model.dto.SpotifyTrackDto;
import pl.chmiel.spotifyspringbootapp.model.track.SpotifyTrack;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class SpotifyAlbumClient {

//    @GetMapping("/album/{authorName}")
//    public List<SpotifyAlbumDto> getAlbumsByAuthor(OAuth2Authentication details, @PathVariable String authorName) {
//        String jwt = ((OAuth2AuthenticationDetails) details.getDetails()).getTokenValue();
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("Authorization", "Bearer " + jwt);
//        HttpEntity httpEntity = new HttpEntity(httpHeaders);
//
//        ResponseEntity<SpotifyAlbum> exchange = restTemplate.exchange("https://api.spotify.com/v1/search?q=" + authorName + "&type=album&market=US&offset=5&limit=10",
//                HttpMethod.GET,
//                httpEntity,
//                SpotifyAlbum.class);
//
//        List<SpotifyAlbumDto> spotifyAlbumDto = exchange.getBody()
//                .getAlbums().getItems().stream()
//                .map(item -> new SpotifyAlbumDto(item.getName(), item.getImages().get(0).getUrl(), item.getHref()))
//                .collect(Collectors.toList());
//
//        return spotifyAlbumDto;
//    }

    @GetMapping("/album/{authorName}")
    public String getAlbumsByAuthor(OAuth2Authentication details, @PathVariable String authorName) {
        String jwt = ((OAuth2AuthenticationDetails) details.getDetails()).getTokenValue();
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer " + jwt);
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        ResponseEntity<SpotifyAlbum> exchange = restTemplate.exchange("https://api.spotify.com/v1/search?q=" + authorName + "&type=album&market=US&offset=5&limit=10",
                HttpMethod.GET,
                httpEntity,
                SpotifyAlbum.class);

        List<SpotifyAlbumDto> spotifyAlbumDto = exchange.getBody()
                .getAlbums().getItems().stream()
                .map(item -> new SpotifyAlbumDto(item.getName(), item.getImages().get(0).getUrl(), item.getHref()))
                .collect(Collectors.toList());

        return "/index";
    }

    @GetMapping("/tracks/{album}")
    public List<SpotifyTrackDto> getTracksByAlbum(OAuth2Authentication details, @PathVariable String album) {
        String jwt = ((OAuth2AuthenticationDetails) details.getDetails()).getTokenValue();
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer " + jwt);
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        ResponseEntity<SpotifyTrack> exchange = restTemplate.exchange("https://api.spotify.com/v1/search?q=" + album + "&type=track&market=US&offset=5",
                HttpMethod.GET,
                httpEntity,
                SpotifyTrack.class);

        List<SpotifyTrackDto> spotifyTrackDto = exchange.getBody()
                .getTracks().getItems().stream()
                .map(item -> new SpotifyTrackDto(item.getName(), item.getDurationMs(), item.getHref()))
                .collect(Collectors.toList());

        return spotifyTrackDto;
    }


}
