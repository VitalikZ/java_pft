package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
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

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
    //click(By.name("selected[]"));
  }
  /*public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
    click(By.name("selected[]"));
  }*/

  /*public void selectEditContactButton(int index) {
    wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[@class='center']/a/img[@title='Edit']")).get(index).click();
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[@class='center']/a/img[@title='Edit']"));
  }*/

  public void editFirstContactButton111() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void editContactButton(int index) {
    //wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr/td/a/img[@title='Edit']")).get(index).click();
    wd.findElements(By.cssSelector("img[alt='Edit']")).get(index).click();
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
    goToContactListPage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

 /* public int getContactCounter1111() {
    return wd.findElements(By.name("selected[]")).size();
  }*/

  public int getContactCounter() {
    return wd.findElements(By.cssSelector("img[alt='Edit']")).size();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements){
      String name_test = element.findElement(By.xpath(".//td[3]")).getText();
      String lastname_test = element.findElement(By.xpath(".//td[2]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData(id, name_test, lastname_test, null, null, null, null);
      contacts.add(contact);
    }
    return contacts;
  }
}
