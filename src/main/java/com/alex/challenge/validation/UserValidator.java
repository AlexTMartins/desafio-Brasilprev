package com.alex.challenge.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.alex.challenge.model.v1.Address;
import com.alex.challenge.model.v1.User;

public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        User user = (User) obj;
        if (checkInputString(user.getName())) {
            errors.rejectValue("name", "name.empty");
        }
        if (checkInputString(user.getDocument())) {
            errors.rejectValue("document", "document.empty");
        }
        if (checkInputString(user.getAddress())) {
            errors.rejectValue("address", "document.empty");
        }        
    }

    private boolean checkInputString(String input) {
        return (input == null || input.trim().length() == 0);
    }
    private boolean checkInputString(Address input) {
        return (input == null);
    }
}
