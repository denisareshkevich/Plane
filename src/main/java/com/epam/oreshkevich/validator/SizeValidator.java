package com.epam.oreshkevich.validator;

import java.util.List;

/**
 * Created by Denis Areshkevich on 06.06.2017.
 */
public class SizeValidator {

    private static final int LIST_SIZE = 3;

    public static boolean checkSize(List<? extends Object> objects) {
        return objects.size() == LIST_SIZE;
    }
}
