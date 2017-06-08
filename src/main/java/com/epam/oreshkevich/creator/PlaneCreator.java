package com.epam.oreshkevich.creator;

import com.epam.oreshkevich.entity.Plane;
import com.epam.oreshkevich.entity.Point;

import java.util.List;
import java.util.Optional;

/**
 * Created by Denis Areshkevich on 25.05.2017.
 */
public class PlaneCreator {

    private final int FIRST = 0;
    private final int SECOND = 1;
    private final int THIRD = 2;

    public Optional<Plane> create(Optional<List<Point>> optional) {
        if (optional.isPresent()) {
            List<Point> points = optional.get();
            Point first = points.get(FIRST);
            Point second = points.get(SECOND);
            Point third = points.get(THIRD);
            Plane plane = new Plane(first, second, third);
            return Optional.of(plane);
        }
        return Optional.empty();
    }

}
