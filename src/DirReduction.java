import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DirReduction {
    public static String[] dirReduc(String[] strings) {
        Map<String, String> mapping = new HashMap<>();
        mapping.put("NORTH", "SOUTH");
        mapping.put("SOUTH", "NORTH");
        mapping.put("WEST", "EAST");
        mapping.put("EAST", "WEST");

        int i = 0;
        int j = 1;
        List<String> listOfStrings = new ArrayList<>(Arrays.asList(strings));


        while (true) {
            if (listOfStrings.get(i).equals(mapping.get(listOfStrings.get(j)))) {
                listOfStrings.remove(j--);
                listOfStrings.remove(i--);
            } else {
                i++;
                j++;
            }
            if (i < 0){
                i = 0;
                j = 1;
            }
            if (j >= listOfStrings.size()) break;
        }

        return listOfStrings.toArray(new String[]{});

    }
}
