import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

public class SimpleAssemblerTest {
    @Test
    public void simple_1() {
        String[] program = new String[]{"mov a 5", "mov b a"};
        Map<String, Integer> out = new HashMap<>();
        out.put("a", 5);
        out.put("b", 5);
        assertEquals(out, SimpleAssembler.interpret(program));
    }

    @Test
    public void caseIncrement() {
        String[] program = new String[]{"mov a -5", "mov b a", "inc a", "inc b", "inc b"};
        Map<String, Integer> out = new HashMap<>();
        out.put("a", -4);
        out.put("b", -3);
        assertEquals(out, SimpleAssembler.interpret(program));
    }


    @Test
    public void caseDecrement() {
        String[] program = new String[]{"mov a 5", "mov b a", "inc a", "dec b", "dec b"};
        Map<String, Integer> out = new HashMap<>();
        out.put("a", 6);
        out.put("b", 3);
        assertEquals(out, SimpleAssembler.interpret(program));
    }

    @Test
    public void caseIncrementDecrement() {
        String[] program = new String[]{"mov a 5", "mov b a", "inc a", "dec b", "dec b", "inc b"};
        Map<String, Integer> out = new HashMap<>();
        out.put("a", 6);
        out.put("b", 4);
        assertEquals(out, SimpleAssembler.interpret(program));
    }

    @Test
    public void caseLoop() {
        String[] program = new String[]{"mov a 5", "dec a", "jnz a -1"};
        Map<String, Integer> out = new HashMap<>();
        out.put("a", 0);
        assertEquals(out, SimpleAssembler.interpret(program));
    }

    @Test
    public void simple_2() {
        String[] program = new String[]{"mov a -10", "mov b a", "inc a", "dec b", "jnz a -2"};
        Map<String, Integer> out = new HashMap<>();
        out.put("a", 0);
        out.put("b", -20);
        assertEquals(out, SimpleAssembler.interpret(program));
    }
}