package ex;

import org.junit.Test;

import static org.junit.Assert.*;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenCalcWithException() {
        new Fact().calc(-1);
    }
}