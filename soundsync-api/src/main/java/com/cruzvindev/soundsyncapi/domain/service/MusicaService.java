package com.cruzvindev.soundsyncapi.domain.service;

import com.cruzvindev.soundsyncapi.domain.exception.NegocioException;
import com.cruzvindev.soundsyncapi.domain.model.Musica;
import com.cruzvindev.soundsyncapi.domain.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MusicaService {


    @Autowired
    private MusicaRepository musicaRepository;

    public Musica buscarOuFalhar(Long musicaId){
        return musicaRepository.findById(musicaId)
                .orElseThrow(()-> new NegocioException(String.format("A música de id %d não foi encontradada", musicaId)));
    }


}
