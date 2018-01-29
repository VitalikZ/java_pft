package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import ru.stqa.pft.mantis.model.UserData;

public class SessionHelper extends HelperBase{


  public SessionHelper(ApplicationManager app) {
    super(app);
  }

  public void loginToSystem(){
    String username = app.getProperty("web.adminLogin");
    String password = app.getProperty("web.adminPassword");
    wd.get(app.getProperty("web.baseUrl"));
    type(By.name("username"), username);
    type(By.name("password"), password);
    click(By.cssSelector("input[type='submit']"));

  }
  public void goToManageUsersPage() {
    wd.get(app.getProperty("web.baseUrl") + "manage_user_page.php");
  }
  public void selectUserById(int id){
    wd.findElement(By.xpath("//a[@href='manage_user_edit_page.php?user_id=" + id +"']")).click();
  }

  public void selectUser(UserData randomUser) {
    selectUserById(randomUser.getId());
  }

  public void resetPasswordButton() {
    //wd.findElement(By.cssSelector("body > div:nth-child(8) > form:nth-child(1) > input.button")).click();
    wd.findElement(By.cssSelector("input[value='Reset Password']")).click();
  }

  public void finishConfirmResetPassword(String confirmationLink, String password) {
    wd.get(confirmationLink);
    type(By.name("password"), password);
    type(By.name("password_confirm"), password);
    click(By.cssSelector("body > div:nth-child(7) > form > table > tbody > tr:nth-child(10) > td:nth-child(2) > input"));
    //click(By.cssSelector("button[value='Update User']"));
  }
}
