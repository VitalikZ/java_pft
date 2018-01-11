package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String id;
  private final String firstName;
  private final String lastName;
  private final String address;
  private final String mobilePhone;
  private final String emailOne;
  private String group;

  public String getId() {
    return id;
  }

  public ContactData(String id, String firstName, String lastName, String address, String mobilePhone, String emailOne, String group) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.mobilePhone = mobilePhone;
    this.emailOne = emailOne;
    this.group = group;
  }

  public ContactData( String firstName, String lastName, String address, String mobilePhone, String emailOne, String group) {
    this.id = null;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.mobilePhone = mobilePhone;
    this.emailOne = emailOne;
    this.group = group;
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
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }


}
