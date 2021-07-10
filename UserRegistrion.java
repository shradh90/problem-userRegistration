public class UserRegistrion {
    package com.company.day19;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

    public class UserRegistrationProblem {
        static UserRegistrationProblem usr = new UserRegistrationProblem();

        public static void main(String[] args) {

            usr.userConsole();

        }

        /**
         * Purpose : User console to take input from user
         */
        public void userConsole(){
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter the First Name :");
            String firstName = scanner.next();

            System.out.println("Enter the Last Name :");
            String lastName = scanner.next();

            System.out.println("Enter the Email Address : ");
            String emailAddress = scanner.next();

            System.out.println("Enter Mobile Number : ");
            String mobileNumber = scanner.next();

            System.out.println("Enter the Password : ");
            String password = scanner.next();

            usr.validateDetails(firstName,lastName,emailAddress,mobileNumber,password);
        }

        /**
         * Purpose : Check whether first name entered is valid or not it should start with cap
         *           and should have minimum 3 chars
         *
         * @param firstName input from user
         * @return true if it is valid else false
         */
        public boolean checkFirstName(String firstName) {

            //first letter should be cap and should have min 3 letters
            String regex = "^[A-Z][a-z]{2,}";
            Pattern p = Pattern.compile(regex);

            if (firstName == null) {
                return false;
            }

            Matcher m = p.matcher(firstName);

            return m.matches();

        }

        /**
         * Purpose : Check whether last name entered is valid or not it should start with cap
         *           and should have minimum 3 chars
         *
         * @param lastName input from user
         * @return true if valid last name else false
         */
        public boolean checkLastName(String lastName) {

            //first letter should be cap and should have min 3 letters
            String regex = "^[A-Z][a-z]{2,}";
            Pattern p = Pattern.compile(regex);

            if (lastName == null) {
                return false;
            }

            Matcher m = p.matcher(lastName);

            return m.matches();

        }

        /**
         * Purpose : Checks whether email is valid email or not
         *
         * @param email input from user
         * @return true if email is valid else false
         */
        public boolean checkEmail(String email){

            //Validating email id
            String regex = "^[a-zA-Z0-9+._-]+@[A-Za-z0-9.-]+$";

            Pattern p = Pattern.compile(regex);

            if (email == null) {
                return false;
            }

            Matcher m = p.matcher(email);

            return m.matches();

        }

        /**
         * Purpose : To check whether mobile number is valid or not
         *
         * @param mNumber input from user
         * @return true if mobile number is valid else false
         */
        public boolean checkMobileNumber(String mNumber){

            /**
             * For India :
             * Begins with 0 or 91
             * Then contains 7,8 or 9
             * Then contains 9 digits
             */
            String regex = "(0|91)?[7-9][0-9]{9}";

            Pattern p = Pattern.compile(regex);

            if (mNumber == null) {
                return false;
            }

            Matcher m = p.matcher(mNumber);

            return m.matches();
        }

        /**
         * Purpose : Checks password contains minimum 8 characters
         * @param password
         * @return
         */
        public boolean checkPassword(String password){

            //Validating Password
            String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,}$";

            Pattern p = Pattern.compile(regex);

            if (password == null) {
                return false;
            }

            Matcher m = p.matcher(password);

            return m.matches();
        }

        /**
         * Purpose : It validate user details
         *
         * @param firstName input from user
         * @param lastName input from user
         * @param email input from user
         * @param mobileNumber input from user
         * @param password input from user
         */
        public void validateDetails(String firstName, String lastName, String email, String mobileNumber,String password){

            if (usr.checkFirstName(firstName))
                System.out.println("Valid First Name");
            else
                System.out.println("Invalid First Name");

            if(usr.checkLastName(lastName))
                System.out.println("Valid Last Name");
            else
                System.out.println("Invalid Last Name");

            if(usr.checkEmail(email))
                System.out.println("Valid Email Address");
            else
                System.out.println("Invalid Email Address");

            if(usr.checkMobileNumber(mobileNumber))
                System.out.println("Valid Mobile Number");
            else
                System.out.println("Invalid Mobile Number");

            if(usr.checkPassword(password))
                System.out.println("Valid Password");
            else
                System.out.println("Invalid Password");
        }
    
}
