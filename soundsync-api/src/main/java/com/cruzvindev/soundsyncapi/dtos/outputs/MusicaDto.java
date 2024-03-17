package com.cruzvindev.soundsyncapi.dtos.outputs;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MusicaDto {

    @Schema(example = "Hey Jude")
    private String titulo;

    @Schema(example = "425")
    @JsonProperty("duracaoSegundos")
    private Integer duracaoEmSegundos;

    private AlbumResumoDto album;
}
