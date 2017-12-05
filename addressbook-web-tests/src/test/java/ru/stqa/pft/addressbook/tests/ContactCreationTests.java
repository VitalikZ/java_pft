package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testCreateContact() {
    app.getContactHelper().goToAddNewContactPage();
    app.getContactHelper().fillAddNewContactForm(new ContactData("Vitalii", "Zakorchevnyy", "Kiev", "+380731234567", "vitalii.zakorchevnyy@gmail.com"));
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  }
}



