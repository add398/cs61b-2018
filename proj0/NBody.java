public class NBody {
    public static double readRadius(String filename){
        In in = new In(filename);
        int num = in.readInt();
        double radius = in.readDouble();
        return  radius;
    }

    public static Planet[] readPlanets(String filename){
        In in = new In(filename);
        int num = in.readInt();
        double radius = in.readDouble();

        Planet[] planets = new Planet[num];
        for (int i = 0; i < num; i++) {
            double a = in.readDouble();
            double b = in.readDouble();
            double c = in.readDouble();
            double d = in.readDouble();
            double e = in.readDouble();
            String str = in.readString();

            planets[i] = new Planet(a, b, c, d, e, str);

        }

        return  planets;
    }


    public static void main(String[] args) {
        double T = new Double(args[0]);
        double dt = new Double(args[1]);
        // 将第 0 和第 1 个命令行参数存储为名为 T 和 dt 的双精度。
        //提示：参数以字符串形式出现。您必须在 Google 上搜索才能了解如何将字符串转换为 double！

        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        // set the universe scale
        StdDraw.setXscale(-radius, radius);
        StdDraw.setYscale(-radius, radius);
        StdDraw.enableDoubleBuffering();

        double t = 0;
        int num = planets.length;
        while(t <= T){
            double[] xForces = new double[num];
            double[] yForces = new double[num];
            for(int i = 0; i < num; i++){
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for(int i = 0; i < num; i++){
                planets[i].update(dt, xForces[i], yForces[i]);
            }

            // draw the backgroud picture
            StdDraw.picture(0, 0, "images/starfield.jpg");

            // draw all the planets
            for (Planet planet : planets) {
                planet.draw();
            }

            StdDraw.show();
            StdDraw.pause(10);
            t += dt;
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
