package jacksondemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import pojo.Person;

public class JacksonDemo {
    
    private static final String FILE_NAME  = "people.json";

    private static List<Person> createPeople()
    {
        List<Person> people = new ArrayList<>();
        people.add(new Person("John", "Glen", 1921));
        people.add(new Person("Alan", "Shepard", 1923));
        people.add(new Person("Gus", "Grissom", 1926));
        people.add(new Person("Gordon", "Cooper", 1927));
        people.add(new Person("Wally", "Schirra", 1923));
        people.add(new Person("Scott", "Carpenter", 1925));
        people.add(new Person("Deke", "Slayton", 1924));
        return people;
    }
    
    private static String stringify(List<Person> people) 
            throws JsonProcessingException
    {   
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        String json = mapper.writeValueAsString(people);
        return json;
    }
    
     private static void stringifyToFile(List<Person> people) 
            throws JsonProcessingException, IOException
    {   
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper.writeValue(new File(FILE_NAME), people);
    }
    
    private static List<Person> parse(String json) throws IOException
    {
        List<Person> people;
        ObjectMapper mapper = new ObjectMapper();
        people = mapper.readValue(json, new TypeReference<List<Person>>() { });
        return people;
    }
    
    private static List<Person> parseFromFile() throws IOException
    {
        List<Person> people;
        ObjectMapper mapper = new ObjectMapper();
        people = mapper.readValue(new File(FILE_NAME), 
                new TypeReference<List<Person>>() { });
        return people;
    }
    
    public static void main(String[] args) {
        try {
            System.out.println("Stringify demo");
            List<Person> people = createPeople();
            String json = stringify(people);
            System.out.println(json);
            
            System.out.println("\nParse demo");
            people = parse(json);
            people.forEach(System.out::println);
            
            System.out.println("\nFile stringify and parse demo");
            stringifyToFile(people);
            people = parseFromFile();
            people.forEach(System.out::println);
        } catch (JsonProcessingException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
}
