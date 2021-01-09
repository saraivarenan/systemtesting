package pages;

import parametros.ProcessosParametros;
import support.DriverQA;
import support.SuportWeb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class NovoProcesso extends BasePage {
    SuportWeb sup = new SuportWeb();
    ProcessosParametros parametrosProc = new ProcessosParametros();

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
    public void dataEntrada(String value) {
        sup.tempo(2);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        driver.sendKeys(value,"processo_data_entrada");

    }
    public void dataSaida(String value) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        Date today = new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTime(today);
        cal.add(Calendar.DAY_OF_MONTH,+30);
        Date today30 = cal.getTime();
        //value =
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
