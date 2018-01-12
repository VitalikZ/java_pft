package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDelationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.getContactHelper().goToContactListPage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("name_test", "lastname_test", null, null, null, null));
    }
  }

  @Test
  public void testDeleteContact() {
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().submitContactDeletion();
    app.getContactHelper().acceptDeletionAlert();
    app.getContactHelper().goToContactListPage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);

  }
}
