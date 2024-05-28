package elfa;

import org.passay.PasswordGenerator;

public class Password extends Validation {
    public static String create() {
        PasswordGenerator generator = new PasswordGenerator();
        return generator.generatePassword(minPasswordLength, validationRules);
    }

    public static String create(int passwordLength) {
        if (passwordLength < minPasswordLength) throw new Error("Password need to be at least " + minPasswordLength + " character long.");
        PasswordGenerator generator = new PasswordGenerator();
        return generator.generatePassword(passwordLength, validationRules);
    }
}
