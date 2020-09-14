package tech.gebel.javazoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "animals")
public class Animal extends Auditable {
  @Id
  @GeneratedValue
  private long animalId;

  @Column(name = "animal_type")
  private String animalType;

  /**
   * Animal's half of the ZoosAnimals join
   */
  @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL)
  @JsonIgnoreProperties(value = "animal", allowSetters = true)
  private Set<ZoosAnimals> zoosAnimals = new HashSet<>();

  public Animal() {}

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
