package com.cruzvindev.soundsyncapi.dtos.outputs;

import io.swagger.v3.oas.annotations.media.Schema;

public record AlbumDto(@Schema(example = "1") Long id,
                       @Schema(example = "The Vanishing Race") String titulo,
                       @Schema(example = "1993") String anoLancamento,
                       ArtistaResumoDto artista) { }

