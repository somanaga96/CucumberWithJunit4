import com.example.generated.todo.ToDoResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class RadarAssert {

    @Test
    public void getToDo() throws JsonProcessingException {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        ResponseBody body = RestAssured.given().log().all().get("/todos").getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        List<ToDoResponse> toDoResponse = objectMapper.readValue(body.asString(), new TypeReference<List<ToDoResponse>>() {
        });
        List<ToDoResponse> collect = toDoResponse.stream().filter(x -> x.getId().equals(1)).collect(Collectors.toList());
        System.out.println(collect);
    }
}
