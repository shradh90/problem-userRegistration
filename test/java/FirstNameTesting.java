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

public class FirstNameTesting {
    public String firstName;
    public Boolean expectedResult;

    public FirstNameTesting(String firstName, boolean expectedResult) {
        this.firstName = firstName;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection input() {
        return Arrays.asList(new Object[][]{
                {"Sayani", true},
                {"sayani", false},
                {"sa", false},
                {"sAyani", false},
                {null, false},
                {" ", false}
        });
    }

    /**
     * Purpose : Validate First Name with first letter starting with capital and has minimum 3 characters in it.
     */

    @Test
    public void givenfirstName_IsValidOrInvalid() throws UserRegistrationException {
        try {
            UserRegistrationImpl userImpl = new UserRegistrationImpl();
            userImpl.validateFirstName(this.firstName);
        } catch ( UserRegistrationException e) {
            Assert.assertEquals(UserRegistrationException.ExceptionType.INVALID_FIRST_NAME, e.type);
        }
    }
}
