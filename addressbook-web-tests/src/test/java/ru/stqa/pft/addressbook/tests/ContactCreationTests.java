package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testCreateContact() {
    app.getContactHelper().goToContactListPage();
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData("name_test", "lastname_test", null, null, null, null);
    app.getContactHelper().createContact(contact);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() +1);

    before.add(contact);
    int max = 0;
    for(ContactData g : after){
      if(g.getId() > max){
        max = g.getId();
      }
    }
    contact.setId(max);
    Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));

  }

}



