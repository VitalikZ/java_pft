package ru.stqa.pft.addressbook.model;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private String firstName;
  private String lastName;
  private String address;
  private String mobilePhone;
  private String emailOne;
  private String group;

  public int getId() {
    return id;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public ContactData withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public ContactData withEmailOne(String emailOne) {
    this.emailOne = emailOne;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public String getFirstName() {

    return firstName;
  }

  public String getLastName() {

    return lastName;
  }

  public String getAddress() {

    return address;
  }

  public String getMobilePhone() {

    return mobilePhone;
  }

  public String getEmailOne() {

    return emailOne;
  }

  public String getGroup() {
    return group;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;
  }

  @Override
  public int hashCode() {
    int result = firstName != null ? firstName.hashCode() : 0;
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    return result;
  }
}



//Delete constructors, but now I left for few time

  /*public ContactData(int id, String firstName, String lastName, String address, String mobilePhone, String emailOne, String group) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.mobilePhone = mobilePhone;
    this.emailOne = emailOne;
    this.group = group;
  }

  public ContactData(String firstName, String lastName, String address, String mobilePhone, String emailOne, String group) {
    this.id = Integer.MAX_VALUE;

    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.mobilePhone = mobilePhone;
    this.emailOne = emailOne;
    this.group = group;
  }*/
