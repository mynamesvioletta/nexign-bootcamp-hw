package learn.up;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParametrizedAreaOfTriangleTest {

    public static Stream<Arguments> areas() {
        return Stream.of(Arguments.of(new Triangle(9, 4, 6), 5, 22.5),
                Arguments.of(new Triangle(7, 7, 7), 11, 38.5),
                Arguments.of(new Triangle(3, 4, 5), 4, 6));
    }

    @ParameterizedTest(name = "Площадь треугольника {0} должна быть равна {1}")
    @MethodSource("areas")
    void countAreaTriangleSuccessfulTest(Triangle triangle, int height, double expectedArea) {
        double area = triangle.countAreaWithHeight(height);
        assertEquals(expectedArea, area);
    }

    public static Stream<Arguments> areasInvalidTriangles() {
        return Stream.of(Arguments.of(new Triangle(-9, 4, 6), 5, "Triangle is invalid: sides must be positive"),
                Arguments.of(new Triangle(9, -4, 6), 5, "Triangle is invalid: sides must be positive"),
                Arguments.of(new Triangle(9, 4, -6), 5, "Triangle is invalid: sides must be positive"),
                Arguments.of(new Triangle(0, 3, 3), 3, "Triangle is invalid: sides must be positive"),
                Arguments.of(new Triangle(3, 0, 3), 3, "Triangle is invalid: sides must be positive"),
                Arguments.of(new Triangle(3, 3, 6), 9, "Triangle is invalid: one side greater than sum of another sides"),
                Arguments.of(new Triangle(9, 1, 3), 3, "Triangle is invalid: one side greater than sum of another sides"),
                Arguments.of(new Triangle(9, 9, 9), -5, "Height must not be less or equal than zero"),
                Arguments.of(new Triangle(9, 9, 9), 0, "Height must not be less or equal than zero"));
    }

    @ParameterizedTest
    @MethodSource("areasInvalidTriangles")
    void countAreaInvalidTriangleTest(Triangle triangle, int height, String expectedError) {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> triangle.countAreaWithHeight(height));
        assertEquals(expectedError, illegalArgumentException.getMessage());
    }

}


