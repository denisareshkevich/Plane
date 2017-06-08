package com.epam.oreshkevich.creator;

import com.epam.oreshkevich.entity.Point;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


/**
 * Created by Denis Areshkevich on 06.06.2017.
 */
public class PointCreatorTest {

    private static ArrayList<List<Double>> lists;
    private static Point first;
    private static Point second;
    private static Point third;

    @Before
    public void init(){
        lists = new ArrayList<>();
        List<Double> firstList = Arrays.asList(1.0, 2.0, 3.0);
        List<Double> secondList = Arrays.asList(4.0, 5.0, 6.0);
        List<Double> thirdList = Arrays.asList(7.0, 8.0, 9.0);
        lists.add(firstList);
        lists.add(secondList);
        lists.add(thirdList);
        first = new Point(1.0, 2.0, 3.0);
        second = new Point(4.0, 5.0, 6.0);
        third = new Point(7.0, 8.0, 9.0);
    }

    @Test
    public void create() {
        PointCreator pointCreator = new PointCreator();
        Optional<List<Point>> listOptional = pointCreator.create(Optional.of(lists));
        List<Point> points = listOptional.get();
        Assert.assertTrue(points.containsAll(Arrays.asList(first, second, third)));
    }

}