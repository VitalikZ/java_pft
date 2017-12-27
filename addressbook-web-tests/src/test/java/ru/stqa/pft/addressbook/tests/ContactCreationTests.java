package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testCreateContact() {
    app.getContactHelper().goToContactListPage();
    int before = app.getContactHelper().getContactCounter();
    app.getContactHelper().createContact(new ContactData("name_test", "lastname_test", "address_test", "+380731234567", "email-one.test@test.com", "test1"));
    int after = app.getContactHelper().getContactCounter();

    Assert.assertEquals(after, before +1);
  }

}



