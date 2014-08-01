package srm207.round1.division2.level3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import srm207.division2.CaptureThemAll;
import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: emmanuel
 * Date: 10/8/13
 * Time: 4:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class CaptureThemAllTest {
    private CaptureThemAll chess;
    @Before
    public void setUp() throws Exception {
        chess = new CaptureThemAll();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testMinMoves0() throws Exception {
        int expected = 2;
        int actual = chess.fastKnight("a1", "b3", "c5");
        assertEquals("Failed chess.fastKnight(\"a1\",\"b3\",\"c5\")", expected, actual);
    }

    @Test
    public void testMinMoves1() throws Exception {
        int expected = 3;
        int actual = chess.fastKnight("b1", "c3", "a3");
        assertEquals("Failed chess.fastKnight(\"b1\",\"c3\",\"a3\")", expected, actual);
    }

    @Test
    public void testMinMoves2() throws Exception {
        int expected = 6;
        int actual = chess.fastKnight("a1", "a2", "b2");
        assertEquals("Failed chess.fastKnight(\"a1\",\"a2\",\"b2\")", expected, actual);
    }

    @Test
    public void testMinMoves3() throws Exception {
        int expected = 3;
        int actual = chess.fastKnight("a5", "b7", "e4");
        assertEquals("Failed chess.fastKnight(\"a5\",\"b7\",\"e4\")", expected, actual);
    }

    @Test
    public void testMinMoves4() throws Exception {
        int expected = 6;
        int actual = chess.fastKnight("h8", "e2", "d2");
        assertEquals("Failed chess.fastKnight(\"h8\",\"e2\",\"d2\")", expected, actual);
    }
}
