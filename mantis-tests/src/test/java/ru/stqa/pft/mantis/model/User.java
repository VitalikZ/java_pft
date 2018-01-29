package ru.stqa.pft.mantis.model;
import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class User extends ForwardingSet<UserData> {

  private Set<UserData> delegate;

  public User (List<UserData> users) {
    this.delegate = new HashSet<UserData>(users);
  }

  @Override
  protected Set<UserData> delegate() {
    return delegate;
  }

  public User(User users){
    this.delegate = new HashSet<UserData>(users.delegate);
  }
  public User(){
    this.delegate = new HashSet<UserData>();
  }
}