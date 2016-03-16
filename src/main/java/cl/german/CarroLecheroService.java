package cl.german;


import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class CarroLecheroService {

    private Integer maxX;
    private Integer maxY;


    public void processCommands(List<String> linesFromFile) throws IOException, URISyntaxException {
        File outputFile = FileUtils.toFile(CarroLecheroService.class.getResource("/carros-lecheros-output.txt"));

        setWorldLimits(linesFromFile);

        List<CarroLechero> carros = new ArrayList<>();

        Iterator<String> iterator = linesFromFile.iterator();

        while (iterator.hasNext()) {
            String carroLocationLine = iterator.next();
            String actions = iterator.next();

            CarroLechero carro = createAndProcessCarro(carroLocationLine, actions);

            carros.add(carro);
        }

        FileUtils.writeLines(outputFile, carros);
    }


    private CarroLechero createAndProcessCarro(String carroLocationLine, String actions) {
        String[] initialization = carroLocationLine.split(" ");

        CarroLechero carro = createCarroLechero(initialization);

        for (char action : actions.toCharArray()) {
            carro.act(action);
            //if (isOutOfBounds(carro)){
            //break y marcar exception
            // }
        }

        return carro;
    }


    private CarroLechero createCarroLechero(String[] initialization) {
        int x = Integer.parseInt(initialization[0]);
        int y = Integer.parseInt(initialization[1]);
        String orientation = initialization[2];

        return new CarroLechero(x, y, orientation);
    }


    private void setWorldLimits(List<String> lines) {
        String[] worldLimits = lines.remove(0).split(" ");
        maxX = Integer.parseInt(worldLimits[0]);
        maxY = Integer.parseInt(worldLimits[1]);
    }
}
