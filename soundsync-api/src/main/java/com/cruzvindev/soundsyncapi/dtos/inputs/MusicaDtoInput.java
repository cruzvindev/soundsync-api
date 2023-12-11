package com.cruzvindev.soundsyncapi.dtos.inputs;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MusicaDtoInput {

    @NotBlank
    private String titulo;

    @NotNull
    @Positive
    private Integer duracaoEmSegundos;

    @Valid
    @NotNull
    @JsonProperty("albumId")
    private AlbumIdInput albumId;
}
