package qcjsondemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONUtilities;
import org.quickconnectfamily.json.ParseException;
import pojo.Person;

public class QCJSONDemo {
    
    private static final String FILE_NAME = "mercury7.json";
    
    private static void stringifyDemo()
    {
        Person glen = new Person("John", "Glen", 1921);
        Person shepard = new Person("Alan", "Shepard", 1923);
        Person grissom = new Person("Gus", "Grissom", 1926);
        Person cooper = new Person("Gordon", "Cooper", 1927);
        Person schirra = new Person("Wally", "Schirra", 1923);
        Person carpenter = new Person("Scott", "Carpenter", 1925);
        Person slayton = new Person("Deke", "Slayton", 1924);
        
        Person[] mercury7 = {glen, shepard, grissom, cooper, 
            schirra, carpenter, slayton};
        
        String json = "";
        
        //Stringify the array
        try {
            json = JSONUtilities.stringify(mercury7);
            System.out.println(json);
        } catch (JSONException ex) {
            System.err.println(ex.getMessage());
        }
        
        //Save JSON to file
        try (FileWriter file = new FileWriter(FILE_NAME)) {
            file.write(json);
            file.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private static void parseDemo()
    {
        try (FileInputStream fis = new FileInputStream(FILE_NAME)) {
            JSONInputStream jsonIn = new JSONInputStream(fis);
            List parsedJson = (ArrayList)jsonIn.readObject();
            System.out.println(parsedJson);
            parsedJson.forEach(obj -> {
                Person person = new Person((Map)obj);
                System.out.println(person);
            });
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException | ParseException | JSONException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        stringifyDemo();
        parseDemo();
    }
}
