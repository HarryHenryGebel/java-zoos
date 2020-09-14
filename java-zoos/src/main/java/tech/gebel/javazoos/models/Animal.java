package tech.gebel.javazoos.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "animals")
public class Animal extends Auditable {
  @Id
  @GeneratedValue
  private long animalId;

  @Column(name = "animal_type")
  private String animalType;

  @ManyToMany
  @JoinTable(
    name = "zoo_animals",
    joinColumns = @JoinColumn(name = "animal_id"),
    inverseJoinColumns = @JoinColumn(name = "zoo_id"))
  private Set<Zoo> zoos = new HashSet<>();

  public Animal() {
  }

  public Set<Zoo> getZoos() {
    return zoos;
  }

  public void setZoos(Set<Zoo> zoos) {
    this.zoos = zoos;
  }

  public long getAnimalId() {
    return animalId;
  }

  public void setAnimalId(long animalId) {
    this.animalId = animalId;
  }

  public String getAnimalType() {
    return animalType;
  }

  public void setAnimalType(String animalType) {
    this.animalType = animalType;
  }
}
