package tech.gebel.javazoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "zoos")
public class Zoo {
  @Id
  @Column(name = "zoo_id")
  @GeneratedValue
  private long zooId;

  @Column(name = "zoo_name")
  private String zooName = "";

  @OneToMany(mappedBy = "zoo", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonIgnoreProperties(value = "zoo", allowSetters = true)
  private Set<Telephone> telephones = new HashSet<>();

  public Zoo() {}

  public Set<Telephone> getTelephones() {
    return telephones;
  }

  public void setTelephones(Set<Telephone> telephones) {
    this.telephones = telephones;
  }

  public Zoo(long zooId, String zooName) {
    this.zooId = zooId;
    this.zooName = zooName;
  }

  public long getZooId() {
    return zooId;
  }

  public void setZooId(long zooId) {
    this.zooId = zooId;
  }

  public String getZooName() {
    return zooName;
  }

  public void setZooName(String zooName) {
    this.zooName = zooName;
  }
}
