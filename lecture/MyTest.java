import org.junit.*;

import static org.junit.Assert.*;

public class MyTest {
    @Test
    public void test() {
        int a = 5;
        Integer b = 5;
        assertEquals((Integer) a, b);
    }
}
