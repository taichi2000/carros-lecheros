package cl.german;


import org.junit.Test;

import static cl.german.Cardinal.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class CardinalShould {

    @Test
    public void returnLeft() throws Exception {
        assertThat(N.left(), is(O));
        assertThat(S.left(), is(E));
        assertThat(E.left(), is(N));
        assertThat(O.left(), is(S));
    }


    @Test
    public void returnRight() throws Exception {
        assertThat(N.right(), is(E));
        assertThat(S.right(), is(O));
        assertThat(E.right(), is(S));
        assertThat(O.right(), is(N));
    }
}