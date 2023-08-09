package com.betrybe.museumfinder.advice;

import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Manipula a exceção de coordenada inválida e retorna uma
 * resposta com status e uma mensagem de erro.
 * */
@RestControllerAdvice
public class AdviceHandler {

  @ExceptionHandler
    public ResponseEntity<String> handleInvalidCoordinateException(
            InvalidCoordinateException invalidCoordinateException) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Coordenada inválida!");
  }

  @ExceptionHandler
    public ResponseEntity<String> handleMuseumNotFoundException(
            MuseumNotFoundException museumNotFoundException) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Museu não encontrado!");
  }

  @ExceptionHandler
    public ResponseEntity<String> handleInternalServerError(Exception exception) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno!");
  }
}