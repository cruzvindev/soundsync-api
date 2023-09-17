package com.cruzvindev.soundsyncapi.domain;

import com.cruzvindev.soundsyncapi.domain.exception.NegocioException;
import com.cruzvindev.soundsyncapi.domain.model.Artista;
import com.cruzvindev.soundsyncapi.domain.repository.ArtistaRepository;
import com.cruzvindev.soundsyncapi.domain.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArtistaService {

    @Autowired
    private ArtistaRepository artistaRepository;

    @Transactional
    public Artista salvar(Artista artist)throws Exception{
        Artista artistaBusca = buscarOuFalhar(artist.getId());
        return artistaRepository.save(artistaBusca);
    }



    public Artista buscarOuFalhar(Long id){
       return artistaRepository.findById(id)
               .orElseThrow(()-> new NegocioException("Artista não encontrado"));
    }

}
