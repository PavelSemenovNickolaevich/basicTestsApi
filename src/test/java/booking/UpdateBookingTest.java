package booking;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UpdateBookingTest extends BaseTest {

    @Test
    public void updateBookingTest() {
        Response responseCreate = createBooking();

        int bookingid = responseCreate.jsonPath().getInt("bookingid");

        JSONObject body = new JSONObject();
        body.put("firstname", "Test2");
        body.put("lastname", "Test2");
        body.put("totalprice", 1111111);
        body.put("depositpaid", true);

        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin", "2020-03-25");
        bookingdates.put("checkout", "2020-03-27");
        body.put("bookingdates", bookingdates);
        body.put("additionalneeds", "TESTETSTET");

        Response responseUpdate = RestAssured.given(specification).auth().preemptive().basic("admin", "password123").contentType(ContentType.JSON).body(body.toString())
                .put("/booking/" + bookingid);
        responseUpdate.print();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(responseUpdate.getStatusCode(), 200, "Status code should be 200, but it's not");

        String actualFirstName = responseUpdate.jsonPath().getString("booking.firstname");
        softAssert.assertEquals(actualFirstName, "Test2", "firstname in response is not expected");

    }

}
