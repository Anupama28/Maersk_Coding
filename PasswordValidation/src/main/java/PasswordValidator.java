import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class PasswordValidator {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(PasswordValidator.class));
    public static List<String> isValidPassword(String validatePassword) {
        char ch;
        boolean capitalFlag = false;
        boolean lowerCaseFlag = false;
        boolean numberFlag = false;
        String password = validatePassword;

        List<String> messages = new ArrayList<>();

        if (password == null) {
            password = "";
            messages.add(Messages.NULL_MESSAGE);
        }
        if (password.length()  < 8) {
            messages.add(Messages.LENGTH_MESSAGE);
        }
        for(int index=0; index < password.length(); index++) {
            ch = password.charAt(index);
            if (Character.isDigit(ch)) {
                numberFlag = true;
            } else if (Character.isUpperCase(ch)) {
                capitalFlag = true;
            } else if (Character.isLowerCase(ch)) {
                lowerCaseFlag = true;
            }
        }
        if (!capitalFlag) messages.add(Messages.UPPER_CASE_MESSAGE);
        if (!lowerCaseFlag) messages.add(Messages.LOWER_CASE_MESSAGE);
        if (!numberFlag)  messages.add(Messages.NUMBER_MESSAGE);

        if (messages.size() <= 2 && !messages.contains(Messages.LOWER_CASE_MESSAGE)) {
            LOGGER.info("Password is OK");
        } else {
            LOGGER.info("Password is never OK");
        }
        return messages;
    }
}
