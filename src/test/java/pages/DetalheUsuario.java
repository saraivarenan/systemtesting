package pages;

import org.openqa.selenium.By;
import support.DriverQA;

public class DetalheUsuario extends BasePage {

    static String code ;

    public  String getCode() {
        return code;
    }
    public  void setCode(String code) {
        DetalheUsuario.code = code;
    }

    public DetalheUsuario(DriverQA stepDriver) {
        super(stepDriver);
    }

    public String getNotice() {
        return driver.getText("notice");
    }

    public void btnVoltar() {
      //  String elemento = "div[@href='/processos/']";
       // driver.getDriver().findElement(By.cssSelector(elemento)).click();
       setCode(valorCodigoUsuario());
        driver.waitElementToBeClickable(".ls-btn-primary-danger","css");
        driver.click(".ls-btn-primary-danger","css");
    }
    public String valorCodigoUsuario(){

        setCode(driver.getText("codigo"));
        return getCode();

    }

}
