package com.cruzvindev.soundsyncapi.dtos.outputs;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;


public record MusicaDto(
        @Schema(example = "Hey Jude")
        String titulo,

        @Schema(example = "425")
        @JsonProperty("duracaoSegundos")
        Integer duracaoEmSegundos,

        AlbumResumoDto album){ }
