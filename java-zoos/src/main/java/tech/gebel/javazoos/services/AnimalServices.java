package tech.gebel.javazoos.services;

import java.util.List;
import org.springframework.stereotype.Service;
import tech.gebel.javazoos.views.AnimalZooCount;

@Service
public interface AnimalServices {
  List<AnimalZooCount> getAnimalZooCounts();
}
