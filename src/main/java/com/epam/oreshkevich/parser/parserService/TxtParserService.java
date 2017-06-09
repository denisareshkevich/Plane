package com.epam.oreshkevich.parser.parserService;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Denis Areshkevich on 24.05.2017.
 */
public class TxtParserService {

    private Logger logger = LogManager.getLogger();

    private final String regex = "\\s+";

    public Optional<List<Double>> splitAndConvert(String string) {
        List<String> strings = splitForSpace(string);
        return convert(strings);
    }

    private Optional<List<Double>> convert(List<String> strings) {
        try {
            List<Double> collected = strings.stream().map(Double::parseDouble)
                    .collect(Collectors.toList());
            return Optional.of(collected);
        } catch (NumberFormatException e) {
            logger.log(Level.WARN, "Can't parse to double string " + strings);
            return Optional.empty();
        }
    }

    private List<String> splitForSpace(String string) {
        return Arrays.asList(string.split(regex));
    }
}