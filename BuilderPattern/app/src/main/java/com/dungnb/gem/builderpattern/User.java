package com.dungnb.gem.builderpattern;

public class User {
  private String firstName;
  private String lastName;
  private int age;

  private User(Builder builder) {
    this.firstName = builder.firstName;
    this.lastName = builder.lastName;
    this.age = builder.age;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public int getAge() {
    return age;
  }

  static class Builder {
    private String firstName;
    private String lastName;
    private int age;

    public Builder setFirstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    public Builder setLastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    public Builder setAge(int age) {
      this.age = age;
      return this;
    }

    public User create() {
      return new User(this);
    }
  }
}
