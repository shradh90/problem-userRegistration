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
public class PhoneNumberTesting {
    public String phoneNumber;
    public Boolean expectedResult;

    public PhoneNumberTesting(String phoneNumber, boolean expectedResult) {
        this.phoneNumber = phoneNumber;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection input() {
        return Arrays.asList(new Object[][]{
                {"0 7894561230", true},
                {"91 7894561230", true},
                {"01 7894561230", false},
                {"91 78945612", false},
                {"5 7894561230", false},
                {null, false},
                {" ", false}
        });
    }

    /**
     * Purpose : Validate Phone Number with 0|91 in the beginning, followed by a white space, followed by 10 digit number.
     */

    @Test
    public void givenlastName_IsValidOrInvalid() throws UserRegistrationException {
        try {
            UserRegistrationImpl userImpl = new UserRegistrationImpl();
            userImpl.validatePhoneNumber(this.phoneNumber);
        } catch ( UserRegistrationException e) {
            Assert.assertEquals(UserRegistrationException.ExceptionType.INVALID_PHONE_NUMBER, e.type);
        }
    }
}