package com.cruzvindev.soundsyncapi.dtos.inputs;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


public record MusicaDtoInput(
        @Schema(example = "A Distância")
        @NotBlank
        String titulo,

        @NotNull
        @Positive
        @Schema(example = "200")
        Integer duracaoEmSegundos,

        @Valid
        @NotNull
        @JsonProperty("albumId")
        AlbumIdInput albumId) {

}
