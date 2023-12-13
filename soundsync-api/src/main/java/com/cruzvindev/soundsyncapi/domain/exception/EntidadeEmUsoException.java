package com.cruzvindev.soundsyncapi.domain.exception;

import lombok.Getter;

@Getter
public class EntidadeEmUsoException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public EntidadeEmUsoException(String mensagem){
        super(mensagem);
    }
    public EntidadeEmUsoException(String mensagem, Throwable causa){
        super(mensagem, causa);
    }

    public String getURI(){
        return "https://soundsync.com.br/entidade-em-uso";
    }
}