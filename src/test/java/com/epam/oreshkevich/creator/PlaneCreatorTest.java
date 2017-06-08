package com.epam.oreshkevich.creator;

import com.epam.oreshkevich.entity.Plane;
import com.epam.oreshkevich.entity.Point;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by Denis Areshkevich on 06.06.2017.
 */
public class PlaneCreatorTest {

    private static ArrayList<Point> points;
    private static Point first;
    private static Point second;
    private static Point third;

    @Before
    public void init(){
        first = new Point(1.0, 2.0, 3.0);
        second = new Point(4.0, 5.0, 6.0);
        third = new Point(7.0, 8.0, 9.0);
        points = new ArrayList<>();
        points.add(first);
        points.add(second);
        points.add(third);

    }

    @Test
    public void create() {
        PlaneCreator planeCreator = new PlaneCreator();
        Optional<Plane> optional = planeCreator.create(Optional.of(points));
        Assert.assertTrue(optional.isPresent());
    }

}