package booking;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GetBookingTest extends BaseTest {

    @Test
    public void getBooking() {
        Response responseCreate = createBooking();
        int id = responseCreate.jsonPath().getInt("bookingid");
        specification.pathParam("bookingid", id);
        Response response = RestAssured.given(specification).get("/booking/{bookingid}");
        response.print();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), 200, "Status code should be 200, but it's not");

        String actualFirstName = response.jsonPath().getString("booking.firstname");
        softAssert.assertEquals(actualFirstName, "QAQAQA", "firstname in response is not expected");

        String actualLastname = response.jsonPath().getString("booking.lastname");
        softAssert.assertEquals(actualLastname, "PSB", "lastname in response is not expected");

    }
}
