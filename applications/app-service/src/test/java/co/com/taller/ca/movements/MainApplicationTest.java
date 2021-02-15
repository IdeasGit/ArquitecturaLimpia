package co.com.taller.ca.movements;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class MainApplicationTest {

    @Test
    public void testMainIfArgsNull() {
        try {
            MainApplication.main(null);
        } catch(IllegalArgumentException e) {
            Assert.assertEquals("Args must not be null", e.getMessage());
        }
    }
}