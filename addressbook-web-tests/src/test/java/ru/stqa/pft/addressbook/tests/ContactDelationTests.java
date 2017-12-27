package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDelationTests extends TestBase{

  @Test
  public void testDeleteContact(){
    app.getContactHelper().goToContactListPage();
    if(! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("name_test", "lastname_test", "address_test", "+380731234567", "email-one.test@test.com", "test1"));
    }
    int before = app.getContactHelper().getContactCounter();
    app.getContactHelper().selectContact(before -1);
    app.getContactHelper().submitContactDeletion();
    app.getContactHelper().acceptDeletionAlert();
    app.getContactHelper().goToContactListPage();
    int after = app.getContactHelper().getContactCounter();
    Assert.assertEquals(after, before -1);

  }
}
