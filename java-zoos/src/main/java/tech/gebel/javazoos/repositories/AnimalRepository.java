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
    "animals.animal_type animal_type, " +
    "animals.animal_id, " +
    "count(zoos_animals.zoo_id) zoo_count " +
    "FROM animals " +
    "JOIN zoos_animals " +
    "ON zoos_animals.animal_id = animals.animal_id " +
    "GROUP BY animal_type",
    nativeQuery = true
  )
  List<AnimalZooCount> getAnimalZooCount();
}
