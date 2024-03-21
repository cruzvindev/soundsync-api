package com.cruzvindev.soundsyncapi.montadores.montador;

import com.cruzvindev.soundsyncapi.domain.model.Musica;
import com.cruzvindev.soundsyncapi.dtos.outputs.AlbumResumoDto;
import com.cruzvindev.soundsyncapi.dtos.outputs.MusicaDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MusicaMontador {

    @Autowired
    private ModelMapper modelMapper;

    public MusicaDto paraModelo(Musica musica){
        //return modelMapper.map(musica, MusicaDto.class);
        return new MusicaDto(musica.getTitulo(), musica.getDuracaoEmSegundos(),
                new AlbumResumoDto(musica.getAlbum().getId(), musica.getAlbum().getTitulo()));
    }

    public List<MusicaDto> paraColecaoModelo(List<Musica> musicas){
        return musicas.stream()
                .map(this::paraModelo)
                .collect(Collectors.toList());
    }

}
