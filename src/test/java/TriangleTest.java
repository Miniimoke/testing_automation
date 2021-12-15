import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {

    @Test
    void positiveTest () throws Exception {
        Assertions.assertEquals(Triangle.TriangleArea(3, 4, 5), 6);
    }

    @Test
    void negativeTest() {
        Assertions.assertThrows(Exception.class, () -> Triangle.TriangleArea(3,4,-5));
    }
}
