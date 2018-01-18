package ru.stqa.pft.addressbook.model;

import java.io.File;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private String firstName;
  private String lastName;
  private String addressOne;
  private String addressTwo;
  private String mobilePhone;
  private String workPhone;
  private String homePhone;
  private String emailOne;
  private String emailTwo;
  private String emailThree;
  private String group;
  private String allPhones;
  private String allEmails;
  private String allAddresses;
  private File photo;

  public File getPhoto() {
    return photo;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public String getAllAddresses() {
    return allAddresses;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public ContactData withAllAddresses(String allAddresses) {
    this.allAddresses = allAddresses;
    return this;
  }


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

  public ContactData withAddressOne(String address) {
    this.addressOne = address;
    return this;
  }

  public ContactData withAddressTwo(String addressTwo) {
    this.addressTwo = addressTwo;
    return this;
  }

  public ContactData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public ContactData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public ContactData withEmailOne(String emailOne) {
    this.emailOne = emailOne;
    return this;
  }

  public ContactData withEmailTwo(String emailTwo) {
    this.emailTwo = emailTwo;
    return this;
  }

  public ContactData withEmailTree(String emailTree) {
    this.emailThree = emailTree;
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

  public String getAddressOne() {

    return addressOne;
  }

  public String getAddressTwo() {

    return addressTwo;
  }

  public String getMobilePhone() {

    return mobilePhone;
  }

  public String getHomePhone() {

    return homePhone;
  }

  public String getWorkPhone() {

    return workPhone;
  }

  public String getEmailOne() {

    return emailOne;
  }

  public String getEmailTwo() {

    return emailTwo;
  }

  public String getEmailThree() {

    return emailThree;
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

    if (id != that.id) return false;
    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    return result;
  }

}



//Delete constructors, but now I left for few time

  /*public ContactData(int id, String firstName, String lastName, String addressOne, String mobilePhone, String emailOne, String group) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.addressOne = addressOne;
    this.mobilePhone = mobilePhone;
    this.emailOne = emailOne;
    this.group = group;
  }

  public ContactData(String firstName, String lastName, String addressOne, String mobilePhone, String emailOne, String group) {
    this.id = Integer.MAX_VALUE;

    this.firstName = firstName;
    this.lastName = lastName;
    this.addressOne = addressOne;
    this.mobilePhone = mobilePhone;
    this.emailOne = emailOne;
    this.group = group;
  }*/
