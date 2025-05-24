package com.api.test;

import com.api.base.AuthService;
import com.api.models.requests.SignupRequest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class SignupTest {
    @Test(description = "Validating Signup endpoint")
    public void signupTestmethod(){
     SignupRequest signupRequest= new SignupRequest.Builder()
                .firstName("Deborah")
                .lastName("Chinthamalla")
                .mobileNumber("9030207577")
                .email("sunnydinakar@gmail.com")
                .username("deborahc1")
             .password("test123")
                .build();
        AuthService authService=new AuthService();
       Response response= authService.signUp(signupRequest);
        System.out.println(response.asPrettyString());
    }
}
