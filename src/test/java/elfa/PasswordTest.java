package elfa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordTest {
    @Test
    void PasswordGenerator_create_returnTrue_whenPassValidationChecks() {
        String generatedPassword = Password.create();
        boolean validationCheck = Validation.containsUpperAndLowercase(generatedPassword) &&
                !Validation.isCommonPassword(generatedPassword) &&
                Validation.containsDigit(generatedPassword) &&
                Validation.containsSpecialCharacter(generatedPassword) &&
                Validation.isMinLength(generatedPassword);

        assertTrue(validationCheck);
    }

    @Test
    void PasswordGenerator_create_returnTrue_whenPassValidationChecksAndPasswordLengthIs21() {
        int passwordLength = 21;
        String generatedPassword = Password.create(passwordLength);
        boolean validationCheck = Validation.containsUpperAndLowercase(generatedPassword) &&
                !Validation.isCommonPassword(generatedPassword) &&
                Validation.containsDigit(generatedPassword) &&
                Validation.containsSpecialCharacter(generatedPassword) &&
                Validation.isMinLength(generatedPassword);

        assertTrue(validationCheck && generatedPassword.length() == passwordLength);
    }
}