package com.api.test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.requests.LoginRequest;
import com.api.models.requests.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import groovy.util.logging.Log;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileModifyTest {

    @Test(description = "Verify Profile modification API is working")
    public void profileMod(){
        AuthService authService=new AuthService();
       Response response= authService.login(new LoginRequest("deborahch1","testing123"));
        LoginResponse loginResponse=response.as(LoginResponse.class);
        System.out.println(response.asPrettyString());
        System.out.println("============================");

        UserProfileManagementService userProfileManagementService=new UserProfileManagementService();
        response=userProfileManagementService.getProfile(loginResponse.getToken());
        System.out.println(response.asPrettyString());
        UserProfileResponse userProfileResponse=response.as(UserProfileResponse.class);
        Assert.assertEquals(userProfileResponse.getUsername(),"deborahch1");
        System.out.println("============================");

        ProfileRequest profileRequest=new ProfileRequest.Builder()
                .setFirstName("Deborah")
                .setLastName("Tejdeep")
                .setEmail("tejdeepchinthamalla@gmail.com")
                .setMobileNumber("9030207590")
                .build();
       response= userProfileManagementService.updateProfile(loginResponse.getToken(),profileRequest);
        System.out.println(response.asPrettyString());
    }
}
