package com.epam.oreshkevich.creator.creatorHandler.implementation;

import com.epam.oreshkevich.entity.Point;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Denis Areshkevich on 06.06.2017.
 */
public class PointCreatorHandlerTest {

    private static PointCreatorHandler pointCreatorHandler;
    private static Optional<List<Double>> optionalDoubles;

    @Before
    public void init(){
        pointCreatorHandler = new PointCreatorHandler();
        Double first = 1.0;
        Double second = 2.0;
        Double third = 3.0;
        ArrayList<Double> doubleList = new ArrayList<>();
        doubleList.add(first);
        doubleList.add(second);
        doubleList.add(third);
        optionalDoubles = Optional.of(doubleList);
    }
    @Test
    public void create() {
        Optional<Point> pointOptional = pointCreatorHandler.create(optionalDoubles);
        Assert.assertTrue(pointOptional.isPresent());
    }

}