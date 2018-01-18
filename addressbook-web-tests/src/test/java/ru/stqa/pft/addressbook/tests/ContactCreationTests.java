package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void testCreateContact() {
    app.contact().goToContactListPage();
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/stu.png");
    ContactData contact = new ContactData().withLastName("test1LastName").withFirstName("test2firstName").withPhoto(photo);
    app.contact().createContact(contact);
    Contacts after = app.contact().all();
    assertThat(app.contact().getContactCounter(), equalTo(before.size() + 1));
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }
}










  /*@Test
  public void testBadCreateContact() {
    app.contact().goToContactListPage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withLastName("test1LastName'''").withFirstName("test2firstName");
    app.contact().createContact(contact);
    assertThat(app.contact().getContactCounter(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));
  }*/




