package example1.test;

import example1.main.Substrings;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SubstringsTestExploration {
    @Test
    void simpleCase(){
        assertThat(Substrings.substringsBetween("abcd","a","d")).isEqualTo(new String[]{"bc"});
    }
    @Test
    void manySubstrings(){
        assertThat(Substrings.substringsBetween("abcdabcdab","a","d")).isEqualTo(new String[]{"bc","bc"});

    }
    @Test
    void openAndCloseTagsThatAreLongerThan1Char(){

        assertThat(Substrings.substringsBetween("aabcddaabfddaab","aa","dd")).isEqualTo(new String[]{"bc","bf"});
    }

    @Test
    void stringIsNullOrEmpty(){

        //T1 str is null
        assertThat(Substrings.substringsBetween(null,"a","b")).isEqualTo(null);

        //T2 str is empty
        assertThat(Substrings.substringsBetween("","a","b")).isEqualTo(new String[]{});
    }

    @Test
    void openIsNullOrEmpty(){
        //T3 open is null
        assertThat(Substrings.substringsBetween("abcd",null,"d")).isEqualTo(null);
        //T4 open is empty
        assertThat(Substrings.substringsBetween("abcd","","d")).isEqualTo(null);

    }
    @Test
    void closeIsNullOrEmpty(){
        //T5 open is null
        assertThat(Substrings.substringsBetween("abcd","a",null)).isEqualTo(null);
        //T6 open is empty
        assertThat(Substrings.substringsBetween("abcd","a","")).isEqualTo(null);

    }
    @Test
    void stringOfLenght1(){
        //T7 string equals open
        assertThat(Substrings.substringsBetween("a","a","b")).isEqualTo(null);
        //T8 string equals close
        assertThat(Substrings.substringsBetween("b","a","b")).isEqualTo(null);
        //T9 string is not open or close
        assertThat(Substrings.substringsBetween("c","a","b")).isEqualTo(null);
        //t10 string equals open and close
        assertThat(Substrings.substringsBetween("a","a","a")).isEqualTo(null);

    }
    @Test
    void openAndCloseLenght1(){

        //T11 has no open and close
            assertThat(Substrings.substringsBetween("abcd","e","f")).isEqualTo(null);
        //T12 has open and no close
            assertThat(Substrings.substringsBetween("abcd","a","f")).isEqualTo(null);
        //T13 has close and no open
            assertThat(Substrings.substringsBetween("abcd","e","d")).isEqualTo(null);
        //T14 has a both tags one time
            assertThat(Substrings.substringsBetween("abcd","a","d")).isEqualTo(new String[]{"bc"});
        //T15 has a both tags multiple times
            assertThat(Substrings.substringsBetween("abcdacd","a","d")).isEqualTo(new String[]{"bc","c"});
    }
     @Test
    void openAndCloseLenghtMoreThan1(){

        //T16 has no open and close
            assertThat(Substrings.substringsBetween("abcd","ee","fd")).isEqualTo(null);
        //T17 has open and no close
            assertThat(Substrings.substringsBetween("aabcd","aa","ff")).isEqualTo(null);
        //T18 has close and no open
            assertThat(Substrings.substringsBetween("abcdd","ee","dd")).isEqualTo(null);
        //T19 has a both tags one time
            assertThat(Substrings.substringsBetween("aabcdd","aa","dd")).isEqualTo(new String[]{"bc"});
        //T20 has a both tags multiple times
            assertThat(Substrings.substringsBetween("aabcddaacdd","aa","dd")).isEqualTo(new String[]{"bc","c"});
        //T21 has a both tags multiple times
        assertThat(Substrings.substringsBetween("aaddaadd","aa","dd")).isEqualTo(new String[]{"",""});
    }

}
