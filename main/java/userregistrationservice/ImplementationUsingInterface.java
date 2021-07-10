package userregistrationservice;

import exception.UserRegistrationException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface ImplementationUsingInterface {
    public UserRegistrationInterface fNameValidtion = (String fname) -> {
        String regex = "^[A-Z]{1}[a-z]{2,}$";
        try {
            Pattern p = Pattern.compile(regex);

            if(fname.isEmpty())
                throw new UserRegistrationException("Please enter valid FIRST NAME!" , UserRegistrationException.ExceptionType.INVALID_FIRST_NAME);

            Matcher m = p.matcher(fname);
            return m.matches();
        } catch(Exception e) {
            throw new UserRegistrationException("Please enter valid FIRST NAME!" , UserRegistrationException.ExceptionType.INVALID_FIRST_NAME);
        }
    };

    /**
     * Purpose : Validate the user inputs for last name using regex and lambda expression
     *           If matches, return true else throw exception
     * Condition : First letter starting with capital and has minimum 3 characters in it.
     * @param : lastName
     */

    public UserRegistrationInterface lNameValidtion = (String lname) -> {
        String regex = "^[A-Z]{1}[a-z]{2,}$";
        try {
            Pattern p = Pattern.compile(regex);

            if(lname.isEmpty())
                throw new UserRegistrationException("Please enter valid LAST NAME!" , UserRegistrationException.ExceptionType.INVALID_LAST_NAME);

            Matcher m = p.matcher(lname);
            return m.matches();
        } catch(Exception e) {
            throw new UserRegistrationException("Please enter valid LAST NAME!" , UserRegistrationException.ExceptionType.INVALID_LAST_NAME);
        }
    };

    /**
     * Purpose : Validate the user inputs for phone number using regex and lambda expression
     *           If matches, return true else false
     * Condition : 0/91, followed by space, 10 digit number
     * @param : number
     */

    public UserRegistrationInterface phoneNumberValidtion = (String number) -> {
        //String regex = "(0|91)?[\\s][0-9]{10}";
        String regex = "^(0|91){1,2}[0-9]{10}$";  //use this regex when user gives the input through main() since console does not allow space
        try {
            Pattern p = Pattern.compile(regex);

            if (number.isEmpty())
                throw new UserRegistrationException("Please enter valid PHONE NUMBER!" , UserRegistrationException.ExceptionType.INVALID_PHONE_NUMBER);

            Matcher m = p.matcher(number);
            return m.matches();
        } catch(Exception e) {
            throw new UserRegistrationException("Please enter valid PHONE NUMBER!" , UserRegistrationException.ExceptionType.INVALID_PHONE_NUMBER);
        }
    };

    /**
     * Purpose : Validate the user inputs for email using regex and lambda expression
     *           If matches, return true else throw exception
     * Condition : should have @ symbol.
     * @param : email
     */

    public UserRegistrationInterface emailValidtion = (String email) -> {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:([0-9-]{1}|[a-zA-Z]{3,5})\\.)+[a-zA-Z]{2,3}";
        try {
            Pattern p = Pattern.compile(regex);

            if(email.isEmpty())
                throw new UserRegistrationException("Please enter valid EMAIL!" , UserRegistrationException.ExceptionType.INVALID_EMAIL_ID);

            Matcher m = p.matcher(email);
            return m.matches();
        } catch(Exception e) {
            throw new UserRegistrationException("Please enter valid EMAIL!" , UserRegistrationException.ExceptionType.INVALID_EMAIL_ID);
        }
    };

    /**
     * Purpose : Validate the user inputs for password using regex and lambda expression
     *           If matches, return true else throw exception
     * Condition : Minimum 8 characters
     *             Should have atleast 1 upper case
     *             Should have atleast 1 numeric number
     *             Should have exactly 1 special character
     * @param : password
     */

    public UserRegistrationInterface passwordValidtion = (String password) -> {
        String regex = "^(?=.*[0-9])(?=[^@#$%^&+=]*[@#$%^&+=][^@#$%^&+=]*$)(?=.*[a-z])(?=.*[A-Z]).{8,}$";
        try {
            Pattern p = Pattern.compile(regex);

            if(password.isEmpty())
                throw new UserRegistrationException("Please enter valid PASSWORD!" , UserRegistrationException.ExceptionType.INVALID_PASSWORD);

            Matcher m = p.matcher(password);
            return m.matches();
        } catch(Exception e) {
            throw new UserRegistrationException("Please enter valid PASSWORD!" , UserRegistrationException.ExceptionType.INVALID_PASSWORD);
        }
    };
}
