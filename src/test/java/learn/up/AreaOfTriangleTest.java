package learn.up;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Disabled("Перенесен в параметризированные тесты")
public class AreaOfTriangleTest {

    @Test
    @DisplayName("Площадь разностороннего треугольника с использованием высоты")
    public void countAreaTriangleWithHeightSuccessfulTest() {
        Triangle triangle = new Triangle(9, 4, 6);
        double area = triangle.countAreaWithHeight(5);
        assertEquals(22.5, area);
    }

    @Test
    @DisplayName("Площадь равностороннего треугольника с использованием высоты")
    public void countAreaEqualTriangleWithHeightSuccessfulTest() {
        Triangle triangle = new Triangle(7, 7, 7);
        double area = triangle.countAreaWithHeight(11);
        assertEquals(38.5, area);
    }

    @Test
    @DisplayName("Площадь прямоугольного треугольника с использованием высоты")
    public void countAreaRightTriangleWithHeightSuccessfulTest() {
        Triangle triangle = new Triangle(3, 4, 5);
        double area = triangle.countAreaWithHeight(4);
        assertEquals(6, area);
    }

    @Test
    @DisplayName("Площадь треугольника с использованием высоты и отрицательной стороной")
    public void countAreaTriangleWithHeightNegativeASideTest() {
        Triangle triangle = new Triangle(-9, 4, 6);
//        double area = triangle.countAreaWithHeight(5);
//        assertEquals("Triangle is invalid: sides must be positive", area);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> triangle.countAreaWithHeight(5));
        assertEquals("Triangle is invalid: sides must be positive", exception.getMessage());
    }

    @Test
    @DisplayName("Площадь треугольника с использованием высоты и отрицательной стороной")
    public void countAreaTriangleWithHeightNegativeBSideTest() {
        Triangle triangle = new Triangle(9, -4, 6);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> triangle.countAreaWithHeight(5));
        assertEquals("Triangle is invalid: sides must be positive", exception.getMessage());
    }

    @Test
    @DisplayName("Площадь треугольника с использованием высоты и отрицательной стороной" )
    public void countAreaTriangleWithHeightNegativeCSideTest() {
        Triangle triangle = new Triangle(9, 4, -6);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> triangle.countAreaWithHeight(5));
        assertEquals("Triangle is invalid: sides must be positive", exception.getMessage());
    }

    @Test
    @DisplayName("Площадь треугольника с использованием высоты и нулевой стороной")
    public void countAreaWithHeightInvalidTriangleWithZeroASideTest() {
        Triangle triangle = new Triangle(0, 3, 3);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> triangle.countAreaWithHeight(3));
        assertEquals("Triangle is invalid: sides must be positive", exception.getMessage());
    }

    @Test
    @DisplayName("Площадь треугольника с использованием высоты и нулевой стороной")
    public void countAreaWithHeightInvalidTriangleWithZeroBSideTest() {
        Triangle triangle = new Triangle(3, 0, 3);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> triangle.countAreaWithHeight(3));
        assertEquals("Triangle is invalid: sides must be positive", exception.getMessage());
    }

    @Test
    @DisplayName("Площадь треугольника с использованием высоты и нулевой стороной")
    public void countAreaWithHeightInvalidTriangleWithZeroCSideTest() {
        Triangle triangle = new Triangle(3, 3, 0);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> triangle.countAreaWithHeight(3));
        assertEquals("Triangle is invalid: sides must be positive", exception.getMessage());
    }

    @Test
    @DisplayName("Площадь треугольника с использованием высоты и со стороной большей, чем сумма двух других сторон")
    public void countAreaWithHeightInvalidTriangleWithSideEqualSumOfOthersTest() {
        Triangle triangle = new Triangle(3, 3, 6);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> triangle.countAreaWithHeight(9));
        assertEquals("Triangle is invalid: one side greater than sum of another sides", exception.getMessage());
    }

    @Test
    @DisplayName("Площадь треугольника с использованием высоты и со стороной большей, чем сумма двух других сторон")
    public void countAreaWithHeightInvalidTriangleWithSideMoreSumOfOthersTest() {
        Triangle triangle = new Triangle(9, 1, 7);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> triangle.countAreaWithHeight(3));
        assertEquals("Triangle is invalid: one side greater than sum of another sides", exception.getMessage());
    }

    @Test
    @DisplayName("Площадь треугольника с отрицательной высотой")
    public void countAreaTriangleWithNegativeHeightTest() {
        Triangle triangle = new Triangle(9, 9, 9);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> triangle.countAreaWithHeight(-5));
        assertEquals("Height must not be less or equal than zero", exception.getMessage());
    }

    @Test
    @DisplayName("Площадь треугольника с нулевой высотой")
    public void countAreaTriangleWithZeroHeightTest() {
        Triangle triangle = new Triangle(9, 9, 9);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> triangle.countAreaWithHeight(0));
        assertEquals("Height must not be less or equal than zero", exception.getMessage());
    }
}

