package pages;

import support.DriverQA;

public class DetalheProcesso extends BasePage {

    static String code ;

    public  String getCode() {
        return code;
    }
    public  void setCode(String code) {
        DetalheProcesso.code = code;
    }

    public DetalheProcesso(DriverQA stepDriver) {
        super(stepDriver);
    }

    public String getNotice() {
        boolean elementoPresent = driver.getElements("notice").size() >0;

        if (elementoPresent == true) {
            driver.waitElement("notice");
            return driver.getText("notice");
        }else {

            return driver.getText(".ls-alert-danger", "css");
        }
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
    public void btnEditar(){
        driver.waitElementToBeClickable(".ls-btn-primary-danger","css");
        driver.click(".ls-btn","css");
    }
    public void validarProcessoAtualizado(String mensagem){


    }

}
