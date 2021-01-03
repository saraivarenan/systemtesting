package parametros;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class ProcessosParametros {
    String vara = "01";
    String numeroProcesso = "0123365";
    String naturezaProcesso = "natureza_lacasa";
    String partesProcesso = "Renan Elias - Thiago Keller";
    String assistenteSocial = "System testing - Lacasa";
    String dataEntrada = null;
    String  dataSaida = null;
    String dataAgendamento = null;
    String Status = "andamento-lacasa";
    String observecao = "Trabalho de automação WEB";

    public String getObservecao() {
        return observecao;
    }

    public void setObservecao(String observecao) {
        this.observecao = observecao;
    }

    public String getVara() {
        return vara;
    }

    public void setVara(String vara) {
        this.vara = vara;
    }

    public String getNumeroProcesso() {
        return numeroProcesso;
    }

    public void setNumeroProcesso(String numeroProcesso) {

        this.numeroProcesso = numeroProcesso;
    }

    public String getNaturezaProcesso() {
        return naturezaProcesso;
    }

    public void setNaturezaProcesso(String naturezaProcesso) {
        this.naturezaProcesso = naturezaProcesso;
    }

    public String getPartesProcesso() {
        return partesProcesso;
    }

    public void setPartesProcesso(String partesProcesso) {
        this.partesProcesso = partesProcesso;
    }

    public String getAssistenteSocial() {
        return assistenteSocial;
    }

    public void setAssistenteSocial(String assistenteSocial) {
        this.assistenteSocial = assistenteSocial;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        dataEntrada = dtf.format(now);
        this.dataEntrada = dataEntrada;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) throws ParseException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();

        String dt = dtf.format(now);


        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(dt));
        c.add(Calendar.DATE,30 );  // número de dias a adicionar
        dt = sdf.format(c.getTime());
        System.out.println("data"+dt);
        dataSaida = dt;
        this.dataSaida = dataSaida;
    }

    public String getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(String dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
