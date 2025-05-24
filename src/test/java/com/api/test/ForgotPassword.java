package com.api.test;

import com.api.base.AuthService;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ForgotPassword {

    @Test(description = "Verify if reset password API is working")
    public void forgotPasswordTest() {
        AuthService authService = new AuthService();
        Response response = authService.forgotPassword("tejdeepchinthamalla@gmail.com");
        System.out.println(response.asPrettyString());
    }
}
