package com.cruzvindev.soundsyncapi.dtos.inputs;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record AlbumDtoInput( @Schema(example = "A Kind Of Magic")
                             @NotBlank
                             String titulo,

                             @Schema(example = "1986")
                             @NotBlank
                             String anoLancamento,

                             @Schema(example = "Rock")
                             @NotBlank
                             String genero,

                             @NotNull
                             @Valid
                             ArtistaIdInput artista) { }
