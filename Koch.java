/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        /*
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).

		//curve(Integer.parseInt(args[0]),
			  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		

		
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
	*/
		snowFlake(Integer.parseInt(args[0]));
		
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		if (n==0)
		{
			StdDraw.line(x1, y1, x2, y2);
			return;
		}

		double xA = x1 + (x2 - x1) / 3.0;
		double yA = y1 + (y2 - y1) / 3.0;

		double xB = x1 + 2.0 * (x2 - x1) / 3.0;
		double yB = y1 + 2.0 * (y2 - y1) / 3.0;

		double x3 = (Math.sqrt(3) / 6.0) * (y1 - y2) + 0.5 * (x1 + x2);
		double y3 = (Math.sqrt(3) / 6.0) * (x2 - x1) + 0.5 * (y1 + y2);

		curve(n-1, x1, y1, xA, yA);
		curve(n-1,xA, yA, x3, y3);
		curve(n-1, x3, y3, xB, yB);
		curve(n-1, xB, yB, x2, y2);
	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);

		double m = 0.3;
		double y1 = m;
		double x2 = 1-m;
		double y2 = m;

		double s = x2-m;
		double x3 = (m+x2)/2;
		double y3 = y1 + (Math.sqrt(3) / 2.0) * s;

		curve(n, m,  y1, x3, y3);
		curve(n, x3, y3, x2, y2);
		curve(n, x2, y2, m,  y1);
	}
}
