package cl.german;


import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import static org.junit.Assert.assertTrue;


public class CarroLecheroServiceShould {

    private static final String CARROS_LECHEROS_INPUT_TXT = "/carros-lecheros-input.txt";
    private static final String CARROS_LECHEROS_OUTPUT_TXT = "/carros-lecheros-output.txt";
    private static final String CARROS_LECHEROS_EXPECTED_TXT = "/carros-lecheros-expected.txt";


    @Test
    public void processCarroLechero() throws Exception {
        URL inputFileUrl = CarroLecheroServiceShould.class.getResource(CARROS_LECHEROS_INPUT_TXT);

        List<String> commands = FileUtils.readLines(FileUtils.toFile(inputFileUrl));

        CarroLecheroService service = new CarroLecheroService();

        service.processCommands(commands);

        URL outputFileURL = CarroLecheroServiceShould.class.getResource(CARROS_LECHEROS_OUTPUT_TXT);
        File outputFile = FileUtils.toFile(outputFileURL);

        assertTrue(isExpectedOutput(outputFile));
    }


    private boolean isExpectedOutput(File resultsFile) throws IOException {
        URL expectedFileURL = CarroLecheroServiceShould.class.getResource(CARROS_LECHEROS_EXPECTED_TXT);
        File expectedFile = FileUtils.toFile(expectedFileURL);

        String resultsFileString = FileUtils.readFileToString(resultsFile);
        String expectedFileString = FileUtils.readFileToString(expectedFile);

        System.out.println("RESULTS:\n" + resultsFileString);
        System.out.println("EXPECTED:\n" + expectedFileString);

        return resultsFileString.equals(expectedFileString);
    }
}
