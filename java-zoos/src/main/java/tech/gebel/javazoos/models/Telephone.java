package tech.gebel.javazoos.models;

import javax.persistence.*;

@Entity
@Table(name = "telephones")
public class Telephone extends Auditable {
  @Id
  @GeneratedValue
  @Column(name = "phone_id")
  private long phoneId;

  @Column(name = "phone_type")
  private String phoneType = "";

  @Column(name = "phone_number")
  private String phoneNumber = "";

  @ManyToOne
  @JoinColumn(name = "zoo_id")
  private Zoo zoo;

  public Telephone() {}

  public long getPhoneId() {
    return phoneId;
  }

  public void setPhoneId(long phoneId) {
    this.phoneId = phoneId;
  }

  public String getPhoneType() {
    return phoneType;
  }

  public void setPhoneType(String phoneType) {
    this.phoneType = phoneType;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public Zoo getZoo() {
    return zoo;
  }

  public void setZoo(Zoo zoo) {
    this.zoo = zoo;
  }
}
