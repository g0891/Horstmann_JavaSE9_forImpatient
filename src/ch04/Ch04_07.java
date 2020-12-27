package ch04;

public class Ch04_07 {
    public static void main(String[] args) {
        Color col1 = Color.CYAN;
        System.out.println(col1.name() + " color has red value: " + col1.getRed());
        System.out.println(col1.name() + " color has green value: " + col1.getGreen());
        System.out.println(col1.name() + " color has blue value: " + col1.getBlue());
    }

    enum Color {
        BLACK(0,0,0),
        RED(255,0,0),
        BLUE(0,0,255),
        GREEN(0,255,0),
        CYAN(0, 255, 255),
        MAGENTA(255, 0, 255),
        YELLOW(255,255,0),
        WHITE (255,255,255);

        int r ,g, b;
        Color(int r, int g, int b) {
            this.r = r;
            this.g = g;
            this.b = b;
        }

        public int getRed() {
            return r;
        }

        public int getGreen() {
            return g;
        }

        public int getBlue() {
            return b;
        }

    }
}
