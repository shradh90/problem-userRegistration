package controller;

import exception.UserRegistrationException;
import userregistrationmodel.UserRegistration;
import userregistrationservice.ImplementationUsingInterface;
import userregistrationservice.UserRegistrationImpl;
import userregistrationutil.Util;

public class UserRegistrationMain {
    static boolean flag = false;
    static UserRegistration userRegistration = null;

    public static void validateUserEntries() throws UserRegistrationException {
        UserRegistrationImpl impl = new UserRegistrationImpl();

        //Validate First Name using REGEX
        flag = impl.validateFirstName(userRegistration.getFirstName());
        if(flag)
            System.out.println("First Name is valid");
        else
            System.out.println("First Name is invalid");

        //Validate Last Name using REGEX
        flag = impl.validateLastName(userRegistration.getLastName());
        if(flag)
            System.out.println("Last Name is valid");
        else
            System.out.println("Last Name is invalid");

        //Validate Mobile Number using REGEX
        flag = impl.validatePhoneNumber(userRegistration.getMobileNumber());
        if(flag)
            System.out.println("Mobile Number is valid");
        else
            System.out.println("Mobile Number is invalid");

        //Validate Email Address using REGEX
        flag = impl.validateEmail(userRegistration.getEmailAddress());
        if(flag)
            System.out.println("Email is valid");
        else
            System.out.println("Email is invalid");

        //Validate Password using REGEX
        flag = impl.validatePassword(userRegistration.getPassword());
        if(flag)
            System.out.println("Password is valid");
        else
            System.out.println("Password is invalid");
    }

    public static void validateUserEntriesUsingLambda() throws UserRegistrationException {

        ImplementationUsingInterface implInterface = new ImplementationUsingInterface();

        //Validate First Name using REGEX
        flag = implInterface.fNameValidtion.validateEntries(userRegistration.getFirstName());
        if(flag)
            System.out.println("First Name is valid");
        else
            System.out.println("First Name is invalid");

        //Validate Last Name using REGEX
        flag = implInterface.lNameValidtion.validateEntries(userRegistration.getLastName());
        if(flag)
            System.out.println("Last Name is valid");
        else
            System.out.println("Last Name is invalid");

        //Validate Mobile Number using REGEX
        flag = implInterface.phoneNumberValidtion.validateEntries(userRegistration.getMobileNumber());
        if(flag)
            System.out.println("Mobile number is valid");
        else
            System.out.println("Mobile number is invalid");

        //Validate Email Address using REGEX
        flag = implInterface.emailValidtion.validateEntries(userRegistration.getEmailAddress());
        if(flag)
            System.out.println("Email Address is valid");
        else
            System.out.println("Email Address is invalid");

        //Validate Password using REGEX
        flag = implInterface.passwordValidtion.validateEntries(userRegistration.getPassword());
        if(flag)
            System.out.println("Password is valid");
        else
            System.out.println("Password is invalid");

    }

    public static void main(String[] args) throws UserRegistrationException {

        Util utility = new Util();

        //User will input firstName, lastName, phoneNumber, email, password
        System.out.println("Please enter the following details");
        userRegistration = utility.userMenu();

        //Validate entries without the lambda expression
        //validateUserEntries();

        //Validate entries with lambda expression
        validateUserEntriesUsingLambda();

    }
}