package com.cruzvindev.soundsyncapi.montadores.desmontador;

import com.cruzvindev.soundsyncapi.domain.model.Artista;
import com.cruzvindev.soundsyncapi.dtos.inputs.ArtistaDtoInput;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArtistaDtoDesmontador {

    public Artista paraObjetoDominio(ArtistaDtoInput artistaInput){
        return new Artista(artistaInput.nome(), artistaInput.origem(), artistaInput.biografia());
    }

    public List<Artista> paraColecaoDominio(List<ArtistaDtoInput> artistasInput){
        return artistasInput.stream()
                .map(this::paraObjetoDominio)
                .collect(Collectors.toList());
    }

    public void copiaParaObjetoDominio(ArtistaDtoInput artistaInput, Artista artista){
        artista.setNome(artistaInput.nome());
        artista.setOrigem(artistaInput.origem());
        artista.setBiografia(artistaInput.biografia());
    }
}
