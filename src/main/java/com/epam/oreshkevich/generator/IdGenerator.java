package com.epam.oreshkevich.generator;

/**
 * Created by Denis Areshkevich on 06.06.2017.
 */
public class IdGenerator {
private static int id = 1000;
    public static int generateId(){
       return  ++id;
    }
}
