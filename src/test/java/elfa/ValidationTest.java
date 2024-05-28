package elfa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {
    //    A method that ensures a password is at least 8 characters long.
    @Test
    void isMinLength_returnTrue_whenLength8() {
        assertTrue(Validation.isMinLength("12345678"));
    }

    @Test
    void isMinLength_returnFalse_whenLength7() {
        assertFalse(Validation.isMinLength("1234567"));
    }

    @Test
    void isMinLength_returnFalse_whenLength0() {
        assertFalse(Validation.isMinLength(""));
    }

    //    With another method, you want to check if the password contains digits.
    @Test
    void containsDigit_returnTrue_whenContainingDigit() {
        assertTrue(Validation.containsDigit("hello1"));
    }

    @Test
    void containsDigit_returnFalse_whenNotContainingDigit() {
        assertFalse(Validation.containsDigit("hello"));
    }

    //    Additionally, you want to ensure with a method that both uppercase and lowercase letters are used in the password.
    @Test
    void containsUpperAndLowercase_returnTrue_whenUpperAndLowercaseIsUsed() {
        assertTrue(Validation.containsUpperAndLowercase("Hello"));
    }

    @Test
    void containsUpperAndLowercase_returnFalse_whenNotUppercaseIsUsed() {
        assertFalse(Validation.containsUpperAndLowercase("hello"));
    }

    @Test
    void containsUpperAndLowercase_returnFalse_whenNotLowercaseIsUsed() {
        assertFalse(Validation.containsUpperAndLowercase("HELLO"));
    }

    @Test
    void containsUpperAndLowercase_returnFalse_whenEmpty() {
        assertFalse(Validation.containsUpperAndLowercase(""));
    }

    //    And a method should detect commonly used passwords.
    @Test
    void isCommonPassword_returnFalse_whenIsNotCommon() {
        assertFalse(Validation.isCommonPassword("H1/bc23?."));
    }

    @Test
    void isCommonPassword_returnTrue_whenIsCommon() {
        assertTrue(Validation.isCommonPassword("password"));
    }

    @Test
    void containsSpecialCharacter_returnTrue_whenContainsSpecialCharacter() {
        assertTrue(Validation.containsSpecialCharacter("password!"));
    }

    @Test
    void containsSpecialCharacter_returnFalse_whenContainsNotSpecialCharacter() {
        assertFalse(Validation.containsSpecialCharacter("password"));
    }

}