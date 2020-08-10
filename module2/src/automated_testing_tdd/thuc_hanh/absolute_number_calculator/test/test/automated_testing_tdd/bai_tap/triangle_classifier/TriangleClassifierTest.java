package automated_testing_tdd.bai_tap.triangle_classifier;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleClassifierTest {

    @Test
    void classifier() {
        double edge1 = 2;
        double edge2 = 2;
        double edge3 = 2;

        String expected = "Equilateral Triangle";
        String result = TriangleClassifier.Classifier(edge1, edge2, edge3);
        assertEquals(expected, result);
    }

    @Test
    void classifier1() {
        double edge1 = 2;
        double edge2 = 2;
        double edge3 = 3;

        String expected = "Isosceles Triangle";
        String result = TriangleClassifier.Classifier(edge1, edge2, edge3);
        assertEquals(expected, result);
    }

    @Test
    void classifier2() {
        double edge1 = 3;
        double edge2 = 4;
        double edge3 = 5;

        String expected = "Normal Triangle";
        String result = TriangleClassifier.Classifier(edge1, edge2, edge3);
        assertEquals(expected, result);
    }

    @Test
    void classifier3() {
        double edge1 = 8;
        double edge2 = 2;
        double edge3 = 3;

        String expected = "Not a Triangle !";
        String result = TriangleClassifier.Classifier(edge1, edge2, edge3);
        assertEquals(expected, result);
    }

    @Test
    void classifier4() {
        double edge1 = -1;
        double edge2 = 2;
        double edge3 = 1;

        String expected = "Not a Triangle !";
        String result = TriangleClassifier.Classifier(edge1, edge2, edge3);
        assertEquals(expected, result);
    }

    @Test
    void classifier5() {
        double edge1 = 0;
        double edge2 = 1;
        double edge3 = 1;

        String expected = "Not a Triangle !";
        String result = TriangleClassifier.Classifier(edge1, edge2, edge3);
        assertEquals(expected, result);
    }
}