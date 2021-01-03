package pages;

import gherkin.lexer.De;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import parametros.ProcessosParametros;
import support.DriverQA;

public class ListaProcessos extends BasePage {
    DetalheUsuario detalheUsuario = new DetalheUsuario(driver);
    ProcessosParametros processosParametros = new ProcessosParametros();

    public ListaProcessos(DriverQA stepDriver) {
        super(stepDriver);
    }

    public void clicarNovo() {
        driver.waitElement("btn-novo");
        driver.click("btn-novo");
    }
    public void clicarProcessoEditar(){
        String code =detalheUsuario.valorCodigoUsuario();
        String elemento = "div[@href='/processos/'"+code+"'/edit']";

        driver.getDriver().findElement(By.cssSelector(elemento)).click();
    }
    public void clicarProcessoExcluir(){

        String code = detalheUsuario.getCode();
        String elemento = "#btn-delete_"+code+" > .ls-btn-primary-danger";
        driver.waitElement(elemento,"css");
        driver.getDriver().findElement(By.cssSelector(elemento)).click();
    }
    public void confirmarAlert(){

      driver.getDriver().switchTo().alert().accept();


    }
    public void validarRegistroNaoExiste(){

        String code = detalheUsuario.getCode();
       boolean elementoPresent = driver.getElements("codigo_"+code+"").size() >0;

       System.out.println(code+" "+ elementoPresent);
        Assert.assertEquals(elementoPresent,false);
    }
    public void clicarMostrar(){
        String code = detalheUsuario.getCode();
        driver.getDriver().findElement(By.cssSelector("#btn-show_"+code+" > .ls-btn-primary")).click();
    }
    public void validarRegistroCriado(){
        String code = detalheUsuario.getCode();
        driver.waitElement("codigo","id");
System.out.println("codigo"+driver.getDriver().findElement(By.id("codigo")).getText());
       Assert.assertEquals(driver.getDriver().findElement(By.id("codigo")).getText(),code);
        Assert.assertEquals( driver.getDriver().findElement(By.id("vara")).getText(),processosParametros.getVara());
        Assert.assertEquals(driver.getDriver().findElement(By.id("numero")).getText(),processosParametros.getNumeroProcesso());
        Assert.assertEquals(driver.getDriver().findElement(By.id("natureza")).getText(),processosParametros.getNaturezaProcesso());
       // Assert.assertEquals(driver.getDriver().findElement(By.id("urgente")).getText(),"");
       // Assert.assertEquals(driver.getDriver().findElement(By.id("arbitramento")).getText(),"");
        Assert.assertEquals(driver.getDriver().findElement(By.id("as_social")).getText(),processosParametros.getAssistenteSocial());
       // Assert.assertEquals(driver.getDriver().findElement(By.id("dt_entrada")).getText(),processosParametros.);
        Assert.assertEquals(driver.getDriver().findElement(By.id("status")).getText(),processosParametros.getStatus());
        Assert.assertEquals(driver.getDriver().findElement(By.id("observacao")).getText(),processosParametros.getObservecao());


    }

}