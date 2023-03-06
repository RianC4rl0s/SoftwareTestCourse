package example10.test;

import example10.main.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.mockito.Mockito.*;


public class UserServiceTestRianRigoberto {

    PasswordEncoder encoder = mock(PasswordEncoder.class);

    @Test
    public void thenReturn() {
        when(encoder.encode("AZc12!")).thenReturn("a");

        assertEquals("a", encoder.encode("AZc12!"));
    }

    @Test
    public void thenReturnConsecutive() {
        when(encoder.encode("AZc12!")).thenReturn("a", "b");

        assertEquals("a", encoder.encode("AZc12!"));
        assertEquals("b", encoder.encode("AZc12!"));
        assertEquals("b", encoder.encode("AZc12!"));
    }

    @Test
    public void testSingleCall() {
        encoder.encode("AZc12!");

        ArgumentCaptor<String> passowordCaptor = ArgumentCaptor.forClass(String.class);
        verify(encoder).encode(passowordCaptor.capture());

        assertEquals("AZc12!", passowordCaptor.getValue());
    }


}
