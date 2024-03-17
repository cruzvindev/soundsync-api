package com.cruzvindev.soundsyncapi.openapi;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Getter
@Schema(name = "Problema")
public class ProblemTypeOpenApi {

    @Schema(example = "https://soundsync.com.br/dados-invalidos")
    private String type;

    @Schema(example = "Dados inválidos")
    private String title;

    @Schema(example = "400")
    private String status;

    @Schema(example = "Um ou mais campos estão inválidos ! Tente novamente")
    private String detail;

    @Schema(example = "/v1/album/00")
    private String instance;

    @Schema(example = "2024-03-17T16:55:02.041Z")
    private OffsetDateTime timestamp;

    @Schema(description = "Lista de campos que geraram o erro")
    private List<Object> objects;

    @Builder
    @Getter
    @Schema(name = "ObjetoProblema")
    public static class Object{

        @Schema(example = "origem")
        private String name;

        @Schema(example = "A origem(nacionalidade) do artista é obrigatória")
        private String userMessage;
    }

}
