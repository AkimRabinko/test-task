package test.utils;

import java.util.List;
import java.util.Random;

public class AccountNumberGeneratorUtils {
    private static final Random RANDOM = new Random();
    private static final int ACCOUNT_NUMBER_LENGTH = 12;
    private static final int UPPER_BOUND = 10;

    private AccountNumberGeneratorUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static String generateAccountNumber(List<String> presentAccounts) {
        var builder = new StringBuilder();
        for (int i = 0; i < ACCOUNT_NUMBER_LENGTH; i++) {
            builder.append(RANDOM.nextInt(UPPER_BOUND));
        }

        String generatedString = builder.toString();
        if (presentAccounts.contains(generatedString)) {
            return generateAccountNumber(presentAccounts);
        }
        return generatedString;
    }
}
