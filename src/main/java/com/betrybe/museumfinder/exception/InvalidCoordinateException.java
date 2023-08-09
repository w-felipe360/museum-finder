package com.betrybe.museumfinder.exception;

/**
 * Uma exceção personalizada que indica que uma coordenada inválida é fornecida.*/

public class InvalidCoordinateException extends RuntimeException {

  public InvalidCoordinateException(String message) {
    super(message);
  }
}