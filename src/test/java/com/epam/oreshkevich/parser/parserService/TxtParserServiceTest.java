package com.epam.oreshkevich.parser.parserService;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


/**
 * Created by Denis Areshkevich on 06.06.2017.
 */
public class TxtParserServiceTest {

    private String string = "1 2 3";

    @Test
    public void splitAndConvert() {
        TxtParserService txtParserService = new TxtParserService();
        Optional<List<Double>> optional = txtParserService.splitAndConvert(string);
        boolean containsAll = optional.get().containsAll(Arrays.asList(1.0, 2.0, 3.0));
        Assert.assertTrue(containsAll);
    }

}