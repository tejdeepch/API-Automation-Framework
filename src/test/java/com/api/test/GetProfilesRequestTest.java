package com.api.test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.requests.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(com.api.listeners.TestListener.class)
public class GetProfilesRequestTest {
    @Test(description = "Validating profiles endpoint")
    public void getProfileInfoTest() {
        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("tejdeep", "testing123"));
        LoginResponse loginResponse = response.as(LoginResponse.class);
        System.out.println(loginResponse.getToken());
      UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
               response=userProfileManagementService.getProfile(loginResponse.getToken());
        System.out.println(response.asPrettyString());
      UserProfileResponse userProfileResponse=response.as(UserProfileResponse.class);
      System.out.println(userProfileResponse.toString());
        Assert.assertTrue(userProfileResponse.getUsername() != null);
    }
}
