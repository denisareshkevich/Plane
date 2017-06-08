package com.epam.oreshkevich.entity;

import com.epam.oreshkevich.calculation.PlaneCalculation;
import com.epam.oreshkevich.generator.IdGenerator;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * Created by Denis Areshkevich on 24.05.2017.
 */
public class Plane {

    private int id = IdGenerator.generateId();
    private Point first;
    private Point second;
    private Point third;

    public Plane(Point first, Point second, Point third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public Plane(double x1, double y1, double z1, double x2, double y2, double z2,
                 double x3, double y3, double z3) {
        first = new Point(x1, y1, z1);
        second = new Point(x2, y2, z2);
        third = new Point(x3, y3, z3);
    }

    public int getId() {
        return id;
    }

    public Point getFirst() {
        return first;
    }

    public void setFirst(Point first) {
        this.first = first;
    }

    public Point getSecond() {
        return second;
    }

    public void setSecond(Point second) {
        this.second = second;
    }

    public Point getThird() {
        return third;
    }

    public void setThird(Point third) {
        this.third = third;
    }

    public static boolean isPointsArePlane(Point p1,
                                           Point p2,
                                           Point p3, double eps) {
        double matrix[][] = PlaneCalculation.convertPointsToCoordinates(p1, p2, p3);
        double ab = sqrt(pow(matrix[0][0] - matrix[0][1], 2) +
                pow(matrix[2][0] - matrix[2][1], 2) + pow(matrix[1][0] - matrix[1][1], 2));
        double bc = sqrt(pow(matrix[0][1] - matrix[0][2], 2) +
                pow(matrix[2][1] - matrix[2][2], 2) + pow(matrix[1][1] - matrix[1][2], 2));
        double ac = sqrt(pow(matrix[0][0] - matrix[0][2], 2) +
                pow(matrix[2][0] - matrix[2][2], 2) + pow(matrix[1][0] - matrix[1][2], 2));
        double p = (ab + bc + ac) / 2;
        double square = sqrt(p * (p - ab) * (p - ac) * p - bc);
        return abs(square) > eps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plane)) return false;

        Plane plane = (Plane) o;

        if (id != plane.id) return false;
        if (!first.equals(plane.first)) return false;
        if (!second.equals(plane.second)) return false;
        return third.equals(plane.third);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + first.hashCode();
        result = 31 * result + second.hashCode();
        result = 31 * result + third.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "id=" + id +
                ", first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }
}
