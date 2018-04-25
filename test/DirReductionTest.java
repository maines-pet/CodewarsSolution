import org.junit.Test;

import static org.junit.Assert.*;

public class DirReductionTest {
    @Test
    public void shouldReduce() {
        assertArrayEquals("\"NORTH\", \"WEST\", \"SOUTH\", \"EAST\"",
                new String[]{"NORTH", "WEST", "SOUTH", "EAST"},
                DirReduction.dirReduc(new String[]{"NORTH", "WEST", "SOUTH", "EAST"}));
        assertArrayEquals(new String[]{},
                DirReduction.dirReduc(new String[]{"NORTH", "SOUTH"}));
        assertArrayEquals(new String[]{"NORTH", "WEST"},
                DirReduction.dirReduc(new String[]{"NORTH", "WEST"}));
        assertArrayEquals(new String[]{},
                DirReduction.dirReduc(new String[]{"EAST", "WEST"}));
        assertArrayEquals(new String[]{"WEST"},
                DirReduction.dirReduc(new String[]{"NORTH", "SOUTH", "WEST"}));
        assertArrayEquals(new String[]{},
                DirReduction.dirReduc(new String[]{"EAST", "NORTH", "SOUTH", "WEST"}));
        assertArrayEquals(new String[]{"WEST"},
                DirReduction.dirReduc(new String[]{"NORTH", "SOUTH", "WEST", "NORTH", "SOUTH"}));
    }

    @Test
    public void shouldReduceToMoreThanTwo() {
        assertArrayEquals(new String[]{"WEST"},
                DirReduction.dirReduc(new String[]{"NORTH", "SOUTH", "WEST"}));
        assertArrayEquals(new String[]{"NORTH"},
                DirReduction.dirReduc(new String[]{"NORTH", "EAST", "WEST"}));


        assertArrayEquals(new String[]{"NORTH", "EAST", "NORTH"},
                DirReduction.dirReduc(new String[]{"NORTH", "WEST", "EAST", "NORTH", "WEST", "EAST", "SOUTH","EAST", "NORTH"}));
    }
}