package com.cruzvindev.soundsyncapi.dtos.outputs;

import io.swagger.v3.oas.annotations.media.Schema;


public record AlbumResumoDto(  @Schema(example = "1")
                               Long id,
                               @Schema(example = "Bad")
                               String titulo) { }
