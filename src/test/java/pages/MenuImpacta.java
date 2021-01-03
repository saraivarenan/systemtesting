package pages;

import support.DriverQA;
import support.SuportWeb;

public class MenuImpacta extends BasePage {
    SuportWeb util = new SuportWeb();

    public MenuImpacta (DriverQA stepDriver) {
        super(stepDriver);
    }


    public void clicarProcessos() {
        util.tempo(5);
        driver.click("processos");

    }
}
