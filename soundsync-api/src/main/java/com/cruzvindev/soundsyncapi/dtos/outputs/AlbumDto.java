package com.cruzvindev.soundsyncapi.dtos.outputs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlbumDto {

    private Long id;

    private String titulo;

    private String anoLancamento;

    private ArtistaResumoDto artista;

}
