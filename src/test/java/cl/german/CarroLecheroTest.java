package cl.german;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class CarroLecheroTest {

    @Test
    public void shouldProcessCarroLechero() throws Exception {
        URL inputFileUrl = CarroLecheroTest.class.getResource("/carros-lecheros-input.txt");

        List<String> commands = FileUtils.readLines(FileUtils.toFile(inputFileUrl));

        CarroLecheroService service = new CarroLecheroService();

        service.processCommands(commands);

        URL outputFileURL = CarroLecheroTest.class.getResource("/carros-lecheros-output.txt");
        File outputFile = FileUtils.toFile(outputFileURL);

        assertTrue(isExpectedOutput(outputFile));
    }

    private boolean isExpectedOutput(File resultsFile) throws IOException {
        URL expectedFileURL = CarroLecheroTest.class.getResource("/carros-lecheros-expected.txt");
        File expectedFile = FileUtils.toFile(expectedFileURL);

        String resultsFileString = FileUtils.readFileToString(resultsFile);
        String expectedFileString = FileUtils.readFileToString(expectedFile);

        System.out.println("RESULTS:\n" + resultsFileString);
        System.out.println("EXPECTED:\n" + expectedFileString);

        return resultsFileString.equals(expectedFileString);
    }
}
