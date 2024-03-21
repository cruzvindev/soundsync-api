package com.cruzvindev.soundsyncapi.dtos.inputs;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;


public record ArtistaIdInput(
        @Schema(example = "1")
        @NotNull
        Long id) { }
