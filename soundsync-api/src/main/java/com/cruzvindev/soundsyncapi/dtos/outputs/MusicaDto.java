package com.cruzvindev.soundsyncapi.dtos.outputs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MusicaDto {
    private String titulo;

    @JsonProperty("duracaoSegundos")
    private Integer duracaoEmSegundos;

    private AlbumResumoDto album;
}
