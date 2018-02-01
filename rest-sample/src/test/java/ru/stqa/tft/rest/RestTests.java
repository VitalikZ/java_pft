package ru.stqa.tft.rest;

import org.apache.http.client.fluent.Request;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.Executor;

import static org.testng.Assert.assertEquals;

public class RestTests {

  @Test

  public void testCreateIssue() throws IOException {
    Set<Issue> oldIssues = getIssue();
    Issue newIssue = new Issue();
    int issueId = createIssue(newIssue);
    Set<Issue> newIssues = getIssue();
    oldIssues.add(newIssue.withId(issueId));
    assertEquals(newIssues, oldIssues);
  }

  private Set<Issue> getIssue() throws IOException {
    getExecutor()
    String json = Request.Get("http://demo.bugify.com/api/issues.json").execute().returnContent().asString();
    return null;
  }

  private Executor getExecutor() {
    return Executor.newInstance().auth("LSGjeU4yP1X493ud1hNniA==", "");
  }

  private int createIssue(Issue issue) {
    return 0;
  }
}
