package com.cruzvindev.soundsyncapi.montadores.desmontador;

import com.cruzvindev.soundsyncapi.domain.model.Album;
import com.cruzvindev.soundsyncapi.domain.model.Artista;
import com.cruzvindev.soundsyncapi.dtos.inputs.AlbumDtoInput;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AlbumDtoDesmontador {

    public Album paraObjetoDominio(AlbumDtoInput albumDto) {
        return new Album(albumDto.titulo(), albumDto.anoLancamento(), new Artista(albumDto.artista().id()), albumDto.genero());
    }


    public List<Album> paraColecaoDominio(List<AlbumDtoInput> albuns){
        return albuns.stream()
                .map(this::paraObjetoDominio)
                .collect(Collectors.toList());
    }


    public void copiaParaObjetoDominio(AlbumDtoInput albumInput, Album album){
        album.setTitulo(albumInput.titulo());
        album.setGenero(albumInput.genero());
        album.setAnoLancamento(albumInput.anoLancamento());
        album.setArtista(new Artista(albumInput.artista().id()));
    }

}
