package com.cruzvindev.soundsyncapi.montadores.desmontador;

import com.cruzvindev.soundsyncapi.domain.model.Musica;
import com.cruzvindev.soundsyncapi.dtos.inputs.MusicaDtoInput;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MusicaDtoDesmontador {

    @Autowired
    private ModelMapper modelMapper;

    public Musica paraObjetoDominio(MusicaDtoInput musicaInput){
        return modelMapper.map(musicaInput, Musica.class);
    }

    public void copiaParaObjetoDominio(MusicaDtoInput musicaInput, Musica musica){
        modelMapper.map(musicaInput, musica);
    }
}
