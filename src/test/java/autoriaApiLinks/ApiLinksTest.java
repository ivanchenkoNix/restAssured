package autoriaApiLinks;

import baseTest.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ApiLinksTest extends BaseTest {


    @DataProvider(name = "endPoints")
    public static Object[][] endPoints() {
        return new Object[][]{{"auto_mitsubishi_lancer_21990745.html"},
                {"auto_toyota_camry_22101863.html"},
                {"auto_bmw_520_21996828.html"},
                {"auto_nissan_leaf_22104675.html"},
                {"auto_nissan_leaf_22104647.html"},
                {"auto_mercedes_benz_e_220_21994701.html"},
                {"auto_lexus_nx_200_22083607.html"}
        };
    }


    @Test(dataProvider = "endPoints" )
    public void linksTest(String endpoint) {
        baseRequestSteps.simpleRequest(endpoint)
                .checkStatusCode(200)
                .checkHeaderEquals("Content-Encoding","gzip")
                .checkHeaderContains("Content-Type","text/html");
    }
}
