package steps;

import cucumber.api.java.pt.*;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.security.Credentials;
import pages.*;
import parametros.ProcessosParametros;
import support.BaseSteps;

import java.text.ParseException;

public class UserSteps extends BaseSteps {
    private HomePage homePage = new HomePage(driver);
    private MenuImpacta menuImpacta = new MenuImpacta(driver);
    private ListaProcessos listaProcesso = new ListaProcessos(driver);
    private NovoProcesso novoProcesso = new NovoProcesso(driver);
    private DetalheUsuario detalheUsuario = new DetalheUsuario(driver);
    private ProcessosParametros processoParametros = new ProcessosParametros();

    @Dado("^que o usuário está na pagina inicial$")
    public void queOUsuárioEstáNaPaginaInicial() {
        homePage.open();
    }

    @E("^que o usuario clica no menu Processos$")
    public void queOUsuarioClicaNoMenuUsuários() {
    menuImpacta.clicarProcessos();
    }

    @E("^o usuario clica no botão Novo$")
    public void oUsuarioClicaNoBotãoNovoUsuário() {
        listaProcesso.clicarNovo();
    }

    @E("^o usuário preencha os campos obrigatórios$")
    public void oUsuárioPreenchaOsCamposObrigatórios() throws ParseException {
        novoProcesso.vara(processoParametros.getVara());
        novoProcesso.numeroProcesso(processoParametros.getNumeroProcesso());
        novoProcesso.naturezaProcesso(processoParametros.getNaturezaProcesso());
        novoProcesso.processosPartes(processoParametros.getPartesProcesso());
        novoProcesso.selectUrgente("Sim");
        novoProcesso.selecionarRadioButton();
        novoProcesso.assistenciaSocial(processoParametros.getAssistenteSocial());
        novoProcesso.dataEntrada();
        novoProcesso.dataSaida(processoParametros.getDataSaida());
        novoProcesso.dataAgendamento("01/02/2021");
        novoProcesso.Status(processoParametros.getStatus());
        novoProcesso.observacao(processoParametros.getObservecao());


    }

    @Quando("^o usuário clicar no botão salvar$")
    public void oUsuárioClicarNoBotãoSalvar() {
        novoProcesso.clicarSalvar();
    }

    @Entao("^o usuario deveria ver a mensagem \"([^\"]*)\"$")
    public void oUsuarioDeveriaVerAMensagem(String mensagem) {
        System.out.println(detalheUsuario.getNotice());
        Assert.assertEquals(mensagem, detalheUsuario.getNotice());
    }

    @E("^o usuário clicar em salvar$")
    public void oUsuárioClicarEmSalvar() {
        //novoUsuario.btnSalvar();
    }

    @E("^clicar em voltar$")
    public void oUsuárioClicaNoBotãoVoltar() {

        detalheUsuario.btnVoltar();
    }

    @E("^o usuário clica no botão editar do usuário$")
    public void oUsuárioClicaNoBotãoEditarDoUsuário() {
        listaProcesso.clicarProcessoEditar();

    }

    @E("^o usuário edita o campo Login do usuário$")
    public void oUsuárioEditaOCampoLoginDoUsuário() {
    }
    @E("^criado um processo \"([^\"]*)\"$")
    public void processoCriadoComSucesso(String mensagem){
        System.out.println(detalheUsuario.getNotice());
        Assert.assertEquals(mensagem, detalheUsuario.getNotice());
    }
    @E("^o usuario clicar em excluir no registro criado$")
    public void oUsuarioClicaExcluir() {
        listaProcesso.clicarProcessoExcluir();

    }
    @E("^clicar em confirmar na mensagem de deletar$")
    public void confirmarAlert(){
    listaProcesso.confirmarAlert();
    }
    @E("^clicar em Mostrar no registro criado$")
    public void clicarMostrar(){
        listaProcesso.clicarMostrar();
    }

    @Entao("^o registro não dever ser apresentado na lista de processo$")
    public void registroNaoExiste (){
        listaProcesso.validarRegistroNaoExiste();

    }
    @Quando("^o usuário clica no botão salvar na tela de edição$")
    public void oUsuárioClicaNoBotãoSalvarNaTelaDeEdição() {
    }

    @Então("^o usuário deveria ver o valor editado no campo login$")
    public void oUsuárioDeveriaVerOValorEditadoNoCampoLogin() {
    }

    @Entao("^Deve ser apresentado o registro criado$")
    public void registroApresentadoComSucesso() {
        listaProcesso.validarRegistroCriado();
    }

}
