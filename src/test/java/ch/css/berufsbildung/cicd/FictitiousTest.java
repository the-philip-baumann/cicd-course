package ch.css.berufsbildung.cicd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FictitiousTest {

    @Test
    void test() {
        final int expected = 1;

        final int actual = 1;

        assertThat(actual).isEqualTo(expected);
    }

}
