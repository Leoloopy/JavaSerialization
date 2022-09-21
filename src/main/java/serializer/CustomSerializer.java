package serializer;

import classes.Cat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.text.SimpleDateFormat;
import java.util.logging.Logger;

public class CustomSerializer {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final Logger log = Logger.getAnonymousLogger();


    public static String catToJson(Cat cat) {
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        objectMapper.registerModule(new JavaTimeModule());

        try {
           String catAsJson = objectMapper.writeValueAsString(cat);
           log.info(catAsJson);
           return catAsJson;
        } catch (JsonProcessingException e) {
           e.printStackTrace();
        }
        return null;
    }

    public static Cat jsonToCat(String testJsonString) {

        try {
            Cat cat = objectMapper.readValue(testJsonString, Cat.class);
            return cat;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
