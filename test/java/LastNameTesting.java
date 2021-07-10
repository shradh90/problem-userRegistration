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
public class LastNameTesting {
    public String lastName;
    public Boolean expectedResult;

    public LastNameTesting(String lastName, boolean expectedResult) {
        this.lastName = lastName;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection input() {
        return Arrays.asList(new Object[][]{
                {"Koley", true},
                {"koley", false},
                {"ko", false},
                {"kOley", false},
                {null, false},
                {" ", false}
        });
    }

    /**
     * Purpose : Validate Last Name with first letter starting with capital and has minimum 3 characters in it.
     */

    @Test
    public void givenlastName_IsValidOrInvalid() throws UserRegistrationException {
        try {
            UserRegistrationImpl userImpl = new UserRegistrationImpl();
            userImpl.validateLastName(this.lastName);
        } catch ( UserRegistrationException e) {
            Assert.assertEquals(UserRegistrationException.ExceptionType.INVALID_LAST_NAME, e.type);
        }
    }
}