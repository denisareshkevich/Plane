package com.epam.oreshkevich.parser;


import com.epam.oreshkevich.parser.parserService.TxtParserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Denis Areshkevich on 06.06.2017.
 */
public class TxtParser {

    public Optional<List<List<Double>>> parse(List<String> strings) {
        if (!strings.isEmpty()) {
            ArrayList<List<Double>> listDoubles = new ArrayList<>();
            TxtParserService txtParserService = new TxtParserService();
            for (int i = 0; i < strings.size(); i++) {
                String string = strings.get(i);
                Optional<List<Double>> listOptional = txtParserService.splitAndConvert(string);
                listOptional.ifPresent(listDoubles::add);
            }
            return Optional.of(listDoubles);
        }
        return Optional.empty();
    }

}
