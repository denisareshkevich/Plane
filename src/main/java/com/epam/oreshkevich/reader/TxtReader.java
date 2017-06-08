package com.epam.oreshkevich.reader;

import com.epam.oreshkevich.exeption.CanNotReadFileException;
import jdk.internal.util.xml.impl.ReaderUTF8;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Denis Areshkevich on 24.05.2017.
 */
public class TxtReader {

    public List<String> readAndCollectByLines(String fileName) throws CanNotReadFileException {
        try (BufferedReader bufferedReader = new BufferedReader(new ReaderUTF8(this.getClass().
                getClassLoader().getResourceAsStream(fileName)))) {
            return bufferedReader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            throw new CanNotReadFileException("Something wrong with file " + fileName);
        }
    }
}
