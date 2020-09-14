package tech.gebel.javazoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "zoos_animals")
public class ZoosAnimals extends Auditable implements Serializable {
  @Id
  @ManyToOne
  @JoinColumn(name = "zoo_id", nullable = false)
  @JsonIgnoreProperties(value = "animal_names", allowSetters = true)
  private Zoo zoo;

  @Id
  @ManyToOne
  @JoinColumn(name = "animal_id", nullable = false)
  @JsonIgnoreProperties(value = "zoo_names", allowSetters = true)
  private Animal animal;

  @Column(nullable = false)
  private String incomingZoo;

  public ZoosAnimals() {}

  public Zoo getZoo() {
    return zoo;
  }

  public void setZoo(Zoo zoo) {
    this.zoo = zoo;
  }

  public Animal getAnimal() {
    return animal;
  }

  public void setAnimal(Animal animal) {
    this.animal = animal;
  }

  public String getIncomingZoo() {
    return incomingZoo;
  }

  public void setIncomingZoo(String incomingZoo) {
    this.incomingZoo = incomingZoo;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) return true;
    if (object == null || getClass() != object.getClass()) return false;

    ZoosAnimals that = (ZoosAnimals) object;
    if (
      zoo == null || that.zoo == null || animal == null || that.animal == null
    ) return false;

    return (
      zoo.getZooId() == that.zoo.getZooId() &&
      animal.getAnimalId() == that.animal.getAnimalId()
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(zoo.getZooId(), animal.getAnimalId(), incomingZoo);
  }
}
