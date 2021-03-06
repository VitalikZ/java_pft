package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "addressbook")
@XStreamAlias("contact")
public class ContactData {
  @XStreamOmitField
  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;

  @Expose
  @Column(name = "firstname")
  private String firstName;

  @Expose
  @Column(name = "lastname")
  private String lastName;

  @Column(name = "mobile")
  @Type(type = "text")
  private String mobilePhone;

  @Column(name = "work")
  @Type(type = "text")
  private String workPhone;

  @Column(name = "home")
  @Type(type = "text")
  private String homePhone;

  @Transient
  private String addressOne;

  @Transient
  private String addressTwo;

  @Transient
  private String emailOne;

  @Transient
  private String emailTwo;

  @Transient
  private String emailThree;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "address_in_groups",
          joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
  private Set<GroupData> groups = new HashSet<GroupData>();

  @Transient
  private String allPhones;

  @Transient
  private String allEmails;

  @Transient
  private String allAddresses;

  @Transient
  private File photo;

  public int getId() {
    return id;
  }

  public File getPhoto() {
    return photo;
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

  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
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

  public Groups getGroups() {
    return new Groups(groups);
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

  public ContactData inGroup(GroupData group) {
    groups.add(group);
    return this;
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
