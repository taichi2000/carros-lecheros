package cl.german;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class CarroLecheroShould {

    @Test
    public void moveOneStepToNorth() throws Exception {
        CarroLechero carro = new CarroLechero(1, 2, "N");

        carro.act('M');

        assertThat(carro.getX(), is(1));
        assertThat(carro.getY(), is(3));
        assertThat(carro.getOrientation(), is(Cardinal.N));
    }
}