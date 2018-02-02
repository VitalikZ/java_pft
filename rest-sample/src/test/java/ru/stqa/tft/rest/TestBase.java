package ru.stqa.tft.rest;

import com.jayway.restassured.RestAssured;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;

public class TestBase {

  @BeforeClass

  public void init(){
    RestAssured.authentication = RestAssured.basic("28accbe43ea112d9feb328d2c00b3eed", "");
  }

  public void skipIfNotFixed(int issueId) {
    if (isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }

  private boolean isIssueOpen(int issueId) {
    return false;
  }
}
