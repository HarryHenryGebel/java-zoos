package tech.gebel.javazoos.models;

import javax.persistence.*;

@Entity
@Table(name = "zoos")
public class Zoo {
  @Id
  @Column(name = "zoo_id")
  @GeneratedValue
  private long zooId;

  @Column(name = "zoo_name")
  private String zooName;

  public Zoo() {
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
