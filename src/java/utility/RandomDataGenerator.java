package utility;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.commons.lang3.RandomStringUtils;
/**
 * @author Tobias Jacobsen
 */
public class RandomDataGenerator {

    public static String getData(int num, String inputStr) {

        List<String> stringArray = new ArrayList();
        Scanner scan = new Scanner(inputStr);
        scan.useDelimiter(",");
        while (scan.hasNext()) {
            stringArray.add(scan.next());
        }
        scan.close();

        JsonArray entities = new JsonArray();
        for (int i = 0; i < num; i++) {
            JsonObject person = new JsonObject();
            for (int j = 0; j < stringArray.size(); j++) {
                person.addProperty(stringArray.get(j), RandomStringUtils.random(5, "ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
            }

            entities.add(person);
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonStr = gson.toJson(entities);
        return jsonStr;
    }

}
