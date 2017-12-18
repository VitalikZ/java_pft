package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstName;
  private final String lastName;
  private final String address;
  private final String mobilePhone;
  private final String emailOne;
  private String group;

  public ContactData(String firstName, String lastName, String address, String mobilePhone, String emailOne, String group) {
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
}
