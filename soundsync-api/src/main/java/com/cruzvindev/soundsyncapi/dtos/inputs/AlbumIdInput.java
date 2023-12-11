package com.cruzvindev.soundsyncapi.dtos.inputs;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlbumIdInput {

    @NotNull
    private Long id;
}
