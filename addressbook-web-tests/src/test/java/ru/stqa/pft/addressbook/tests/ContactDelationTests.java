package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDelationTests extends TestBase{

  @Test
  public void testDeleteContact(){
    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().chooseRandomContact();
    app.getContactHelper().submitContactDeletion();
    app.getContactHelper().acceptDeletionAlert();
    app.getNavigationHelper().goToHomePage();
  }
}
