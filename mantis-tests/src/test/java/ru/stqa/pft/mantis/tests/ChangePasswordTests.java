package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.User;
import ru.stqa.pft.mantis.model.UserData;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ChangePasswordTests extends TestBase {

  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
  }

  @Test
  public void testChangePassword() throws IOException, MessagingException, InterruptedException {
    String password = "password";
    User users = app.db().user();
    UserData resetUserPass = users.iterator().next();
    UserData randomUser = new UserData().withId(resetUserPass.getId()).withEmail(resetUserPass.getEmail()).withUsername(resetUserPass.getUserName());
    app.session().loginToSystem();
    app.session().goToManageUsersPage();
    Thread.sleep(1000);
    app.session().selectUser(randomUser);
    Thread.sleep(3000);
    app.session().resetPasswordButton();
    List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
    String confirmationLink = findConfirmationLink(mailMessages, randomUser.getEmail());
    app.session().finishConfirmResetPassword(confirmationLink, password);
    assertTrue(app.newSession().login(randomUser.getUserName(), password));

  }

  private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }


  @AfterMethod(alwaysRun = true)
  public void stopMailServer() {
    app.mail().stop();
  }
}
