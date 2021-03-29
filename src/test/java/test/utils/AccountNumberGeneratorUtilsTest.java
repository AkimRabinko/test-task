package test.utils;


import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class AccountNumberGeneratorUtilsTest {

    @Test
    public void testGenerateAccountNumberCheckLength() {
        assertThat(AccountNumberGeneratorUtils.generateAccountNumber(Collections.emptyList()).length(), is(12));
    }

}
