package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.concurrent.TimeUnit;

public class ContactCreationTests extends TestBase {

  @Test
  public void testCreateContact() {
    app.getContactHelper().goToAddNewContactPage();
    app.getContactHelper().fillAddNewContactForm(new ContactData("Vitalii", "Zakorchevnyy", "Kiev", "+380731234567", "vitalii.zakorchevnyy@gmail.com"));
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  }
}



