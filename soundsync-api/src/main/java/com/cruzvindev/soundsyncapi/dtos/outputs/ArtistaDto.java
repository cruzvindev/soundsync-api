package com.cruzvindev.soundsyncapi.dtos.outputs;

import io.swagger.v3.oas.annotations.media.Schema;

public record ArtistaDto(    @Schema(example = "1")
                             Long id,

                             @Schema(example = "Michael Jackson")
                             String nome,

                             @Schema(example = "Estados Unidos")
                             String origem,

                             @Schema(example = "Nasceu na cidade de Gary nos EUA no ano 1958 e se tornou um dos maiores artistas da história")
                             String biografia) { }
