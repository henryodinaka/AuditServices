package jumia.pay.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonBuilder {
    public JsonBuilder() {
    }

    public static String generateJson(Object object) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(object);
//        ObjectMapper objectMapper = new ObjectMapper();
//        JsonNode jsonNode = objectMapper.valueToTree(object);
        return s;
    }
}