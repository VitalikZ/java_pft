package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeleteFromGroupTests extends TestBase {

  @BeforeMethod
  public void preCondition() {

    List<Groups> listGroups = new ArrayList<Groups>();
    for (ContactData cd : app.db().contacts()) {
      listGroups.add(cd.getGroups());
    }
    if (listGroups.size() == 0) {
      if (app.db().groups().size() == 0) {
        app.goTo().groupPage();
        GroupData group = new GroupData().withName("test1")
                .withHeader("test2")
                .withFooter("test3");
        app.group().create(group);
      }
      app.contact().goToAddNewContactPage();
      app.contact().createContact(new ContactData().withFirstName("firstname1")
              .withLastName("lastname1").inGroup(app.db().groups().iterator().next()));
    }
  }

  @Test
  public void deleteFromGroupTest() {
    Contacts contacts = app.db().contacts();
    ContactData contact = new ContactData();
    for (ContactData cd : contacts) {
      if (!cd.getGroups().isEmpty()) {
        contact = cd;
        break;
      }
    }
    GroupData group = contact.getGroups().iterator().next();
    app.goTo().goToHomePage();
    app.contact().deleteFromGroup(contact, group);
    Groups groupsAfter = new Groups();
    for (ContactData cd : app.db().contacts()) {
      if (cd.getId() == contact.getId()) {
        groupsAfter = cd.getGroups();
        break;
      }
    }
    assertThat(groupsAfter, equalTo(contact.getGroups().without(group)));
  }
}
