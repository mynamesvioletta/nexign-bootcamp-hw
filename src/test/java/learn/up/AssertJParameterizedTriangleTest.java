package learn.up;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class AssertJParameterizedTriangleTest {



    @BeforeEach
    void setUp() {
        System.out.println("BeforeEach");
    }

    @AfterEach
    void tearDown() {
        System.out.println("AfterEach");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("BeforeAll");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("AfterAll");
    }

    public static Stream<Arguments> triangles() {
        return Stream.of(Arguments.of(new Triangle(3, 4, 5), 12),
                Arguments.of(new Triangle(3, 4, 6), 13),
                Arguments.of(new Triangle(3, 3, 3), 9));
    }

    @ParameterizedTest(name = "Периметр треугольника {0} должен быть равен {1}")
    @MethodSource("triangles")
    @DisplayName("Периметр треугольника: позитивный сценарий")
    public void countPerimeterTriangleSuccessfulTest(Triangle triangle, int expectedPerimeter)
    {
        int perimeter = triangle.countPerimeter();//Act
        assertThat(perimeter)
                .as("Проверяем периметр")
                                .isEqualTo(expectedPerimeter);
    }

    public static Stream<Arguments> invalidTriangles() {
        return Stream.of(Arguments.of(new Triangle(3, 3, 6), "Triangle is invalid: one side greater than sum of another sides"),
                Arguments.of(new Triangle(6, 3, 3), "Triangle is invalid: one side greater than sum of another sides"),
                Arguments.of(new Triangle(3, 6, 3), "Triangle is invalid: one side greater than sum of another sides"),
                Arguments.of(new Triangle(9, 3, 3), "Triangle is invalid: one side greater than sum of another sides"),
                Arguments.of(new Triangle(-3, 3, 3), "Triangle is invalid: sides must be positive"),
                Arguments.of(new Triangle(3, -3, 3), "Triangle is invalid: sides must be positive"),
                Arguments.of(new Triangle(3, 3, -3), "Triangle is invalid: sides must be positive"),
                Arguments.of(new Triangle(0, 3, 3), "Triangle is invalid: sides must be positive"),
                Arguments.of(new Triangle(3, 0, 3), "Triangle is invalid: sides must be positive"),
                Arguments.of(new Triangle(3, 3, 0), "Triangle is invalid: sides must be positive"));

    }

    @ParameterizedTest(name = "Периметр треугольника {0} должен быть равен {1}")
    @MethodSource("invalidTriangles")
    @DisplayName("Периметр треугольника: негативные сценарии")
    public void countPerimeterInvalidTriangleErrorTest(Triangle triangle, String errorText)
    {
        assertThatThrownBy(triangle::countPerimeter)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorText);
    }


    @ParameterizedTest()
    @CsvSource(value = {"BLUE, WHITE", "GREY, YELLOW", "YELLOW, BLUE"})
    void paintTriangleTest(Colour colourBefore, Colour colourAfter) {
        Triangle triangle = new Triangle(3, 3, 3, colourBefore);
        triangle.paint(colourAfter);
        assertThat(triangle.getColour())
                .isEqualTo(colourAfter);
    }

    public static Stream<Arguments> similarTriangleTest() {
        return Stream.of(Arguments.of(new Triangle(3, 3, 3), 2, new Triangle(6, 6, 6, Colour.BLUE)));
    }

    @ParameterizedTest
    @MethodSource
    void similarTriangleTest(Triangle triangle, int coef, Triangle expectedTriangle) {
        Triangle similarTriangle = triangle.createSimilarTriangle(coef);
        assertThat(similarTriangle)
                .usingRecursiveComparison()
                .ignoringFieldsOfTypes(Colour.class)
                .isEqualTo(expectedTriangle);
    }

    @Nested
    public class CreateTriangleBeforeTest {
        Triangle triangle;

        @BeforeEach
        void setUp() {
            triangle = new Triangle(3, 3, 3);

        }

        @ParameterizedTest()
        @ValueSource(strings = {"BLUE", "GREY", "YELLOW"})
        void paintStringTest(String colour) {
            triangle.paint(colour);
            assertThat(triangle.getColour().toString())
                    .isEqualTo(colour);
        }

        @ParameterizedTest()
        @EnumSource(Colour.class)
        void paintTest(Colour colour) {
            Assumptions.assumeFalse(triangle.getColour().equals(colour));
            triangle.paint(colour);
            assertThat(triangle.getColour())
                    .isEqualTo(colour);
        }
    }
}
