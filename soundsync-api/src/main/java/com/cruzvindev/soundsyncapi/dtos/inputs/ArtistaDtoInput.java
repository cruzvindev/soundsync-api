package com.cruzvindev.soundsyncapi.dtos.inputs;

import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArtistaDtoInput {

    @NotBlank
    @NotNull
    private String nome;

    @NotBlank
    private String origem;

    @NotBlank
    private String biografia;
}
