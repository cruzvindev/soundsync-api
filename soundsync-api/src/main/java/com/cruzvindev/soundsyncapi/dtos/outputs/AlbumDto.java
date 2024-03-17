package com.cruzvindev.soundsyncapi.dtos.outputs;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlbumDto {

    @Schema(example = "1")
    private Long id;

    @Schema(example = "The Vanishing Race")
    private String titulo;

    @Schema(example = "1993")
    private String anoLancamento;

    private ArtistaResumoDto artista;

}
