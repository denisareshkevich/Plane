package com.epam.oreshkevich.parser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by Denis Areshkevich on 06.06.2017.
 */
public class TxtParserTest {

    private static List<String> strings;
    private static  ArrayList<List<Double>> expected;

    @Before
    public void init() {
        String first = "1 2 3";
        String second = "4 5 6";
        String third = "7 8 9";
        strings = new ArrayList<>();
        strings.add(first);
        strings.add(second);
        strings.add(third);
        expected = new ArrayList<>();

        List<Double> firstList = Arrays.asList(1.0, 2.0, 3.0);
        List<Double> secondList = Arrays.asList(4.0, 5.0, 6.0);
        List<Double> thirdList = Arrays.asList(7.0, 8.0, 9.0);

        expected.add(firstList);
        expected.add(secondList);
        expected.add(thirdList);
    }

    @Test
    public void parse() {
        TxtParser txtParser = new TxtParser();
        List<List<Double>> actual = txtParser.parse(strings).get();
        Assert.assertEquals(expected, actual);
    }

}