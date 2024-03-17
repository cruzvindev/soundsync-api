package com.cruzvindev.soundsyncapi.dtos.outputs;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArtistaDto {

    @Schema(example = "1")
    private Long id;

    @Schema(example = "Michael Jackson")
    private String nome;

    @Schema(example = "Estados Unidos")
    private String origem;

    @Schema(example = "Nasceu na cidade de Gary nos EUA no ano 1958 e se tornou um dos maiores artistas da história")
    private String biografia;
}
