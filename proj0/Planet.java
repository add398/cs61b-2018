public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    private static final double G = 6.67e-11;

    public Planet(double xxPos, double yyPos, double xxVel, double yyVel, double mass, String imgFileName) {
        this.xxPos = xxPos;
        this.yyPos = yyPos;
        this.xxVel = xxVel;
        this.yyVel = yyVel;
        this.mass = mass;
        this.imgFileName = imgFileName;
    }

    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p){
        double xdif = this.xxPos - p.xxPos;
        double ydif = this.yyPos - p.yyPos;
        return Math.sqrt(xdif * xdif + ydif * ydif);
    }

    public double calcForceExertedBy(Planet p){
        double r = this.calcDistance(p);
        return (G * this.mass * p.mass) / (r * r);
    }

    public double calcForceExertedByX(Planet p){
        double F = this.calcForceExertedBy(p);
        double dx = p.xxPos - this.xxPos;
        double r = this.calcDistance(p);

        return (F * dx) / r;
    }

    public double calcForceExertedByY(Planet p){
        double dy = p.yyPos - this.yyPos;
        double F = this.calcForceExertedBy(p);
        double r = this.calcDistance(p);
        return (F * dy) / r;
    }

    public double calcNetForceExertedByX(Planet[] planets){
        // 计算 一组行星的合力 x
        double totalForce = 0;
        for (Planet planet : planets){
            // 不能对自身施加引力
            if (this.equals(planet)) {
                continue;
            }
            totalForce += calcForceExertedByX(planet);
        }
        return totalForce;
    }

    public double calcNetForceExertedByY(Planet[] planets){
        // 计算 一组行星的合力 y
        double totalForce = 0;
        for (Planet planet : planets){
            if (this.equals(planet)) {
                continue;
            }
            totalForce += calcForceExertedByY(planet);
        }
        return totalForce;
    }


    public void update(double dt, double forceX, double forceY){
        double ax = forceX / mass;
        double ay = forceY / mass;

        xxVel += dt * ax;
        yyVel += dt * ay;

        xxPos += xxVel * dt;
        yyPos += yyVel * dt;

    }

    public void draw(){
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }

}
