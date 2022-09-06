package example2.test;

import example2.main.Date;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class DateTest {

    @Test
    void exampleInvalidArgumentTestCase() {
        assertThatThrownBy(() -> new Date(13,31,2022))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void dateIsValidArgument(){
        Date date = new Date(5, 15, 2027);
        assertThat(date.toString()).isEqualTo("5/15/2027");
    }
    @Test
    void exampleTestCase() {
        Date date = new Date(2, 29, 2028);
        assertThat(date.toString()).isEqualTo("2/29/2028");
    }
    @Test
    void monthLessThen1() {
        assertThatThrownBy(() -> new Date(0,31,2022))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void monthHas30DaysAndEntraceWas31() {
        assertThatThrownBy(() -> new Date(4,31,2022))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void dayMoreThen31() {
        assertThatThrownBy(() -> new Date(1,33,2022))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void dayLessThen1() {
        assertThatThrownBy(() -> new Date(1,0,2022))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void febuaryHasMoreDaysThan29() {
        assertThatThrownBy(() -> new Date(2,33,2022))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void febHas29DaysInBiYear() {
        assertThatThrownBy(() -> new Date(2,30,2020))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void febHas28daysNotBiYear() {
        Date date = new Date(2, 28, 2027);
        assertThat(date.toString()).isEqualTo("2/28/2027");
    }
    @Test
    void yearLessThen1() {
        Date date = new Date(5, 4, -44);
        assertThat(date.toString()).isEqualTo("5/4/-44");
    }
    @Test
    void yearLessThen1AndBi() {
        Date date = new Date(2, 28, -2020);
        assertThat(date.toString()).isEqualTo("2/28/-2020");
    }

}
