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

    /**
     * 1) Scans input: "inputStr" using "," as delimiter and add each piece to a
     * stringArray.
     *
     * 2) Run first loop which creates a number JsonObjects based on input:
     * "num".
     *
     * 3) In first loop create second loop based on stringArray-size, meaning
     * the it loops the number of times as comma separated pieces. Ex.
     * fname,lname,city = 3 times.
     *
     * 4) In second loop, add random string property to JsonObject using
     * RandomStringUtils-library.
     *
     * 5) Return all jsonObjects in jsonArray
     *
     * @param num number of jsonObjects in array
     * @param inputStr number of jsonObject properties
     * @return jsonArray containing jsonObjects
     */
    public static String getData(int num, String inputStr) {
        List<String> stringArray = new ArrayList();
        
        try (Scanner scan = new Scanner(inputStr)) {
            scan.useDelimiter(",");
            while (scan.hasNext()) {
                stringArray.add(scan.next());
            }
        }
        
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
