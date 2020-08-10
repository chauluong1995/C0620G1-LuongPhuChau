package automated_testing_tdd.bai_tap.triangle_classifier;

public class TriangleClassifier {
    public static String Classifier(double edge1, double edge2, double edge3) {
        if (testTriangle(edge1, edge2, edge3)) {
            if (edge1 == edge2 && edge1 == edge3) {
                return "Equilateral Triangle";
            } else if (edge1 == edge2 || edge1 == edge3 || edge2 == edge3) {
                return "Isosceles Triangle";
            } else return "Normal Triangle";
        } else return "Not a Triangle !";

//        if (edge1 <= 0 || edge2 <= 0 || edge3 <= 0) {
//            return "Not a Triangle !";
//        } else {
//            if (edge1 + edge2 > edge3 && edge1 + edge3 > edge2 && edge2 + edge3 > edge1) {
//                if (edge1 == edge2 && edge1 == edge3) {
//                    return "Equilateral Triangle";
//                } else if (edge1 == edge2 || edge1 == edge3 || edge2 == edge3) {
//                    return "Isosceles Triangle";
//                } else return "Normal Triangle";
//            } else return "Not a Triangle !";
//        }
    }

    public static boolean testTriangle(double edge1, double edge2, double edge3) {
        return !(edge1 <= 0) && !(edge2 <= 0) && !(edge3 <= 0) && !(edge1 + edge2 <= edge3) && !(edge1 + edge3 <= edge2) && !(edge2 + edge3 <= edge1);
    }
}
