package com.cruzvindev.soundsyncapi.dtos.inputs;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlbumDtoInput {

    @NotBlank
    private String titulo;

    @NotBlank
    private String anoLancamento;
    @NotBlank
    private String genero;

    @NotNull
    @Valid
    private ArtistaIdInput artista;

}
