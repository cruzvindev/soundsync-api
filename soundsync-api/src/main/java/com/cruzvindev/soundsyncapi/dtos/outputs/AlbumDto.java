package com.cruzvindev.soundsyncapi.dtos.outputs;


import com.cruzvindev.soundsyncapi.dtos.inputs.ArtistaIdInput;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlbumDto {

    private Long id;

    private String titulo;

    private String anoLancamento;

    private ArtistaResumoDto artista;

}
