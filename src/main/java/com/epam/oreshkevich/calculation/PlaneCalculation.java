package com.epam.oreshkevich.calculation;

import com.epam.oreshkevich.entity.Plane;
import com.epam.oreshkevich.entity.Point;

import static java.lang.Math.*;
import static java.lang.Math.acos;

/**
 * Created by Denis Areshkevich on 25.05.2017.
 */
public class PlaneCalculation {

    public boolean crossesAnyAxeAtRightAngle(Plane plane, double eps) {
        double oxy = calculateAngleWithOXY(plane);
        double oxz = calculateAngleWithOXZ(plane);
        double oyz = calculateAngleWithOYZ(plane);
        return abs(oxy - 180) <= eps || abs(oxz - 180) <= eps || abs(oyz - 180) <= eps;
    }

    public double calculateAngleWithOXY(Plane plane) {
        Plane planeOXY = new Plane(0, 0, 0, 1, 0, 0, 0, 1, 0);
        double[] normalOXY = calculateNormal(planeOXY);
        double[] normalSelf = calculateNormal(plane);
        double cos = (normalOXY[0] * normalSelf[0] + normalOXY[1] * normalSelf[1] + normalOXY[2] * normalSelf[2]) /
                (sqrt((pow(normalOXY[0], 2) + pow(normalOXY[1], 2) +
                        pow(normalOXY[2], 2)) * (pow(normalSelf[0], 2) +
                        pow(normalSelf[1], 2) + pow(normalSelf[2], 2))));
        return (acos(cos) - floor(acos(cos))) * 180;
    }

    public double calculateAngleWithOXZ(Plane plane) {
        Plane planeOXZ = new Plane(0, 0, 0, 1, 0, 0, 0, 0, 1);
        double[] normalOXZ = calculateNormal(planeOXZ);
        double[] normalSelf = calculateNormal(plane);
        double cos = (normalOXZ[0] * normalSelf[0] + normalOXZ[1] * normalSelf[1] + normalOXZ[2] * normalSelf[2]) /
                (sqrt((pow(normalOXZ[0], 2) + pow(normalOXZ[1], 2) +
                        pow(normalOXZ[2], 2)) * (pow(normalSelf[0], 2) +
                        pow(normalSelf[1], 2) + pow(normalSelf[2], 2))));
        return (acos(cos) - floor(acos(cos))) * 180;
    }

    public double calculateAngleWithOYZ(Plane plane) {
        Plane planeOYZ = new Plane(0, 0, 0, 0, 1, 0, 0, 0, 1);
        double[] normalOYZ = calculateNormal(planeOYZ);
        double[] normalSelf = calculateNormal(plane);
        double cos = (normalOYZ[0] * normalSelf[0] + normalOYZ[1] * normalSelf[1] + normalOYZ[2] * normalSelf[2]) /
                (sqrt((pow(normalOYZ[0], 2) + pow(normalOYZ[1], 2) +
                        pow(normalOYZ[2], 2)) * (pow(normalSelf[0], 2) +
                        pow(normalSelf[1], 2) + pow(normalSelf[2], 2))));
        return (acos(cos) - floor(acos(cos))) * 180;
    }

    private double[] calculateNormal(Plane plane) {
        Point first = plane.getFirst();
        Point second = plane.getSecond();
        Point third = plane.getThird();
        double m[][] = convertPointsToCoordinates(first, second , third );
        double[] normal = new double[3];
        normal[0] = calculateARatio(m);
        normal[1] = calculateBRatio(m);
        normal[2] = calculateCRatio(m);
        return normal;
    }

    public static double[][] convertPointsToCoordinates(Point first, Point second, Point third) {
        double[][] matrix = new double[3][3];

        matrix[0][0] = first.getX();
        matrix[0][1] = second.getX();
        matrix[0][2] = third.getX();

        matrix[1][0] = first.getY();
        matrix[1][1] = second.getY();
        matrix[1][2] = third.getY();

        matrix[2][0] = first.getZ();
        matrix[2][1] = second.getZ();
        matrix[2][2] = third.getZ();

        return matrix;
    }

    private double calculateARatio(double[][] m) {
        return m[1][0] * (m[2][1] - m[2][2]) + m[1][1] * (m[2][2] - m[2][0]) + m[1][2] * (m[2][0] - m[2][1]);
    }

    private double calculateBRatio(double[][] m) {
        return m[2][0] * (m[0][1] - m[0][2]) + m[2][1] * (m[0][2] - m[0][0]) + m[2][2] * (m[0][0] - m[0][1]);
    }

    private double calculateCRatio(double[][] m) {
        return m[1][2] * (m[0][1] - m[0][0]) + m[0][2] * (m[1][0] - m[1][1]);
    }



}