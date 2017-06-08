import com.epam.oreshkevich.creator.PlaneCreator;
import com.epam.oreshkevich.creator.PointCreator;
import com.epam.oreshkevich.entity.Plane;
import com.epam.oreshkevich.entity.Point;
import com.epam.oreshkevich.exeption.CanNotReadFileException;
import com.epam.oreshkevich.parser.TxtParser;
import com.epam.oreshkevich.reader.TxtReader;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

/**
 * Created by Denis Areshkevich on 08.06.2017.
 */
public class FullPlaneCreationTest {

    private static final String filename = "file/resourceFile.txt";

    @Test
    public void fullPlaneCreationTest() throws CanNotReadFileException {
        TxtReader txtReader = new TxtReader();
        List<String> stringList = txtReader.readAndCollectByLines(filename);
        TxtParser txtParser = new TxtParser();
        Optional<List<List<Double>>> lists = txtParser.parse(stringList);
        PointCreator pointCreator = new PointCreator();
        Optional<List<Point>> points = pointCreator.create(lists);
        PlaneCreator planeCreator = new PlaneCreator();
        Optional<Plane> optional = planeCreator.create(points);
        Assert.assertTrue(optional.isPresent());
    }
}
