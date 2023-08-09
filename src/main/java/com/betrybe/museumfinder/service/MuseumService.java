
package com.betrybe.museumfinder.service;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.util.CoordinateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Um serviço que implementa a interface MuseumServiceInterface e oferece
 * funcionalidades relacionadas aos museus.
 */

@Service
public class MuseumService implements MuseumServiceInterface {

  private final MuseumFakeDatabase museumFakeDatabase;

  @Autowired
    public MuseumService(MuseumFakeDatabase museumFakeDatabase) {
    this.museumFakeDatabase = museumFakeDatabase;
  }

  @Override
    public Museum getClosestMuseum(Coordinate coordinate, Double maxDistance) {
    if (!CoordinateUtil.isCoordinateValid(coordinate)) {
      throw new InvalidCoordinateException("invalido");
    }
    return museumFakeDatabase.getClosestMuseum(coordinate, maxDistance).orElseThrow(
            () -> new MuseumNotFoundException("nenhum museu encontrado."));
  }

  @Override
    public Museum createMuseum(Museum museum) {

    if (!CoordinateUtil.isCoordinateValid(museum.getCoordinate())) {
      throw new InvalidCoordinateException("invalido");
    }
    return museumFakeDatabase.saveMuseum(museum);
  }

  @Override
    public Museum getMuseum(Long id) {
    return null;
  }
}