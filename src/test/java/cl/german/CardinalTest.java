package cl.german;

import junit.framework.TestCase;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by german on 06-03-16.
 */
public class CardinalTest extends TestCase {

    public void testLeft() throws Exception {
        assertThat(Cardinal.N.left(), is(Cardinal.O));

    }

    public void testRight() throws Exception {

    }
}