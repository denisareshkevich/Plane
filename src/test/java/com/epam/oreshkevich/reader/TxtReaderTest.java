package com.epam.oreshkevich.reader;

import com.epam.oreshkevich.exeption.CanNotReadFileException;
import org.junit.*;

import java.util.List;

/**
 * Created by Denis Areshkevich on 25.05.2017.
 */
public class TxtReaderTest {

    private static final String filename = "file/resourceFile.txt";

    @Test
    public void readAndCollectByLines() throws CanNotReadFileException {
        TxtReader txtReader = new TxtReader();
        List<String> stringList = txtReader.readAndCollectByLines(filename);
        Assert.assertTrue(!stringList.isEmpty());
    }
}