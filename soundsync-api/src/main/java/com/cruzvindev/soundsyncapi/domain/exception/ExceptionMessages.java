package com.cruzvindev.soundsyncapi.domain.exception;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ExceptionMessages {


    private final String TITULO_RECURSO_INEXISTENTE = "Recurso Inexistente";
    private final String TITULO_RECURSO_EM_USO = "Recurso em Uso";
    private final String CAMPOS_INVALIDOS = "Campos Inválidos";
    private final String ERRO_DE_SINTAXE = "Mensagem Incomprieensível";

    private final String URL_BASE = "https://soundsync.com.br/";


    public String getURL(String url){
        return URL_BASE + url;
    }
}
