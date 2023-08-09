package com.betrybe.museumfinder.controller;

import com.betrybe.museumfinder.dto.MuseumDto;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import com.betrybe.museumfinder.util.ModelDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Uma classe controladora que trata das requisições relacionadas aos museus. */
@RestController
@RequestMapping("/museums")
public class MuseumController {
  private final MuseumServiceInterface museumServiceInterface;

  @Autowired
    public MuseumController(MuseumServiceInterface museumServiceInterface) {
    this.museumServiceInterface = museumServiceInterface;
  }

  /** Cria um novo museu e o retorna como um objeto MuseumDto. */
  @PostMapping
    public ResponseEntity<MuseumDto> createMuseum(@RequestBody Museum museum) {
    Museum newMuseum = museumServiceInterface.createMuseum(museum);
    MuseumDto museumDto = ModelDtoConverter.modelToDto(newMuseum);
    return ResponseEntity.status(HttpStatus.CREATED).body(museumDto);
  }
}