package learn.up;

import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;

public class HamcrestTest {
    @ParameterizedTest()
    @CsvSource(value = {"BLUE, WHITE", "GREY, YELLOW", "YELLOW, BLUE"})
    void paintTriangleTest(Colour colourBefore, Colour colourAfter) {
        Triangle triangle = new Triangle(3, 3, 3, colourBefore);
        triangle.paint(colourAfter);
        assertThat(triangle.getColour(), Matchers.equalTo(colourAfter));
    }
}
