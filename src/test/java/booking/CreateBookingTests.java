package booking;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateBookingTests extends BaseTest {

    @Test
    public void createBookingTests() {

        Response response = createBooking();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), 200, "Status code should be 200, but it's not");

        String actualFirstName = response.jsonPath().getString("booking.firstname");
        softAssert.assertEquals(actualFirstName, "QAQAQA", "firstname in response is not expected");

        String actualLastname = response.jsonPath().getString("booking.lastname");
        softAssert.assertEquals(actualLastname, "PSB", "lastname in response is not expected");

        int price = response.jsonPath().getInt("booking.totalprice");
        softAssert.assertEquals(price, 1000000, "totalprice in response is not expected");

        boolean depositpaid = response.jsonPath().getBoolean("booking.depositpaid");
        softAssert.assertFalse(depositpaid, "depositpaid should be false, but its not");

        String actualCheckin = response.jsonPath().getString("bookingdates.checkin");
        softAssert.assertEquals(actualCheckin, "2020-03-25", "checkin in response is not expected");

        String actualCheckout = response.jsonPath().getString("bookingdates.checkout");
        softAssert.assertEquals(actualCheckout, "2020-03-27", "checkout in response is not expected");

        String actualAdditionalneeds = response.jsonPath().getString("booking.additionalneeds");
        softAssert.assertEquals(actualAdditionalneeds, "Salary", "additionalneeds in response is not expected");
        response.print();

    }

}
