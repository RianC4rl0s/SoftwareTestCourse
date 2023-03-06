package Test2.test;


import net.jqwik.api.*;
import org.apache.commons.text.WordUtils;
import org.junit.jupiter.api.Test;

import static
        org.assertj.core.api.Assertions.assertThat;


public class CapitalizeWithDelimitersTest {

    @Test
    public void nullString(){//caso null retorna null
        assertThat(WordUtils.capitalize(null)).isEqualTo(null);
    }


    @Property//Capitalize without delimiters
    public void testCapitalize(@ForAll("word") String word){//testando o caso base que é alterar a primeira leta de cada palavra
        String[] split = word.split(" "); // colocando manualmente as palavras com capitalize
        split[0] =  split[0].substring(0, 1).toUpperCase() + split[0].substring(1);
        split[1] =  split[1].substring(0, 1).toUpperCase() + split[1].substring(1);
        String cpi = split[0] + " " + split[1];

        assertThat(WordUtils.capitalize(word)).isEqualTo(cpi); // comparando


    }
    @Property//Capitalize without delimiters
    public void testCaptilizeEmpty(@ForAll("empty") String word){
        assertThat(WordUtils.capitalize(word)).isEqualTo(word); // comparando se entra vazio retornar a msm string
    }
    @Provide
    private Arbitrary<String> empty() {
        return Arbitraries.strings().withChars(" ").ofMinLength(0).ofMaxLength(5);//criando string vazia
    }

    @Provide
    private Arbitrary<String> word() {// criando duas palavras e gerando uma string para ser testada
        Arbitrary<String> word1 = Arbitraries.strings().withCharRange('a', 'z').ofMinLength(1).ofMaxLength(10);
        Arbitrary<String> word2 = Arbitraries.strings().withCharRange('a', 'z').ofMinLength(1).ofMaxLength(10);
        return Combinators.combine(word1, word2).as((w1, w2) -> w1 + " " + w2);
    }

}
