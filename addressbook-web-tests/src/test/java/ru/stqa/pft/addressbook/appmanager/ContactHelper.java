package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void goToContactListPage() {
    click(By.linkText("home"));
  }

  public void goToAddNewContactPage() {
    click(By.linkText("add new"));
  }

  public void fillAddNewContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("address"), contactData.getAddressOne());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("email"), contactData.getEmailOne());
    attach(By.name("photo"), contactData.getPhoto());
  }

  public void fillAddNewContactFormWithEmails(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("address"), contactData.getAddressOne());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("email"), contactData.getEmailOne());
    type(By.name("email2"), contactData.getEmailTwo());
    type(By.name("email3"), contactData.getEmailThree());
  }

  public void fillAddNewContactFormWithAddresses(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("address"), contactData.getAddressOne());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("address"), contactData.getAddressOne());
    type(By.name("address2"), contactData.getAddressTwo());
  }

  public void fillEditContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("address"), contactData.getAddressOne());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("email"), contactData.getEmailOne());

    if (creation) {
      if (contactData.getGroups().size() > 0) {
        Assert.assertTrue(contactData.getGroups().size() == 1);
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroups().iterator().next().getName());
      }
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

/*  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
    //click(By.name("selected[]"));
  }*/


  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void initModifyById(int id) {
    //wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr/td/a/img[@title='Edit']")).get(index).click();
    //wd.findElements(By.cssSelector("img[alt='Edit']")).get(index).click();
    wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
  }

  public void submitContactDeletion() {
    click(By.xpath("//*[@id='content']/form[2]/div[2]/input"));
  }

  public void submitEditContact() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public void acceptDeletionAlert() {
    wd.switchTo().alert().accept();
  }

  public void createContact(ContactData contact) {
    goToAddNewContactPage();
    fillAddNewContactForm(contact);
    submitContactCreation();
    contactCache = null;
    goToContactListPage();
  }

  public void createContactNew(ContactData contact) {
    goToAddNewContactPage();
    fillEditContactForm(contact, true);
    submitContactCreation();
    contactCache = null;
    goToContactListPage();
  }

  public void createContactWithEmails(ContactData contact) {
    goToAddNewContactPage();
    fillAddNewContactFormWithEmails(contact);
    submitContactCreation();
    contactCache = null;
    goToContactListPage();
  }

  public void createContactWithAddresses(ContactData contact) {
    goToAddNewContactPage();
    fillAddNewContactFormWithAddresses(contact);
    submitContactCreation();
    contactCache = null;
    goToContactListPage();
  }

  public void modifyContact(ContactData contact) {
    initModifyById(contact.getId());
    fillEditContactForm(contact, false);
    submitEditContact();
    contactCache = null;
    goToContactListPage();
  }

  public void deleteContact(ContactData contact) {
    selectContactById(contact.getId());
    submitContactDeletion();
    acceptDeletionAlert();
    contactCache = null;
    goToContactListPage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCounter() {
    return wd.findElements(By.cssSelector("img[alt='Edit']")).size();
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null){
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      String firstname = element.findElement(By.xpath(".//td[3]")).getText();
      String lastname = element.findElement(By.xpath(".//td[2]")).getText();
      String allphones = element.findElement(By.xpath(".//td[6]")).getText();
      String allEmails = element.findElement(By.xpath(".//td[5]")).getText();
      String allAddresses = element.findElement(By.xpath(".//td[4]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contactCache.add(new ContactData().withId(id).withFirstName(firstname).withLastName(lastname)
              .withAllPhones(allphones)
              .withAllEmails(allEmails)
              .withAllAddresses(allAddresses));
    }
    return new Contacts(contactCache);
  }

  public ContactData infoFromEditFormPhones(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstName(firstname).withLastName(lastname)
            .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);
  }

  public ContactData infoFromEditFormEmails(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String emailOne = wd.findElement(By.name("email")).getAttribute("value");
    String emailTwo = wd.findElement(By.name("email2")).getAttribute("value");
    String emailThree = wd.findElement(By.name("email3")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstName(firstname).withLastName(lastname)
            .withEmailOne(emailOne).withEmailTwo(emailTwo).withEmailTree(emailThree);
  }

  public ContactData infoFromEditFormAddresses(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String addressOne = wd.findElement(By.name("address")).getAttribute("value");
    String addressTwo = wd.findElement(By.name("address2")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstName(firstname).withLastName(lastname)
            .withAddressOne(addressOne);
  }

  private void initContactModificationById(int id){
    WebElement checkbox = wd.findElement((By.cssSelector(String.format("input[value='%s']", id))));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement((By.tagName("a"))).click();
  }
}




//Like in example
/*
  public Set<ContactData> allTwo() {
    Set<ContactData> contacts = new HashSet<ContactData>();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String[] phones = cells.get(5).getText().split("\n");
      contacts.add(new ContactData().withId(id).withFirstName(firstname).withLastName(lastname)
              .withHomePhone(phones[0]).withMobilePhone(phones[1]).withWorkPhone(phones[2]));
    }
    return contacts;
  }*/
