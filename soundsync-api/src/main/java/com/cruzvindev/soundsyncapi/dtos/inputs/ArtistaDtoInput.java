package com.cruzvindev.soundsyncapi.dtos.inputs;

import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArtistaDtoInput {

    @NotBlank
    private String nome;

    @NotBlank
    private String origem;

    @NotBlank
    private String biografia;
}
