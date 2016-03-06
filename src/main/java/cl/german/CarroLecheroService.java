package cl.german;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;

public class CarroLecheroService {


    public void processCommands(List<String> contextAndCommands) throws IOException, URISyntaxException {
        File outputFile = FileUtils.toFile(CarroLecheroService.class.getResource("/carros-lecheros-output.txt"));

        String[] worldLimits = contextAndCommands.remove(0).split(" ");
        Integer maxX = Integer.parseInt(worldLimits[0]);
        Integer maxY = Integer.parseInt(worldLimits[1]);

        Iterator<String> iterator = contextAndCommands.iterator();

        while (iterator.hasNext()){
            String[] initialization = iterator.next().split(" ");
            String actions = iterator.next();

            int x = Integer.parseInt(initialization[0]);
            int y = Integer.parseInt(initialization[1]);
            String orientation = initialization[2];

            CarroLechero carro = new CarroLechero(x, y , orientation);

            for (char action : actions.toCharArray()){
                carro.act(action);
                //if (isOutOfBounds(carro)){
                    //break y marcar exception
               // }
            }

            //carros.add(carro);

        }

    }
}
