package support;

import java.net.MalformedURLException;

public class BaseSteps {

    protected static DriverQA driver = new DriverQA();

    public BaseSteps() throws MalformedURLException {
        driver.start("chrome");
//        driver.start("firefox");
    }

}
