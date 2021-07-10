package controller;

import exception.UserRegistrationException;
import userregistrationservice.UserRegistrationImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class EmailTesting {
    public String email;
    public Boolean expectedResult;

    public EmailTesting(String email, boolean expectedResult) {
        this.email = email;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection input() {
        return Arrays.asList(new Object[][] {
                { "abc@yahoo.com", true } ,
                { "abc-100@yahoo.com", true } ,
                { "abc.100@yahoo.com", true } ,
                { "abc111@abc.com", true } ,
                { "abc-100@abc.net", true } ,
                { "abc.100@abc.com.au", true } ,
                { "abc@1.com", true } ,
                { "abc@gmail.com.com", true } ,
                { "abc+100@gmail.com", true } ,
                { "abc", false } ,
                { "abc@.com.my", false } ,
                { "abc123@gmail.a", false } ,
                { "abc123@.com", false } ,
                { "abc123@.com.com", false } ,
                { ".abc@abc.com", false } ,
                { "abc()*@gmail.com", false } ,
                { "abc@%*.com", false } ,
                { "abc..2002@gmail.com", false } ,
                { "abc.@gmail.com", false } ,
                { "abc@abc@gmail.com", false } ,
                { "abc@gmail.com.1a", false } ,
                { "abc@gmail.com.aa.au", false }
        } );
    }

    /**
     * Purpose : Validate Emails using regex
     */

    @Test
    public void givenEmail_IsValidOrInvalid() throws UserRegistrationException {
        try {
            UserRegistrationImpl userImpl = new UserRegistrationImpl();
            userImpl.validateEmail(this.email);
        } catch ( UserRegistrationException e) {
            Assert.assertEquals(UserRegistrationException.ExceptionType.INVALID_EMAIL_ID, e.type);
        }
    }
}
