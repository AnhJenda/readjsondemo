import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.imageio.IIOException;
import java.io.FileNotFoundException;
import java.io.FileReader;

/*
    @author: Dinh Quang Anh
    Date   : 5/31/2022
    Project: readjsondemo
*/
public class ReadJSONTest {
    public static void main(String[] args) {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("employee.json")){
            Object obj = jsonParser.parse(reader);
            JSONArray employeeList = (JSONArray) obj;
            System.out.println(employeeList);
            employeeList.forEach(emp -> parseEmployeeObject((JSONObject) emp));
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IIOException e){
            e.printStackTrace();
        }catch (ParseException e){
            e.printStackTrace();
        }
    }
    private static void parseEmployeeObject(@NotNull JSONObject employee){
        JSONObject employeeObject = (JSONObject) employee.get("employee");
        String firstName = (String) employeeObject.get("firstName");
        System.out.println(firstName);
        String lastName = (String) employeeObject.get("lastName");
        System.out.println(lastName);
        String website = (String) employeeObject.get("website");
        System.out.println(website);
    }
}
