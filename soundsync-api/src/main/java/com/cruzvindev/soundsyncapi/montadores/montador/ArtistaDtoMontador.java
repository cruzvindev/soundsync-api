package com.cruzvindev.soundsyncapi.montadores.montador;

import com.cruzvindev.soundsyncapi.domain.model.Artista;
import com.cruzvindev.soundsyncapi.dtos.outputs.ArtistaDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArtistaDtoMontador {

    @Autowired
    private ModelMapper modelMapper;

    public ArtistaDto paraModelo(Artista artista){
       // return modelMapper.map(artista, ArtistaDto.class);
        return new ArtistaDto(artista.getId(), artista.getNome(), artista.getOrigem(), artista.getBiografia());
    }
    public List<ArtistaDto> paraColecaoModelo (List<Artista> artistas){
        return artistas.stream()
                .map(this::paraModelo)
                .collect(Collectors.toList());
    }
}
