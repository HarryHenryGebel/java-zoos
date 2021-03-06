package tech.gebel.javazoos.services;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import tech.gebel.javazoos.models.Zoo;
import tech.gebel.javazoos.repositories.ZooRepository;

@Service
public class ZooServiceImplementation implements ZooService {
  private final ZooRepository zooRepository;

  public ZooServiceImplementation(ZooRepository zooRepository) {
    this.zooRepository = zooRepository;
  }

  @Override
  public List<Zoo> getZoos() {
    List<Zoo> zoos = new ArrayList<>();
    for (Zoo zoo : zooRepository.findAll()) zoos.add(zoo);
    return zoos;
  }

  @Override
  public Zoo findZooById(long id) {
    return zooRepository
      .findById(id)
      .orElseThrow(
        () ->
          new EntityNotFoundException(
            String.format("Zoo with id %d not found", id)
          )
      );
  }
}
