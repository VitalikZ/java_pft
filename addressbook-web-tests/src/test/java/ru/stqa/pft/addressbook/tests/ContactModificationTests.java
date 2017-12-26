package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModification(){
    app.getNavigationHelper().goToHomePage();
    int before = app.getContactHelper().getContactCounter();
    if(! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("name_test", "lastname_test", "address_test", "+380731234567", "email-one.test@test.com", "test1"));
    }
    app.getContactHelper().editFirstContactButton();
    app.getContactHelper().fillEditContactForm(new ContactData("edit", "edit", "edit", "edit", "edit", null), false);
    app.getContactHelper().submitEditContact();
    app.getNavigationHelper().goToHomePage();
    int after = app.getContactHelper().getContactCounter();
    Assert.assertEquals(after, before);
  }
}
