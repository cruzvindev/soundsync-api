package com.cruzvindev.soundsyncapi.dtos.inputs;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArtistaIdInput {

    @NotNull
    private Long id;
}
