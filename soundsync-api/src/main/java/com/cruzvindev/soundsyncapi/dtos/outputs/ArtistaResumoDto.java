package com.cruzvindev.soundsyncapi.dtos.outputs;

import io.swagger.v3.oas.annotations.media.Schema;


public record ArtistaResumoDto( @Schema(example = "1")
                                Long id,
                                @Schema(example = "Air Supply")
                                String nome) { }
