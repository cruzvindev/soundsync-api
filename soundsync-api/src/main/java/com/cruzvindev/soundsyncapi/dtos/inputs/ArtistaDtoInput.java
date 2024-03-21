package com.cruzvindev.soundsyncapi.dtos.inputs;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;


public record ArtistaDtoInput( @Schema(example = "Alan Jackson")
                               @NotBlank
                               @NotNull
                               String nome,

                               @Schema(example = "Estados Unidos")
                               @NotBlank
                               String origem,

                               @Schema(example = "Alan Eugene Jackson, é um cantor norte-americano e compositor de música country. Seus vários sucessos o tornaram um dos mais célebres cantores de música country dos anos 1980")
                               @NotBlank
                               String biografia) { }
