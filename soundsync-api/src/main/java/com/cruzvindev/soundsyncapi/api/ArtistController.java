package com.cruzvindev.soundsyncapi.api;

import com.cruzvindev.soundsyncapi.domain.ArtistService;
import com.cruzvindev.soundsyncapi.domain.model.Artist;
import com.cruzvindev.soundsyncapi.domain.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/artistas")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @Autowired
    private ArtistRepository artistRepository;

    @GetMapping("/{artistId}")
    public ResponseEntity<Artist> buscar(@PathVariable Long artistId)  {
        Optional<Artist> artista = artistRepository.findById(artistId);

        if(artista.isPresent()){
            return ResponseEntity.ok(artista.get());
        }
        return ResponseEntity.notFound().build();
    }

}
