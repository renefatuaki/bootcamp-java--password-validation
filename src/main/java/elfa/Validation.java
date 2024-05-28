package elfa;

import org.passay.CharacterData;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;

import java.util.Arrays;
import java.util.List;

public class Validation {
    public static int minPasswordLength = 8;
    public static String[] commonPasswords = {"123456", "123456789", "qwerty", "password", "12345", "qwerty123", "1q2w3e", "12345678", "111111"};

    public static List<CharacterRule> validationRules = Arrays.asList(
            new CharacterRule(EnglishCharacterData.UpperCase, 1),
            new CharacterRule(EnglishCharacterData.LowerCase, 1),
            new CharacterRule(EnglishCharacterData.Special, 1),
            new CharacterRule(EnglishCharacterData.Digit, 1),
            // include whitespaces
            new CharacterRule(new CharacterData() {
                @Override
                public String getErrorCode() {
                    return "ERR_SPACE";
                }

                @Override
                public String getCharacters() {
                    return " ";
                }
            }, 1)
    );

    public static boolean isMinLength(String password) {
        return password.length() >= minPasswordLength;
    }

    public static boolean containsDigit(String password) {
        return password.matches(".*[0-9].*");
    }

    public static boolean containsUpperAndLowercase(String password) {
        return !password.toUpperCase().equals(password) && !password.toLowerCase().equals(password);
    }

    public static boolean isCommonPassword(String password) {
        for (String commonPassword : commonPasswords) {
            if (commonPassword.equals(password)) return true;
        }

        return false;
    }

    public static boolean containsSpecialCharacter(String password) {
        for (char passwordCharacter : password.toCharArray()) {
            if (!Character.isLetterOrDigit(passwordCharacter)) return true;
        }

        return false;
    }
}
