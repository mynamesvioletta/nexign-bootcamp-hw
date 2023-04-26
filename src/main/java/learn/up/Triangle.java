package learn.up;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Triangle
{
    private int a;
    private int b;
    private int c;

    private Colour colour;

    private void checkSidesArePositive(){
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Triangle is invalid: sides must be positive");
        }
    }

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        colour = Colour.WHITE;
    }

    private void checkValidTriangle(){
        if (a >= b + c || b >= a + c || c >= a + b) {
            throw new IllegalArgumentException("Triangle is invalid: one side greater than sum of another sides");
        }
    }

    public int countPerimeter() {
        checkSidesArePositive();
        checkValidTriangle();
        return a + b + c;
    }

    public void paint(Colour colour) {
        if (this.colour == colour) {
            throw new IllegalArgumentException("New colour must not be equal to old colour");
        }
        this.colour = colour;
    }

    public void paint(String colour) {
        paint(Colour.valueOf(colour));
    }

    public Triangle createSimilarTriangle(int coef) {
        return new Triangle(a * coef, b * coef, c * coef);
    }

    //Method to calculate triangle area with height
    private void checkValidHeight(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must not be less or equal than zero");
        }
    }
    public double countAreaWithHeight(int height) {
        checkSidesArePositive();
        checkValidTriangle();
        checkValidHeight(height);
        return 0.5 * a * height;

    }
}


