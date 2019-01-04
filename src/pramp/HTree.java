package pramp;

public class HTree {
    public static void main(String[] args) {
        drawHTree(0,0,8,2);
    }
    public static void drawLine(double x1, double y1, double x2, double y2) {
        System.out.println("Line is drawn by the point: " + "(" + x1 + "," + y1 + ") " + "and " + "(" + x2 + "," + y2 + ")");
    }

    public static void drawHTree(double x, double y, double length, int depth) {
        if (depth == 0) return;
        double x0 = x - length / 2;
        double x1 = x + length / 2;
        double y0 = y - length / 2;
        double y1 = y + length / 2;

        // draw the 3 line segments of the H-Tree
        drawLine(x0, y0, x0, y1);    // left segment
        drawLine(x1, y0, x1, y1);   //right segment
        drawLine(x0, y, x1, y);  // connecting segment

        // at each stage, the length of segments decreases by a factor of √2
        double newLength = length / Math.sqrt(2);

        // decrement depth by 1 and draw an H-tree
        //at each of the tips of the current ‘H’
        drawHTree(x0, y0, newLength, depth - 1);     // lower left  H-tree
        drawHTree(x0, y1, newLength, depth - 1);    // upper left  H-tree
        drawHTree(x1, y0, newLength, depth - 1);   // lower right H-tree
        drawHTree(x1, y1, newLength, depth - 1);
    }
}
