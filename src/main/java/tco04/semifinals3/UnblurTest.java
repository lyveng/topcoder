package tco04.semifinals3;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UnblurTest {

    protected Unblur solution;

    @Before
    public void setUp() {
        solution = new Unblur();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] blurred = new String[]{"1221", "1221", "1221"};

        String[] expected = new String[]{"....", ".##.", "...."};
        String[] actual = solution.original(blurred);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] blurred = new String[]{"00000", "00000", "00000", "00000"};

        String[] expected = new String[]{".....", ".....", ".....", "....."};
        String[] actual = solution.original(blurred);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] blurred = new String[]{"0011212121100", "0123333333210", "0123333333210", "1233333333321", "1233333333321", "1233333333321", "0112121212110"};

        String[] expected = new String[]{".............", "...#.#.#.#...", "..#.#.#.#.#..", ".............", ".#.#.#.#.#.#.", "..#.#.#.#.#..", "............."};
        String[] actual = solution.original(blurred);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String[] blurred = new String[]{"1233321000000000123332100000000000000000000", "1244422233222332334343323322232112332223321", "1255523344343443545343434434343233432334432", "0033303455465775633011445546454355753457753", "0033303333364543533011433336333364521346542", "0033303455464532445343545546454355753446542", "0022202344342200234343434434343233432323221", "0011101233221100123332223322232112332211111"};

        String[] expected = new String[]{"...........................................", ".#####...........#####.....................", "...#...####.####.#...#.####.###..####.####.", "...#...#..#.#..#.#.....#..#.#..#.#....#..#.", "...#...#..#.####.#.....#..#.#..#.###..####.", "...#...#..#.#....#...#.#..#.#..#.#....#.#..", "...#...####.#....#####.####.###..####.#..#.", "..........................................."};
        String[] actual = solution.original(blurred);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String[] blurred = new String[]{"0000123210000", "0012456542100", "0135789875310", "0258988898520", "1479865689741", "2589742479852", "2589742479852", "1479865689741", "0258988898520", "0135789875310", "0012456542100", "0000123210000"};

        String[] expected = new String[]{".............", ".....###.....", "...#######...", "..#########..", "..####.####..", ".####...####.", ".####...####.", "..####.####..", "..#########..", "...#######...", ".....###.....", "............."};
        String[] actual = solution.original(blurred);

        Assert.assertArrayEquals(expected, actual);
    }

}
