package com.epam.oreshkevich.creator;

import com.epam.oreshkevich.creator.creatorHandler.implementation.PointCreatorHandler;
import com.epam.oreshkevich.entity.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Denis Areshkevich on 06.06.2017.
 */
public class PointCreator {

    public Optional<List<Point>> create(Optional<List<List<Double>>> optionalDoubles) {
        ArrayList<Point> points = new ArrayList<>();
        PointCreatorHandler pointCreatorHandler = new PointCreatorHandler();
        if (optionalDoubles.isPresent()) {
            List<List<Double>> lists = optionalDoubles.get();
            for (int i = 0; i < lists.size(); i++) {
                List<Double> doubles = lists.get(i);
                Optional<Point> pointOptional = pointCreatorHandler.create(Optional.of(doubles));
                pointOptional.ifPresent(points::add);
            }
        }
        return Optional.of(points);
    }
}
