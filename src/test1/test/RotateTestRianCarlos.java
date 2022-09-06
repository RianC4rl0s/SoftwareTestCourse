package test1.test;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import test1.main.Rotate;

public class RotateTestRianCarlos {

    /*
    * Partições
    * str = null, str = "",str = <n * characteres>
    * shift < 0, shift = 0, shift > 0,  shift == strlen, shift< strLen, shift > strlen
    *
    * */

    @Test
    public void strBiggerThan0() {
        //Testa quando a string é maior que 0 e shift tem valores maiores que 0 e menores q strLen
        //shift positivo
        assertThat(Rotate.rotate("abc", 2)).isEqualTo("bca");
        //shift negativo
        assertThat(Rotate.rotate("abc", -2)).isEqualTo("cab");
    }

    @Test
    public void strLen0() {
        //Testa quando str é vazio
        assertThat(Rotate.rotate("", 2)).isEqualTo("");
    }

    @Test
    public void shiftIs0() {
        //testa quando shift é 0
        assertThat(Rotate.rotate("abc", 0)).isEqualTo("abc");
    }

    @Test
    public void strVoidShiftPositive() {
        //testa quando str é vazia e shift é positivo
        assertThat(Rotate.rotate("", 2)).isEqualTo("");
    }

    @Test
    public void strVoidShiftNegative() {
        //testa quando shift é negativo
        assertThat(Rotate.rotate("", -2)).isEqualTo("");
    }
    @Test
    public void strNull(){
        //testa str null
        assertThat(Rotate.rotate(null,2)).isEqualTo(null);
    }
    @Test
    public void shiftBiggerThanStr(){
        //testa quando shift é maior que strlen
        assertThat(Rotate.rotate("abc",4)).isEqualTo("cab");
    }
    @Test
    public void shiftResidualstrLenIs0(){
        //testa quando strlen == shift
        assertThat(Rotate.rotate("abc",3)).isEqualTo("abc");
    }
}
