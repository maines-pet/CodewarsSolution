import java.util.HashMap;
import java.util.Map;

public class SimpleAssembler {

    public static Map<String, Integer> interpret(String[] program) {

        final Map<String, Integer> result = new HashMap<>();
        for (int i = 0; i < program.length; i++) {
            final String[] commands = program[i].split(" ");
            switch (commands[0]){
                case "mov"
                    : result.put(commands[1], getValueOrReference(result, commands[2]));
                        break;
                case "inc"
                    : result.put(commands[1], getValueOrReference(result, commands[1]) + 1);
                        break;
                case "dec"
                    : result.put(commands[1], getValueOrReference(result, commands[1]) - 1);
                        break;
                case "jnz"
                    : if (getValueOrReference(result, commands[1]) != 0){
                        i += getValueOrReference(result, commands[2]) - 1;
                        break;
                    }
            }
        }
        return result;
    }

    private static int getValueOrReference(final Map<String, Integer> mapping, final String valueOrReference){
        try {
            return Integer.parseInt(valueOrReference);
        } catch (NumberFormatException ex){
            return mapping.get(valueOrReference);
        }
    }
}