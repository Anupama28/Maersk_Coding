import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PasswordValidatorTest {

    @Test
    public void passwordNotNullTest() {
        List<String> messages = PasswordValidator.isValidPassword("hhdds");
        assertTrue(!messages.contains(Messages.NULL_MESSAGE));
    }

    @Test
    public void passwordLengthTest() {
        List<String> messages = PasswordValidator.isValidPassword("hhddscfdfgd");
        assertTrue(!messages.contains(Messages.LENGTH_MESSAGE));
    }

    @Test
    public void passwordUpperCaseTest() {
        List<String> messages = PasswordValidator.isValidPassword("Addscfdfgd");
        assertTrue(!messages.contains(Messages.UPPER_CASE_MESSAGE));
    }

    @Test
    public void passwordLowerCaseTest() {
        List<String> messages = PasswordValidator.isValidPassword("A23AAAAAa");
        assertTrue(!messages.contains(Messages.LOWER_CASE_MESSAGE));
    }

    @Test
    public void passwordNumberTest() {
        List<String> messages = PasswordValidator.isValidPassword("Afd3AAAAAa");
        assertTrue(!messages.contains(Messages.NUMBER_MESSAGE));
    }
}
