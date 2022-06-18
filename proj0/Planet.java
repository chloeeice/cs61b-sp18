public class Planet {
	private static double G = 6.67e-11;  /** 这个G的表达式包括修饰词是借鉴别人的*/
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	public Planet(double xP, double yP, double xV,
		           double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p) {
		this(p.xxPos, p.yyPos, p.xxVel, p.yyVel, p.mass, p.imgFileName);
	}

	public double calcDistance(Planet p) {
		/** if条件句参考的别人的*/
		if (p == null) {
			return 0;
		}
		double dx = this.xxPos - p.xxPos;
		double dy = this.yyPos - p.yyPos;
		return Math.sqrt((dx*dx + dy*dy));
	}

	public double calcForceExertedBy(Planet p) {
		return (G*this.mass*p.mass/Math.pow(this.calcDistance(p),2));

	}

	public double calcForceExertedByX(Planet p) {
		return this.calcForceExertedBy(p)*(p.xxPos-this.xxPos)/this.calcDistance(p);
	}

	public double calcForceExertedByY(Planet p) {
		return this.calcForceExertedBy(p)*(p.yyPos-this.yyPos)/this.calcDistance(p);
	}

	public double calcNetForceExertedByX(Planet[] allPlanets) {
		double res = 0;
		for (Planet p: allPlanets) {
			if (this.equals(p)) {
				continue;
			} else {
				res += this.calcForceExertedByX(p);
			}
		}
		return res;
	}

	public double calcNetForceExertedByY(Planet[] allPlanets) {
		double res = 0;
		for (Planet p: allPlanets) {
			if (this.equals(p)) {
				continue;
			} else {
				res += this.calcForceExertedByY(p);
			}
		}
		return res;
	}

	public void update(double dt, double fX, double fY) {
		double aByX = fX/this.mass;
		double aByY = fY/this.mass;
		this.xxVel += dt*aByX;
		this.yyVel += dt*aByY;
		this.xxPos += dt*this.xxVel;
		this.yyPos += dt*this.yyVel;
	}

	public void draw() {
		String imgToDraw = "./images/" + this.imgFileName;
		StdDraw.picture(this.xxPos, this.yyPos, imgToDraw);
	}
}
