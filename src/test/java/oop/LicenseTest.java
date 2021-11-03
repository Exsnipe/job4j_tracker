package oop;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

public class LicenseTest {

    @Test
    public void eqNameAndModel() {
        License first = new License();
        first.setCode("audio");
        first.setModel("D256");
        License second = new License();
        second.setCode("audio");
        second.setModel("D256");
        assertThat(first, is(second));
    }
}