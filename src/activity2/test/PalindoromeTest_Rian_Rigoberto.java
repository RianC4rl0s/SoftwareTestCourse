package activity2.test;

import activity2.main.Palindrome;

import org.junit.jupiter.api.Test;

import net.jqwik.api.*;

import static
        org.assertj.core.api.Assertions.assertThat;
import static
        org.assertj.core.api.Assertions.assertThatThrownBy;

public class PalindoromeTest_Rian_Rigoberto {


    Palindrome palindrome = new Palindrome();//Criando objeto do tipo palindromo


    @Test
    public void size0() { //fiz esse teste como unitario pois era uma condição especifica
        assertThatThrownBy(() -> {
            palindrome.isPalindrome("");
        }).isInstanceOf(IllegalArgumentException.class);

    }

    @Property
    void isPalindromeEven(@ForAll("validPalindromeEven") String word) {//testa palindromos pares entre 2 e 50 letras de a - z
        assertThat(palindrome.isPalindrome(word)).isTrue();
    }

    @Property
    void isNotPalindromeEven(@ForAll("invalidPalindromeEven") String word) { //testa não palindromos pares
        assertThat(palindrome.isPalindrome(word)).isFalse();
    }

    @Property
    void isPalindromeOdd(@ForAll("validPalindromeOdd") String word) {//testa palindromos pares entre 2 e 50 letras de a - z
        assertThat(palindrome.isPalindrome(word)).isTrue();
    }

    @Property
    void isNotPalindromeOdd(@ForAll("invalidPalindromeOdd") String word) {//testa não palindromos impares
        assertThat(palindrome.isPalindrome(word)).isFalse();
    }

    @Provide
    private Arbitrary<String> invalidPalindromeEven() { //provider de string
        return Arbitraries.oneOf(
                Arbitraries//gera uma string de a -h entre 1 e 25 e outra string de e - h de 1 a 25 garantindo que não possam ocorrer palindromos nunca
                        .strings()
                        .withCharRange('a', 'd')
                        .ofMinLength(1).ofMaxLength(25)
                        .map(it -> it + Arbitraries
                                .strings()
                                .withCharRange('e', 'h')
                                .ofMinLength(1).ofMaxLength(25))
        );
    }

    @Provide
    private Arbitrary<String> invalidPalindromeOdd() {
        return Arbitraries.oneOf(
                Arbitraries //gera uma string de a -h entre 1 e 25 e outra string de e - h de 1 a 25 garantindo que não possam ocorrer palindromos nunca
                        .strings()
                        .withCharRange('a', 'd')
                        .ofMinLength(1).ofMaxLength(25)
                        .map(it -> it + "a" + Arbitraries
                                .strings()
                                .withCharRange('e', 'h')
                                .ofMinLength(1).ofMaxLength(25))
        );
    }

    @Provide
    private Arbitrary<String> validPalindromeEven() {
        return Arbitraries.oneOf(
                Arbitraries//gera uma string entre 1 e 25 caracteres e concatena com o inverso (achei mais ou menos essa logica  na net) e retorna
                        .strings()
                        .withCharRange('a', 'z')
                        //.ofLength(3)
                        .ofMinLength(1).ofMaxLength(25)
                        .map(it -> it + new StringBuilder().append(it).reverse())
        );

    }

    @Provide
    private Arbitrary<String> validPalindromeOdd() {
        return Arbitraries.oneOf(
                Arbitraries//gera uma string entre 1 e 25 caracteres, concatena com um "a" e concatena com o inverso (achei mais ou menos essa logica  na net) e retorna
                        .strings()
                        .withCharRange('a', 'z')
                        .ofMinLength(0).ofMaxLength(25)
                        .map(it -> it + "a" + new StringBuilder().append(it).reverse())
        );

    }

    //Linhas abaixo usei para testar antes
//    @Test
//    public void evenWordEnterPalindrome() {
//
//        assertThat(palindrome.isPalindrome("abba")).isTrue();
//    }
//
//    @Test
//    public void evenWordEnterNotPalindrome() {
//
//        assertThat(palindrome.isPalindrome("abbc")).isFalse();
//    }
//
//    @Test
//    public void oddWordEnterPalindrome() {
//
//        assertThat(palindrome.isPalindrome("abcba")).isTrue();
//    }
//
//    @Test
//    public void oddWordEnterNotPalindrome() {
//
//        assertThat(palindrome.isPalindrome("abcbc")).isFalse();
//    }
//
//    @Test
//    public void size1() {
//        assertThat(palindrome.isPalindrome("a")).isTrue();
//    }
//
//    @Test
//    public void size2() {
//        assertThat(palindrome.isPalindrome("aa")).isTrue();
//    }
//
//    @Test
//    public void size0() {
//        assertThatThrownBy(() -> {
//            palindrome.isPalindrome("");
//        }).isInstanceOf(IllegalArgumentException.class);
//
//    }
}
