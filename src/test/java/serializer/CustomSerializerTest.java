package serializer;

import classes.Cat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CustomSerializerTest {

    private Cat cat;
    private String testJsonString;

    @BeforeEach
    void setUp() {
        cat = new Cat();
        cat.setName("Olongbo");
        cat.setAge(10);
        cat.setColor("black");

        testJsonString = "{\"name\":\"Olongbo\",\"age\":10,\"color\":\"black\",\"dateOfBirth\":null}";
    }

    @Test
    void testObjectWriteCatToJson(){
    String catAsJson = CustomSerializer.catToJson(cat);
    assertEquals(testJsonString, catAsJson);

    }

    @Test
    void testReadFromJsonToCat(){
        Cat catDeserializedFromJsonString = CustomSerializer.jsonToCat(testJsonString);
        assertNotNull(catDeserializedFromJsonString);
        assertEquals(cat, catDeserializedFromJsonString);
        assertEquals("Olongbo", catDeserializedFromJsonString.getName());
    }

    @Test
    void testSerializeCatWithADateOfBirth(){
        cat.setDateOfBirth(LocalDateTime.now());
        String catInJson = CustomSerializer.catToJson(cat);
        assertNotNull(catInJson);
    }
}