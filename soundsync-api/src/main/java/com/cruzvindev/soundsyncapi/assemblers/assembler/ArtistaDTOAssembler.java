package com.cruzvindev.soundsyncapi.assemblers.assembler;

import com.cruzvindev.soundsyncapi.domain.model.Artista;
import com.cruzvindev.soundsyncapi.dtos.outputs.ArtistaDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArtistaDTOAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public ArtistaDto paraModelo(Artista artista){
        return modelMapper.map(artista, ArtistaDto.class);
    }
    public List<ArtistaDto> paraColecaoModelo (List<Artista> artistas){
        return artistas.stream()
                .map(artista -> paraModelo(artista))
                .collect(Collectors.toList());
    }
}
