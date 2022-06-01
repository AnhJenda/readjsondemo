/*
    @author: Dinh Quang Anh
    Date   : 5/31/2022
    Project: readjsondemo
*/
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;

public class WriteJSONTest {
    @SuppressWarnings("Unchecked")
    public static void main(String[] args) {
        JSONObject employeeDetails = new JSONObject();
        employeeDetails.put("firstName", "Dang");
        employeeDetails.put("lastName", "Kim Thi");
        employeeDetails.put("website", "codelean.vn");

        JSONObject employeeObject = new JSONObject();
        employeeObject.put("employee", employeeDetails);

        JSONObject employeeDetails2 = new JSONObject();
        employeeDetails2.put("firstName", "Code");
        employeeDetails2.put("lastName", "Lean");
        employeeDetails2.put("website", "codelean.com");

        JSONObject employeeObject2 = new JSONObject();
        employeeObject2.put("employee", employeeDetails2);

        JSONArray employeeList = new JSONArray();
        employeeList.add(employeeObject);
        employeeList.add(employeeObject2);

        try(FileWriter file = new FileWriter("employee.json")) {
            file.write(employeeList.toJSONString());
            file.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
