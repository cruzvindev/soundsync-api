package com.cruzvindev.soundsyncapi.assemblers.disassemblers;

import com.cruzvindev.soundsyncapi.domain.model.Artista;
import com.cruzvindev.soundsyncapi.dtos.inputs.ArtistaDtoInput;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArtistaDtoDisassembler {


    @Autowired
    private ModelMapper modelMapper;

    public Artista paraObjetoDominio(ArtistaDtoInput artistaInput){
        return modelMapper.map(artistaInput, Artista.class);
    }

    public List<Artista> paraColecaoDominio(List<ArtistaDtoInput> artistasInput){
        return artistasInput.stream()
                .map(artista -> paraObjetoDominio(artista))
                .collect(Collectors.toList());
    }

    public void copiaParaObjetoDominio(ArtistaDtoInput artistaInput, Artista artista){
        modelMapper.map(artistaInput, artista);
    }
}
