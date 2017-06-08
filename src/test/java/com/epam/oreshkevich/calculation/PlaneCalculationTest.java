package com.epam.oreshkevich.calculation;

import com.epam.oreshkevich.entity.Plane;
import com.epam.oreshkevich.entity.Point;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Denis Areshkevich on 05.06.2017.
 */
public class PlaneCalculationTest {

    private static Plane plane;
    private static Point first;
    private static Point second;
    private static Point third;
    private static PlaneCalculation planeCalculation;


    @Before
    public void init() {
        first = new Point(32, 11, 0);
        second = new Point(13, 5, 8);
        third = new Point(2, 6, 14);
        plane = new Plane(first, second, third);
        planeCalculation = new PlaneCalculation();
    }

    @Test
    public void crossesAnyAxeAtRightAngleTest() throws Exception {
        assertFalse(planeCalculation.crossesAnyAxeAtRightAngle(plane, 0.001));
    }

    @Test
    public void calculateAngleWithOXYTest() throws Exception {
        double expected = 121.878;
        double actual = planeCalculation.calculateAngleWithOXY(plane);
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void calculateAngleWithOXZTest() throws Exception {
        double expected = 144.128;
        double actual = planeCalculation.calculateAngleWithOXZ(plane);
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void calculateAngleWithOYZTest() throws Exception {
        double expected = 174.011;
        double actual = planeCalculation.calculateAngleWithOYZ(plane);
        assertEquals(expected, actual, 0.001);
    }

}