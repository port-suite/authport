package com.port.auth;

import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;

public class NewUserRes {
  private int responseCode;
  private String responseMessage;
  private String authToken;
  private String name;
  private String surname;


  public NewUserRes(int responseCode, String responseMessage, String authToken, String name, String surname) {
    this.responseCode = responseCode;
    this.responseMessage = responseMessage;
    this.authToken = authToken;
    this.name = name;
    this.surname = surname;
  }

  public int getResponseCode() {
    return this.responseCode;
  }

  public String getResponseMessage() {
    return this.responseMessage;
  }

  public String getName() {
    return this.name;
  }

  public String getSurname() {
    return this.surname;
  }

  public String getAuthToken() {
    return this.authToken;
  }

  public String toJsonString() {
    ObjectMapper mapper = new ObjectMapper();
    try {
      return mapper.writeValueAsString(this);
    } catch(JacksonException e) {
      System.out.println(e);
      return null;
    }
  }

}
