package com.cruzvindev.soundsyncapi.domain.exception;

import lombok.Getter;

@Getter
public class NegocioException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public static final String TITULO_ERRO_PADRAO = "Recurso Inexistente";
    public static final String DESCRICAO_ERRO_PADRAO = "Erro de sistema, verifique sua requisição ou contate o suporte caso o problema persista";

    public NegocioException(String mensagem){
        super(mensagem);
    }
    public NegocioException(String mensagem, Throwable causa){
        super(mensagem, causa);
    }
}
