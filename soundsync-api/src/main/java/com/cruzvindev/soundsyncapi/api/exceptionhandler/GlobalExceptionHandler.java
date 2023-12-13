package com.cruzvindev.soundsyncapi.api.exceptionhandler;


import com.cruzvindev.soundsyncapi.domain.exception.NegocioException;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.OffsetDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NegocioException.class)
    ProblemDetail handleNegocioException(NegocioException e) throws URISyntaxException {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
        problemDetail.setType(new URI("https://soundsync.com.br/recurso-nao-encontrado"));
        problemDetail.setTitle("Erro de sistema, verifique sua requisição ou contate o suporte");
        problemDetail.setDetail(e.getMessage());
        problemDetail.setProperty("TimeStamp:", OffsetDateTime.now());
        return problemDetail;
    }


}
