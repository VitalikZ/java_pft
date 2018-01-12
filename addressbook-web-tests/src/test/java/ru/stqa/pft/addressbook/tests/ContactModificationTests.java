package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    app.contact().goToContactListPage();
    if(! app.contact().isThereAContact()){
      app.contact().createContact(new ContactData("name_test", "lastname_test", "address_test", "+380731234567", "email-one.test@test.com", "test1"));
    }
  }

  @Test
  public void testContactModification(){
    List<ContactData> before = app.contact().list();
    int index = before.size() -1;
    ContactData contact = new ContactData(before.get(index).getId(),"name_test", "lastname_test", null, null, null, null);
    app.contact().modifyContact(index);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
