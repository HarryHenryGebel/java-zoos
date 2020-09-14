package tech.gebel.javazoos.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.gebel.javazoos.services.AnimalServices;
import tech.gebel.javazoos.views.AnimalZooCount;

@RestController
@RequestMapping("/animals")
public class AnimalController {
  private final AnimalServices animalServices;

  public AnimalController(AnimalServices animalServices) {
    this.animalServices = animalServices;
  }

  @GetMapping(value = "/count")
  private ResponseEntity<?> getAnimalCount() {
    List<AnimalZooCount> animalZooCounts = animalServices.getAnimalZooCount();
    return new ResponseEntity<>(animalZooCounts, HttpStatus.OK);
  }
}
