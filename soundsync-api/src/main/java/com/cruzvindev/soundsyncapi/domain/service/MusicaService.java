package com.cruzvindev.soundsyncapi.domain.service;

import com.cruzvindev.soundsyncapi.domain.exception.EntidadeNaoEncontradaException;
import com.cruzvindev.soundsyncapi.domain.model.Musica;
import com.cruzvindev.soundsyncapi.domain.repository.MusicaRepository;
import com.cruzvindev.soundsyncapi.dtos.inputs.MusicaDtoInput;
import com.cruzvindev.soundsyncapi.montadores.desmontador.AlbumDtoDesmontador;
import com.cruzvindev.soundsyncapi.montadores.desmontador.MusicaDtoDesmontador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MusicaService {


    @Autowired
    private MusicaRepository musicaRepository;

    @Autowired
    private AlbumService albumService;

    @Autowired
    private MusicaDtoDesmontador musicaDesmontador;

    @Transactional
    public void salvar(MusicaDtoInput musicaInput){
        Long albumId = musicaInput.albumId().id();
        albumService.buscarOuFalhar(albumId);
        Musica musica = musicaDesmontador.paraObjetoDominio(musicaInput);
        musicaRepository.save(musica);
    }

    public Musica buscarOuFalhar(Long musicaId){
        return musicaRepository.findById(musicaId)
                .orElseThrow(()-> new EntidadeNaoEncontradaException(String.format("A música de id %d não foi encontradada", musicaId)));
    }


}
