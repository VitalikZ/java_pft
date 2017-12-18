package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModification(){
    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().editFirstContactButton();
    app.getContactHelper().fillEditContactForm(new ContactData("edit", "edit", "edit", "edit", "edit", null), false);
    app.getContactHelper().submitEditContact();
    app.getNavigationHelper().goToHomePage();
  }
}
