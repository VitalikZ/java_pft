package ru.stqa.pft.sandbox;

public class Point {

    public double a;
    public double b;


    public Point(double a, double b) {
        this.a = a;
        this.b = b;
    }

    double distance(double a, double b) {

        double dx = this.a - a;

        double dy = this.b - b;

        return Math.sqrt(dx*dx + dy*dy);

    }

    double distance(Point p) {

        return distance(p.a, p.b);

    }
}
