package ru.job4j.oop;

import static java.lang.Math.*;

public class Point {
    private int x;
    private int y;
    private int z;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double distance(Point that) {
        return sqrt(pow(this.x - that.x, 2) + pow(this.y - that.y, 2));
    }

        public double distance3D(Point that) {
        return sqrt(pow(this.x - that.x, 2) + pow(this.y - that.y, 2) + pow(this.z - that.z, 2));
    }

    public static void main(String[] args) {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(3, 2, 0);
        Point d = new Point(7, 0, 6);
        double dist = a.distance(b);
        double dist3D = c.distance3D(d);
        System.out.println(dist);
        System.out.printf("%.3f", dist3D);
    }
}
