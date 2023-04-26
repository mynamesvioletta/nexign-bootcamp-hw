package learn.up;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Disabled("Move to parameterized tests")
public class TriangleTest
{
    @Test
    @DisplayName("Периметр египетского треугольника")
    public void countPerimeterEgyptTriangleSuccessfulTest()
    {
        Triangle triangle = new Triangle(3, 4, 5); //Arrange
        int perimeter = triangle.countPerimeter();//Act
        assertEquals(12, perimeter); //Assert
    }

    @Test
    @DisplayName("Периметр тупоугольного треугольника")
    @Disabled("Перенесены в параметризированный тест")
    public void countPerimeterTriangleWithAngleGreaterThan90SuccessfulTest()
    {
        Triangle triangle = new Triangle(3, 4, 6); //Arrange
        int perimeter = triangle.countPerimeter();//Act
        assertEquals(13, perimeter);
    }

    @Test
    @DisplayName("Периметр правильного треугольника")
    @Disabled("Перенесены в параметризированный тест")
    public void countPerimeterRightTriangleSuccessfulTest()
    {
        Triangle triangle = new Triangle(3, 3, 3); //Arrange
        int perimeter = triangle.countPerimeter();//Act
        assertEquals(9, perimeter);
    }

    @Test
    @DisplayName("Периметр невалидного треугольника со стороной большей, чем сумма двух других сторон")
    @Disabled("Перенесены в параметризированный тест")
    public void countPerimeterInvalidTriangleWithSideEqualSumOfOthersTest()
    {
        Triangle triangle = new Triangle(3, 3, 6); //Arrange
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, triangle::countPerimeter);
        assertEquals("Triangle is invalid: one side greater than sum of another sides", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Периметр невалидного треугольника со стороной большей, чем сумма двух других сторон")
    public void countPerimeterInvalidTriangleWithSideGreaterSumOfOthersTest()
    {
        Triangle triangle = new Triangle(3, 3, 9); //Arrange
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, triangle::countPerimeter);
        assertEquals("Triangle is invalid: one side greater than sum of another sides", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Периметр невалидного треугольника: отрицательная сторона")
    public void countPerimeterInvalidTriangleWithNegativeASideTest()
    {
        Triangle triangle = new Triangle(-3, 3, 3); //Arrange
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, triangle::countPerimeter);
        assertEquals("Triangle is invalid: sides must be positive", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Периметр невалидного треугольника: отрицательная сторона")
    public void countPerimeterInvalidTriangleWithNegativeBSideTest()
    {
        Triangle triangle = new Triangle(3, -3, 3); //Arrange
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, triangle::countPerimeter);
        assertEquals("Triangle is invalid: sides must be positive", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Периметр невалидного треугольника: отрицательная сторона")
    public void countPerimeterInvalidTriangleWithNegativeCSideTest()
    {
        Triangle triangle = new Triangle(3, 3, -3); //Arrange
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, triangle::countPerimeter);
        assertEquals("Triangle is invalid: sides must be positive", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Периметр невалидного треугольника: отрицательная сторона")
    public void countPerimeterInvalidTriangleWithZeroASideTest()
    {
        Triangle triangle = new Triangle(0, 3, 3); //Arrange
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, triangle::countPerimeter);
        assertEquals("Triangle is invalid: sides must be positive", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Периметр невалидного треугольника: отрицательная сторона")
    public void countPerimeterInvalidTriangleWithZeroBSideTest()
    {
        Triangle triangle = new Triangle(3, 0, 3); //Arrange
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, triangle::countPerimeter);
        assertEquals("Triangle is invalid: sides must be positive", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Периметр невалидного треугольника: отрицательная сторона")
    public void countPerimeterInvalidTriangleWithZeroCSideTest()
    {
        Triangle triangle = new Triangle(3, 3, 0); //Arrange
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, triangle::countPerimeter);
        assertEquals("Triangle is invalid: sides must be positive", illegalArgumentException.getMessage());
    }
}
