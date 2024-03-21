package com.cruzvindev.soundsyncapi.montadores.desmontador;

import com.cruzvindev.soundsyncapi.domain.model.Album;
import com.cruzvindev.soundsyncapi.domain.model.Musica;
import com.cruzvindev.soundsyncapi.dtos.inputs.MusicaDtoInput;
import org.springframework.stereotype.Component;

@Component
public class MusicaDtoDesmontador {

    public Musica paraObjetoDominio(MusicaDtoInput musicaInput){
        return new Musica(musicaInput.titulo(), musicaInput.duracaoEmSegundos(), new Album(musicaInput.albumId().id()));
    }

    public void copiaParaObjetoDominio(MusicaDtoInput musicaInput, Musica musica){
        musica.setTitulo(musicaInput.titulo());
        musica.setDuracaoEmSegundos(musicaInput.duracaoEmSegundos());
        musica.setAlbum(musicaInput.albumId().id());
    }
}
