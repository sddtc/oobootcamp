package sddtc.oobootcamp.principle.srp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringHandlerTest {

    @Test
    public void should_print_20190326_when_convert_date_given_date_with_minus() {
        String date = "2019-03-26";
        StringHandler stringHandler = new StringHandler(date);
        stringHandler.convert();

        assertThat("20190326").isEqualTo(stringHandler.convert());
    }
}
