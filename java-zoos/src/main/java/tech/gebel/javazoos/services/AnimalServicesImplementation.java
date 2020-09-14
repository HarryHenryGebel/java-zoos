package tech.gebel.javazoos.services;

import java.util.List;
import org.springframework.stereotype.Service;
import tech.gebel.javazoos.repositories.AnimalRepository;
import tech.gebel.javazoos.views.AnimalZooCount;

@Service
public class AnimalServicesImplementation implements AnimalServices {
  private final AnimalRepository animalRepository;

  public AnimalServicesImplementation(AnimalRepository animalRepository) {
    this.animalRepository = animalRepository;
  }

  @Override
  public List<AnimalZooCount> getAnimalZooCounts() {
    return animalRepository.getAnimalZooCount();
  }
}
