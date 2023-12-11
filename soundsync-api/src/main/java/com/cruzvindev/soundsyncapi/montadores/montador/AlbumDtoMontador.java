package com.cruzvindev.soundsyncapi.montadores.montador;

import com.cruzvindev.soundsyncapi.domain.model.Album;
import com.cruzvindev.soundsyncapi.dtos.outputs.AlbumDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AlbumDtoMontador {

    @Autowired
    private ModelMapper modelMapper;

    public AlbumDto paraModelo(Album album){
        return modelMapper.map(album, AlbumDto.class);
    }

    public List<AlbumDto> paraColecaoModelo(List<Album> albuns){
        return albuns.stream()
                .map(album -> paraModelo(album))
                .collect(Collectors.toList());
    }

}
