package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModification(){
    app.getContactHelper().goToContactListPage();
    if(! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("name_test", "lastname_test", "address_test", "+380731234567", "email-one.test@test.com", "test1"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().editContactButton(before.size() -1);
    ContactData contact = new ContactData(before.get(before.size() -1).getId(),"name_test", "lastname_test", null, null, null, null);
    app.getContactHelper().fillEditContactForm(new ContactData("name_test", "lastname_test", "edit", "edit", "edit", null), false);
    app.getContactHelper().submitEditContact();
    app.getContactHelper().goToContactListPage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() -1);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
