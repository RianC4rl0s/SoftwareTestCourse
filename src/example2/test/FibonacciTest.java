package example2.test;

import example2.main.Fibonacci;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FibonacciTest {

    Fibonacci fb = new Fibonacci();

    @Test
    void nIsPositive(){
        assertThat(fb.NFibonacci(3)).isEqualTo((2));
    }

    @Test
    void nIsNegative(){
        assertThat(fb.NFibonacci(-1)).isEqualTo((0));
    }
    @Test
    void nIsZero(){
        assertThat(fb.NFibonacci(0)).isEqualTo((0));
    }

}
