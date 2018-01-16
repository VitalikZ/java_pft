package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactPhoneTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().goToContactListPage();
    if ((app.contact().all().size() == 0)) {
      app.contact().createContact(new ContactData().withFirstName("test1FirstName").withMobilePhone("111"));
    }
  }

  @Test
  public void testContactPhones(){
    app.contact().goToContactListPage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
  }
}
