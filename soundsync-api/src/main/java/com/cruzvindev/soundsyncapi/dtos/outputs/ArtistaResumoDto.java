package com.cruzvindev.soundsyncapi.dtos.outputs;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArtistaResumoDto {

    @Schema(example = "1")
    private Long id;

    @Schema(example = "Air Supply")
    private String nome;
}
