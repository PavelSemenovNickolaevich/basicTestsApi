package petstore;

import com.pet.UtilsMethods;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddNewPetTest extends UtilsMethods{

    private final String ADD_PET_URI = "https://petstore.swagger.io/v2/pet";

    @Test
    public void addPetTest() {
        Response response = addPet(ADD_PET_URI);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(response.getStatusCode(), 200, "Status code should be 200, but it's not");
        response.print();
    }

}
