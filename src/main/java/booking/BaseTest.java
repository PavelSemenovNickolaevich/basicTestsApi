package booking;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;


public class BaseTest {

    protected RequestSpecification specification;

    @BeforeMethod
    public void setUp() {
        specification = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();

    }

    protected Response createBooking() {
        JSONObject body = new JSONObject();
        body.put("firstname", "QAQAQA");
        body.put("lastname", "PSB");
        body.put("totalprice", 1000000);
        body.put("depositpaid", false);
        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin", "2020-03-25");
        bookingdates.put("checkout", "2020-03-27");
        body.put("bookingdates", bookingdates);
        body.put("additionalneeds", "Salary");

        return RestAssured.given(specification).contentType(ContentType.JSON).body(body.toString())
                .post("/booking");
    }


}
