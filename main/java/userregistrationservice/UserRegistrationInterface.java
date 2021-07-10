package userregistrationservice;

import exception.UserRegistrationException;
    @FunctionalInterface
    public interface UserRegistrationInterface {
        boolean validateEntries(String input) throws UserRegistrationException;
    }

