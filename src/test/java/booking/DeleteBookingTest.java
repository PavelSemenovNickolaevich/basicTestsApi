package booking;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DeleteBookingTest extends BaseTest {

    @Test
    public void deleteBooking() {
        Response responseCreate = createBooking();
        int id = responseCreate.jsonPath().getInt("bookingid");
        specification.pathParam("bookingid", id);
        Response response = RestAssured.given(specification).delete("/booking/{bookingid}");
        response.print();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), 201, "Status code should be 201, but it's not");


    }

}
