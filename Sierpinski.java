/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {
	
	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
	}
	
	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski (int n) {
		if (n==0) return;
		double xLeft = 0.1;
		double xRight =  0.9;
		double xTop = 0.5;
		double yBase = 0.1;
		double s = xRight - xLeft;
	double yTop = yBase + (Math.sqrt(3) / 2.0) * s;
		StdDraw.line(xLeft, yBase, xRight, yBase);
		StdDraw.line(xLeft, yBase, xTop, yTop);
		StdDraw.line(xRight, yBase, xTop, yTop);

		sierpinski(n, xLeft, xRight, xTop, yBase, yBase, yTop);
	}
	
	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3,
		                                 double y1, double y2, double y3) {
		if (n==0) return;
		StdDraw.line((x1+x3)/2, (y1+y3)/2, (x2+x3)/2, (y2+y3)/2);
		StdDraw.line((x1+x3)/2, (y1+y3)/2, (x1+x2)/2, (y1+y2)/2);
		StdDraw.line((x1+x2)/2, (y1+y2)/2, (x2+x3)/2, (y2+y3)/2);

		sierpinski(n-1, (x1+x3)/2, (x2+x3)/2, x3, (y1+y3)/2, (y2+y3)/2, y3);
		sierpinski(n-1, (x1+x2)/2, x2, (x2+x3)/2, (y1+y2)/2, y2, (y2+y3)/2);
		sierpinski(n-1, x1, (x1+x2)/2, (x1+x3)/2, y1, (y1+y2)/2, (y1+y3)/2 );
	}
}
