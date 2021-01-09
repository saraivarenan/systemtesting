package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import parametros.ProcessosParametros;
import support.DriverQA;

public class ListaProcessos extends BasePage {
    DetalheProcesso detalheProcesso = new DetalheProcesso(driver);
    ProcessosParametros processosParametros = new ProcessosParametros();

    public ListaProcessos(DriverQA stepDriver) {
        super(stepDriver);
    }

    public void clicarNovo() {
        driver.waitElement("btn-novo");
        driver.click("btn-novo");
    }
    public void clicarProcessoEditar(){
        String code = detalheProcesso.valorCodigoUsuario();
        String elemento = "div[@href='/processos/'"+code+"'/edit']";

        driver.getDriver().findElement(By.cssSelector(elemento)).click();
    }
    public void clicarProcessoExcluir(){

        String code = detalheProcesso.getCode();
        String elemento = "#btn-delete_"+code+" > .ls-btn-primary-danger";
        driver.waitElement(elemento,"css");
        driver.getDriver().findElement(By.cssSelector(elemento)).click();
    }
    public void confirmarAlert(){

      driver.getDriver().switchTo().alert().accept();


    }
    public void validarRegistroNaoExiste(){

        String code = detalheProcesso.getCode();
        driver.waitElement("codigo_"+code+"");
       boolean elementoPresent = driver.getElements("codigo_"+code+"").size() >0;

       System.out.println(code+" "+ elementoPresent);
        Assert.assertEquals(elementoPresent,false);
    }
    public void clicarMostrar(){
        String code = detalheProcesso.getCode();
        driver.waitElement("#btn-show_"+code+" > .ls-btn-primary","css");
        driver.getDriver().findElement(By.cssSelector("#btn-show_"+code+" > .ls-btn-primary")).click();
    }
    public void validarRegistroCriado(){
        String code = detalheProcesso.getCode();
        driver.waitElement("codigo","id");
        driver.waitElement("vara","id");
        try {
            driver.getDriver().findElement(By.id("codigo")).getText();
            Assert.assertEquals(driver.getDriver().findElement(By.id("codigo")).getText(),code);
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            driver.getDriver().findElement(By.id("codigo")).getText();
            Assert.assertEquals(driver.getDriver().findElement(By.id("codigo")).getText(),code);
        }

        try {
            driver.getDriver().findElement(By.id("vara")).getText();
            Assert.assertEquals(driver.getDriver().findElement(By.id("vara")).getText(),processosParametros.getVara());
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            driver.getDriver().findElement(By.id("vara")).getText();
            Assert.assertEquals(driver.getDriver().findElement(By.id("vara")).getText(),processosParametros.getVara());
        }
        try {
            driver.getDriver().findElement(By.id("numero")).getText();
            Assert.assertEquals(driver.getDriver().findElement(By.id("numero")).getText(),processosParametros.getNumeroProcesso());
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            driver.getDriver().findElement(By.id("numero")).getText();
            Assert.assertEquals(driver.getDriver().findElement(By.id("numero")).getText(),processosParametros.getNumeroProcesso());
        }
        try {
            driver.getDriver().findElement(By.id("natureza")).getText();
            Assert.assertEquals(driver.getDriver().findElement(By.id("natureza")).getText(),processosParametros.getNaturezaProcesso());
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            driver.getDriver().findElement(By.id("natureza")).getText();
            Assert.assertEquals(driver.getDriver().findElement(By.id("natureza")).getText(),processosParametros.getNaturezaProcesso());
        }
        try {
            driver.getDriver().findElement(By.id("as_social")).getText();
            Assert.assertEquals(driver.getDriver().findElement(By.id("as_social")).getText(),processosParametros.getAssistenteSocial());
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            driver.getDriver().findElement(By.id("as_social")).getText();
            Assert.assertEquals(driver.getDriver().findElement(By.id("as_social")).getText(),processosParametros.getAssistenteSocial());
        }
        try {
            driver.getDriver().findElement(By.id("status")).getText();
            Assert.assertEquals(driver.getDriver().findElement(By.id("status")).getText(),processosParametros.getStatus());
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            driver.getDriver().findElement(By.id("status")).getText();
            Assert.assertEquals(driver.getDriver().findElement(By.id("status")).getText(),processosParametros.getStatus());
        }
        try {
            driver.getDriver().findElement(By.id("observacao")).getText();
            Assert.assertEquals(driver.getDriver().findElement(By.id("observacao")).getText(),processosParametros.getObservecao());
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            driver.getDriver().findElement(By.id("observacao")).getText();
            Assert.assertEquals(driver.getDriver().findElement(By.id("observacao")).getText(),processosParametros.getObservecao());
        }
    }

}