package com.cruzvindev.soundsyncapi.domain.service;

import com.cruzvindev.soundsyncapi.domain.exception.EntidadeNaoEncontradaException;
import com.cruzvindev.soundsyncapi.domain.exception.NegocioException;
import com.cruzvindev.soundsyncapi.domain.model.Album;
import com.cruzvindev.soundsyncapi.domain.repository.AlbumRepository;
import com.cruzvindev.soundsyncapi.dtos.inputs.AlbumDtoInput;
import com.cruzvindev.soundsyncapi.dtos.outputs.AlbumDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ArtistaService artistaService;

    @Transactional
    public Album salvar(AlbumDtoInput album){
       var verificaArtista = artistaService.buscarOuFalhar(album.artista().id());

        return albumRepository.save(album);
    }

    public void excluir(Album album){
        albumRepository.deleteById(album.getId());
        albumRepository.flush();
    }

    public Album buscarOuFalhar(Long id){
        return albumRepository.findById(id)
                .orElseThrow(()-> new EntidadeNaoEncontradaException(String.format("O album de id %d não foi encontrado", id)));
    }

}
