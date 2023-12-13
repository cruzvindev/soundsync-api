package com.cruzvindev.soundsyncapi.domain.exception;

import lombok.Getter;

@Getter
public class EntidadeNaoEncontradaException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public EntidadeNaoEncontradaException(String mensagem){
        super(mensagem);
    }
    public EntidadeNaoEncontradaException(String mensagem, Throwable causa){
        super(mensagem, causa);
    }

    public String getURI(){
       return "https://soundsync.com.br/musica-nao-encontrada";
    }
}
