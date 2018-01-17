package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressesTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().goToContactListPage();
    if ((app.contact().all().size() == 0)) {
      app.contact().createContactWithAddresses(new ContactData().withFirstName("1").withLastName("2").
              withAddressOne("World"));
    }
  }

  @Test
  public void testContactAddresses() {
    app.contact().goToContactListPage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditFormAddresses(contact);

    assertThat(contact.getAllAddresses(), equalTo(mergeAddresses(contactInfoFromEditForm)));
  }

  private String mergeAddresses(ContactData contact) {
    return Arrays.asList(contact.getAddressOne(), contact.getAddressTwo())
            .stream().filter((s -> !s.equals("")))
            .map(ContactAddressesTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String email){
    return email.replaceAll("\\s","").replaceAll("[-()]","");

  }
}
