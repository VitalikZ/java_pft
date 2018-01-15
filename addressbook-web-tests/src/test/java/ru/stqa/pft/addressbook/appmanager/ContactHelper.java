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
    type(By.name("address"), contactData.getAddress());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("email"), contactData.getEmailOne());
  }

  public void fillEditContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("address"), contactData.getAddress());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("email"), contactData.getEmailOne());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
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
      String name_test = element.findElement(By.xpath(".//td[3]")).getText();
      String lastname_test = element.findElement(By.xpath(".//td[2]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contactCache.add(new ContactData().withId(id).withFirstName(name_test).withLastName(lastname_test));
    }
    return new Contacts(contactCache);
  }
}
