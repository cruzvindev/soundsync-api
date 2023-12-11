package com.cruzvindev.soundsyncapi.montadores.desmontador;

import com.cruzvindev.soundsyncapi.domain.model.Album;
import com.cruzvindev.soundsyncapi.dtos.inputs.AlbumDtoInput;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AlbumDtoDesmontador {

    @Autowired
    private ModelMapper modelMapper;

    public Album paraObjetoDominio(AlbumDtoInput albumDto) {
        return modelMapper.map(albumDto, Album.class);
    }


    public List<Album> paraColecaoDominio(List<AlbumDtoInput> albuns){
        return albuns.stream()
                .map(album -> paraObjetoDominio(album))
                .collect(Collectors.toList());
    }


    public void copiaParaObjetoDominio(AlbumDtoInput albumInput, Album album){
        modelMapper.map(albumInput, album);
    }

}
