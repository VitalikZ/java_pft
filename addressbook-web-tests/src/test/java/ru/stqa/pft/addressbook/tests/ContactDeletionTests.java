package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().goToContactListPage();
    if ((app.contact().list().size() == 0)) {
      app.contact().createContact(new ContactData("name_test", "lastname_test", null, null, null, null));
    }
  }

  @Test
  public void testDeleteContact() {
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    app.contact().deleteContact(index);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(index);
    Assert.assertEquals(before, after);

  }
}
