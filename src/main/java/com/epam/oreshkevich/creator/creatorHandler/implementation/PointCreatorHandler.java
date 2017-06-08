package com.epam.oreshkevich.creator.creatorHandler.implementation;

import com.epam.oreshkevich.creator.creatorHandler.Icreator;
import com.epam.oreshkevich.entity.Point;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

/**
 * Created by Denis Areshkevich on 25.05.2017.
 */
public class PointCreatorHandler implements Icreator<Point, Double> {

    private Logger logger = LogManager.getLogger(PointCreatorHandler.class);

    private final int X = 0;
    private final int Y = 1;
    private final int Z = 2;

    @Override
    public Optional<Point> create(Optional<List<Double>> optionalDoubles) {
        if (checkForPresent(optionalDoubles)) {
            List<Double> doubles = optionalDoubles.get();
            Double x = doubles.get(X);
            Double y = doubles.get(Y);
            Double z = doubles.get(Z);
            Point point = new Point(x, y, z);
            return Optional.of(point);
        } else {
            logger.log(Level.WARN, "Bad optional " +  optionalDoubles);
            return  Optional.empty();
        }
    }

    private boolean checkForPresent(Optional<List<Double>> optionalDoubles){
        return optionalDoubles.isPresent();
    }

}
