package com.cruzvindev.soundsyncapi.domain;

import com.cruzvindev.soundsyncapi.domain.model.Artist;
import com.cruzvindev.soundsyncapi.domain.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    @Transactional
    public Artist salvar(Artist artist)throws Exception{
        Artist artistFind = buscarOuFalhar(artist.getId());
        return artistRepository.save(artistFind);
    }



    public Artist buscarOuFalhar(Long id) throws Exception {
       return artistRepository.findById(id)
               .orElseThrow(()-> new Exception("Artista não encontrado"));
    }

}
