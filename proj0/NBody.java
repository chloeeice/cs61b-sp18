public class NBody {
	public static double readRadius(String fileName) {
		In in = new In(fileName);
		int firstItemInFile = in.readInt();
		double secondItemInFile = in.readDouble();
		return secondItemInFile;
	}

	public static Planet[] readPlanets(String fileName) {
		In in = new In(fileName);
		int number = in.readInt();
		double radius = in.readDouble();
		Planet[] allPlanets = new Planet[number];
		int i = 0;
		while (i < number) {
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String img = in.readString();
			allPlanets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, img);
			i += 1;
		}
		return allPlanets;
	}

	public static void main (String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double r = readRadius(filename);
		Planet[] allPlanets = readPlanets(filename);

		/*set the scale.*/
		StdDraw.setScale(-r, r);
		/*draw the background image.*/
		StdDraw.picture(0, 0, "./images/starfield.jpg");
		/*draw all the planets.*/
		for (int i = 0; i < allPlanets.length; i++) {
			allPlanets[i].draw();
		}

		StdDraw.enableDoubleBuffering();

		for (double time=0; time<T; time++) {
			double[] xForces = new double[allPlanets.length];
			double[] yForces = new double[allPlanets.length];
			for (int i=0; i<allPlanets.length; i++) {
				xForces[i] = allPlanets[i].calcNetForceExertedByX(allPlanets);
				yForces[i] = allPlanets[i].calcNetForceExertedByY(allPlanets);
			}

			for (int i = 0; i<allPlanets.length; i++) {
				allPlanets[i].update(dt, xForces[i], yForces[i]);
			}

			/*draw the background image.*/
		    StdDraw.picture(0, 0, "./images/starfield.jpg");
		    /*draw all the planets.*/
		    for (int i = 0; i < allPlanets.length; i++) {
			    allPlanets[i].draw();
		    }
		    StdDraw.show();
		    StdDraw.pause(10);
		    time += dt;

		}

		StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                          planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                          planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
        }
	}
}