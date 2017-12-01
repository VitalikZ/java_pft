package ru.stqa.pft.addressbook;

public class ContactData {
  private final String firstName;
  private final String lastName;
  private final String address;
  private final String mobilePhone;
  private final String emailOne;

  public ContactData(String firstName, String lastName, String address, String mobilePhone, String emailOne) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.mobilePhone = mobilePhone;
    this.emailOne = emailOne;
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
}
