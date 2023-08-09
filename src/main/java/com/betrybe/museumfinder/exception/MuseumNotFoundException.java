package com.betrybe.museumfinder.exception;

/**
 * Uma exceção personalizada que indica que uma coordenada inválida foi fornecida.*/

public class MuseumNotFoundException extends RuntimeException {

  public MuseumNotFoundException(String message) {
    super(message);
  }
}