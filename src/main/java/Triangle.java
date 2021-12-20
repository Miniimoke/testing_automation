public class Triangle {

    public static double TriangleArea (double a, double b, double c) throws Exception {
        if (a<0 || b<0 || c<0 ) throw new Exception();
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}

