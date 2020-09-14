package tech.gebel.javazoos.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tech.gebel.javazoos.models.Animal;
import tech.gebel.javazoos.views.AnimalZooCount;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, Long> {
  @Query(
    value = "SELECT " +
    "animals.animal_type animalType, " +
    "animals.animal_id animalId, " +
    "count(zoos_animals.zoo_id) zooCount " +
    "FROM animals " +
    "JOIN zoos_animals " +
    "ON zoos_animals.animal_id = animals.animal_id " +
    "GROUP BY animal_type",
    nativeQuery = true
  )
  List<AnimalZooCount> getAnimalZooCount();
}
