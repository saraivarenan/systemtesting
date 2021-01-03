package pages;

import support.DriverQA;
import support.SuportWeb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class NovoProcesso extends BasePage {
    SuportWeb sup = new SuportWeb();

    public NovoProcesso(DriverQA stepDriver) {
        super(stepDriver);
    }

    public void vara(String value) {
        driver.sendKeys(value,"processo_vara");
    }
    public void numeroProcesso(String value) {
        driver.sendKeys(value,"processo_numero_processo");
    }
    public void naturezaProcesso(String value) {

        driver.sendKeys(value,"processo_natureza");
    }
    public void processosPartes(String value) {
        driver.sendKeys(value,"processo_partes");
    }
    public void selectUrgente(String value) {

        driver.selectByText(value,"processo_urgente","id");
    }
    public void selecionarRadioButton()
    {
      driver.click("processo_arbitramento_s");
    }
    public void assistenciaSocial(String value) {
        driver.sendKeys(value,"processo_assistente_social");
    }
    public void dataEntrada() {
        sup.tempo(2);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        driver.sendKeys(dtf.format(now),"processo_data_entrada");
    }
    public void dataSaida(String value) throws ParseException {
//        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
//        String result = out.format(value);
        driver.sendKeys(value,"processo_data_saida");
    }
    public void dataAgendamento(String value) {
        driver.sendKeys(value,"processo_data_agendamento");
    }
    public void Status(String value) {
        driver.sendKeys(value,"processo_status");
    }
    public void observacao(String value) {
        driver.sendKeys(value,"processo_observacao");
    }
    public void clicarSalvar(){
        driver.click("btn-save");
    }



}
