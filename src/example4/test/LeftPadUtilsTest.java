package example4.test;

import example4.main.LeftPadUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.of;


public class LeftPadUtilsTest {
    @ParameterizedTest
    @MethodSource("generator")
    void test(String originalStr, int size, String padString, String expectedString) {
        assertThat(LeftPadUtils.leftPad(originalStr, size, padString)).isEqualTo(expectedString);
    }

    static Stream<Arguments> generator() {
        return Stream.of(of(null, 10, "-", null), // T1
                of("", 5, "-", "-----"), // T2
                of("abc", -1, "-", "abc"), // T3
                of("abc", 5, null, "  abc"), // T4
                of("abc", 5, "", "  abc"), // T5
                of("abc", 5, "-", "--abc"), // T6
                of("abc", 3, "-", "abc"), // T7
                of("abc", 0, "-", "abc"), // T8
                of("abc", 2, "-", "abc"), // T9
                of("abc", 5, "--", "--abc"), // T10
                of("abc", 5, "---", "--abc"), // T11
                of("abc", 5, "-", "--abc") // T12

        );
    }

}
