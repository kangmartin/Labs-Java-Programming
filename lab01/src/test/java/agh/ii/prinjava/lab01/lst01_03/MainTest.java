package agh.ii.prinjava.lab01.lst01_03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void testAreaRect() {
        Rectangle rectangle = new Rectangle(5, 5); // Supposons que w = 4 et h = 5

        double resultat = rectangle.area();

        assertEquals(25.0, resultat, 0.001);
    }

    @Test
    public void testPerimeterRect() {
        Rectangle rectangle = new Rectangle(4, 5); // Supposons que w = 4 et h = 5

        double resultat = rectangle.perimeter();

        assertEquals(18.0, resultat, 0.001);
    }

}
