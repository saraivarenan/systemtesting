package pages;

import org.openqa.selenium.By;
import support.DriverQA;

import java.sql.Driver;

public class AtualizarPage extends BasePage {
    public AtualizarPage(DriverQA stepDriver) {
        super(stepDriver);
    }

        public void btnSalvar(){
driver.click("btn-save");
        }

        public void atualizarVara(String vara){
        driver.sendKeys(vara,"processo_vara");
        }
    public void preencherCampo (String valorcampo, String elemento){
        driver.waitElement(elemento);
        driver.getDriver().findElement(By.id(elemento)).clear();
        driver.sendKeys(valorcampo,elemento);
    }


}
