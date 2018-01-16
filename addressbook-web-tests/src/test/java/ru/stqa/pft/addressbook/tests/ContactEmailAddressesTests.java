package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailAddressesTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().goToContactListPage();
    if ((app.contact().all().size() == 0)) {
      app.contact().createContactWithEmails(new ContactData().withFirstName("1").withLastName("2").
              withEmailOne("111@111.com").withEmailTwo("222@222.com").withEmailTree("333@333.com"));
    }
  }

  @Test
  public void testContactEmails() {
    app.contact().goToContactListPage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditFormEmails(contact);

    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmailOne(), contact.getEmailTwo(), contact.getEmailThree())
            .stream().filter((s -> !s.equals("")))
            .map(ContactEmailAddressesTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String email) {
    return email.replaceAll("\\s", "").replaceAll("[-()]", "");

  }
}

