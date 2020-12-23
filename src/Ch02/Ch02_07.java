package Ch02;

public class Ch02_07 {

    /**
     * Point class from Ch02.Ch02_05
     * for immutable items
     * @author John
     * @version 1.0
     */
    public static class Point_Ch02_05 {
        private double x;
        private double y;

        /**
         * Creates new point at (0;0) coordinates
         */
        public Point_Ch02_05() {};

        /**
         * Creates new point at specified coordinates
         * @param x x-axis coordinate
         * @param y y-axis coordinate
         */
        public Point_Ch02_05(double x, double y) {
            this.x = x;
            this.y = y;
        }

        /**
         * Get x-axis coordinate
         * @return x-axis coordinate
         */
        public double getX() {
            return x;
        }

        /**
         * Get y-axis coordinate
         * @return y-axis coordinate
         */
        public double getY() {
            return y;
        }

        /**
         * Creates new point away from the current point
         * @param a x-axis shift
         * @param b y-axis shift
         * @return new point
         */
        public Point_Ch02_05 translate(double a, double b) {
            return new Point_Ch02_05(x + a, y + b);
        }

        /**
         * Creates new point with coordinates scaled from the current point
         * @param s scale factor
         * @return new point
         */
        public Point_Ch02_05 scale(double s) {
            return new Point_Ch02_05(x * s, y * s);
        }

        /**
         * Translates point coordinates to String
         * @return string representation of point coordinates
         */
        public String toString() {
            return String.format("(%.2f; %.2f)", x, y);
        }
    }

    /**
     * Point class from Ch02.Ch02_06
     * for mutable items
     * @author John
     * @version 2.0
     */
    public static class Point_Ch02_06 {
        private double x;
        private double y;

        /**
         * Creates new point at (0;0) coordinates
         */
        public Point_Ch02_06() {};

        /**
         * Creates new point at specified coordinates
         * @param x x-axis coordinate
         * @param y y-axis coordinate
         */
        public Point_Ch02_06(double x, double y) {
            this.x = x;
            this.y = y;
        }

        /**
         * Get x-axis coordinate
         * @return x-axis coordinate
         */
        public double getX() {
            return x;
        }

        /**
         * Get y-axis coordinate
         * @return y-axis coordinate
         */
        public double getY() {
            return y;
        }

        /**
         * Moves current point
         * @param a x-axis shift
         * @param b y-axis shift
         * @return the same point with new coordinates
         */
        public Point_Ch02_06 translate(double a, double b) {
            x += a;
            y += b;
            return this;
        }


        /**
         * CScales coordinates for the current point
         * @param s scale factor
         * @return the same point with new scaled coordinates
         */
        public Point_Ch02_06 scale(double s) {
            x *= s;
            y *= s;
            return this;
        }

        /**
         * Translates point coordinates to String
         * @return string representation of point coordinates
         */
        public String toString() {
            return String.format("(%.2f; %.2f)", x, y);
        }
    }
}
