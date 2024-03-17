package com.cruzvindev.soundsyncapi.dtos.inputs;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlbumDtoInput {

    @Schema(example = "A Kind Of Magic")
    @NotBlank
    private String titulo;

    @Schema(example = "1986")
    @NotBlank
    private String anoLancamento;

    @Schema(example = "Rock")
    @NotBlank
    private String genero;

    @NotNull
    @Valid
    private ArtistaIdInput artista;

}
