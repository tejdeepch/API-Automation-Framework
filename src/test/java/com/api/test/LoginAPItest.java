package com.api.test;

import com.api.base.AuthService;
import com.api.models.requests.LoginRequest;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(com.api.listeners.TestListener.class)
public class LoginAPItest {
    @Test(description = "Verifying Login API is working ")
    public void loginTest() {
        LoginRequest loginRequest=new LoginRequest("tejdeep","test123");

        AuthService authService = new AuthService();
        Response response = authService.login(loginRequest);
 // System.out.println(response.asPrettyString());
  LoginResponse loginResponse=response.as(LoginResponse.class);
  System.out.println("Login Response is ========="+loginResponse.toString());
  Assert.assertEquals(loginResponse.getUsername(),"tejdeep");
  Assert.assertTrue(loginResponse.getEmail() != null);
    }
}
