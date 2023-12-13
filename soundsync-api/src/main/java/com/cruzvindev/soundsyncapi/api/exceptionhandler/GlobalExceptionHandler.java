package com.cruzvindev.soundsyncapi.api.exceptionhandler;


import com.cruzvindev.soundsyncapi.domain.exception.EntidadeEmUsoException;
import com.cruzvindev.soundsyncapi.domain.exception.EntidadeNaoEncontradaException;
import com.cruzvindev.soundsyncapi.domain.exception.ExceptionMessages;
import com.cruzvindev.soundsyncapi.domain.exception.NegocioException;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.URI;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private ExceptionMessages exceptionMessages;


    public static final String MSG_ERRO_GENERICA_USUARIO_FINAL = "Ocorreu um erro interno inesperado no sistema. Tente novamente e se o "
            + "problema persistir, entre em contato com o "
            + "administrador do sistema";

    public static final String MSG_CAMPOS_INVALIDOS = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente";

    @SneakyThrows
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

            ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage());
            problemDetail.setStatus(HttpStatus.BAD_REQUEST);
            problemDetail.setTitle("Mensagem Icompreessível");
            problemDetail.setDetail(MSG_CAMPOS_INVALIDOS);
            problemDetail.setProperty("timeStamp:", OffsetDateTime.now(ZoneOffset.UTC)
                    .format( DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX")));
            problemDetail.setType(new URI("https://www.youtube.com.br"));

            return handleExceptionInternal(ex, problemDetail, headers, status, request);

    }

    @SneakyThrows
    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ResponseEntity<Object> handleEntidadeNaoEncontrada(EntidadeNaoEncontradaException ex, WebRequest request) {

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getLocalizedMessage());
        problemDetail.setStatus(HttpStatus.NOT_FOUND);
        problemDetail.setTitle("Recurso Inexistente");
        problemDetail.setDetail(ex.getMessage());
        problemDetail.setProperty("timeStamp:", OffsetDateTime.now(ZoneOffset.UTC)
                .format( DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX")));
        problemDetail.setType(new URI("https://www.youtube.com.br"));

        return handleExceptionInternal(ex, problemDetail, new HttpHeaders(), HttpStatus.NOT_FOUND, request);

    }

    @SneakyThrows
    @ExceptionHandler(EntidadeEmUsoException.class)
    public ResponseEntity<Object> handleEntidadeEmUso(EntidadeEmUsoException ex, WebRequest request) {

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, ex.getLocalizedMessage());
        problemDetail.setStatus(HttpStatus.CONFLICT);
        problemDetail.setTitle("Recurso em Uso");
        problemDetail.setDetail(ex.getMessage());
        problemDetail.setProperty("timeStamp:", OffsetDateTime.now(ZoneOffset.UTC)
                .format( DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX")));
        problemDetail.setType(new URI("https://www.youtube.com.br"));

        return handleExceptionInternal(ex, problemDetail, new HttpHeaders(), HttpStatus.CONFLICT, request);

    }

    @SneakyThrows
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage());
        problemDetail.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        problemDetail.setTitle("Erro de Validação");
        problemDetail.setDetail(MSG_CAMPOS_INVALIDOS);
        problemDetail.setProperty("timeStamp:", OffsetDateTime.now(ZoneOffset.UTC)
                .format( DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX")));
        problemDetail.setType(new URI("https://www.youtube.com.br"));

        return handleExceptionInternal(ex, problemDetail, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
        return super.handleExceptionInternal(ex, body, headers, statusCode, request);
    }



}
