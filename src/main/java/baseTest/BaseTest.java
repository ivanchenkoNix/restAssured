package baseTest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import steps.BaseRequestSteps;

public class BaseTest {

    private RequestSpecification spec;
    private static final String PROJECT_URL = "https://auto.ria.com";
    public BaseRequestSteps baseRequestSteps;

    @BeforeClass
    public void initSpec(){

        spec = new RequestSpecBuilder()
                .setBaseUri(PROJECT_URL)
                .build();
        baseRequestSteps = new BaseRequestSteps(spec);

    }

}
