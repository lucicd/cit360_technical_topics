package jsondemo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import pojo.Person;

public class JSONDemo {
    
    private static final String FILE_NAME = "people.json";
    
    private static void demoSerialize()
    {
        Person p1 = new Person("Joe", "Anderson", 40);
        Person p2 = new Person("Jane", "Potter", 45);
        Person p3 = new Person("Mark", "Steltzner", 25);
        
        List<Person> people = new ArrayList<>();
        people.add(p1);
        people.add(p2);
        people.add(p3);
        
        JSONArray list = new JSONArray();
        people.forEach((Person person) -> {
            list.add(person.makeJSONObject());
        });
        
        //Print JSON to screen
        System.out.println(list.toJSONString());
        
        //Save JSON to file
        try (FileWriter file = new FileWriter(FILE_NAME)) {
            file.write(list.toJSONString());
            file.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private static void demoDeserializeString()
    {
        String json = "["
                + "{\"firstName\": \"Peter\", \"lastName\": \"One Two\", \"age\": 30}, "
                + "{\"firstName\": \"James\", \"lastName\": \"Three, Four\", \"age\": 40}, "
                + "{\"firstName\": \"John\", \"lastName\": \"Six-Seven\", \"age\": 50}"
                + "]";
        System.out.println(json);
        JSONParser parser = new JSONParser();
        try {
            JSONArray list = (JSONArray)parser.parse(json);
            list.forEach((Object obj) -> {
                Person person = new Person((JSONObject)obj);
                System.out.println(person);
            });
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    private static void demoDeserializeFile()
    {
        JSONParser parser = new JSONParser();
        try {
            JSONArray list = (JSONArray)parser.parse(new FileReader(FILE_NAME));
            System.out.println(list.toJSONString());
            list.forEach((Object obj) -> {
                Person person = new Person((JSONObject)obj);
                System.out.println(person);
            });
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=============Serialize demo");
        demoSerialize();
        System.out.println("\n=============Deserialize string demo");
        demoDeserializeString();
        System.out.println("\n=============Deserialize form file");
        demoDeserializeFile();
    }
}
