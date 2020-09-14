package tech.gebel.javazoos.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tech.gebel.javazoos.models.Zoo;

@Repository
public interface ZooRepository extends CrudRepository<Zoo, Long> {}
