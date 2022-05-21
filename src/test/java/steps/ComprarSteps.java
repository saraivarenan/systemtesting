package steps;

import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pages.PageCarrinho;
import pages.PageDetalheProduto;
import pages.PageHome;
import pages.PageLogin;
import support.BaseSteps;
import support.SuportWeb;

import java.net.MalformedURLException;

public class ComprarSteps extends BaseSteps {
    PageHome pageHome = new PageHome(driver);
    PageLogin pageLogin = new PageLogin(driver);
    PageDetalheProduto pageDetalheProduto= new PageDetalheProduto(driver);
    PageCarrinho pageCarrinho = new PageCarrinho(driver);
    SuportWeb suportWeb = new SuportWeb();

    public ComprarSteps() throws MalformedURLException {
    }

    @Dado("^o usuário acessou o sistema$")
    public void queOUsuárioEstáNaPaginaInicial() { pageHome.acessarSistema();
    }

    @E("^Logou no sistema$")
    public void logouNoSistema() {
        pageHome.clicarLogar();
        pageLogin.inserirUsuario();

    }

    @Quando("^escolher o produto com valor \"([^\"]*)\"$")
    public void escolherOProdutoComValor(String produto) throws Throwable {
     pageHome.escolherProduto(produto);
        pageDetalheProduto.clicarComprar();

    }

    @E("^calcular o cep \"([^\"]*)\"$")
    public void calcularOCep(String cep) throws Throwable {
        pageCarrinho.CalcularCep(cep);
    }

    @E("^aplicar o cupom \"([^\"]*)\"$")
    public void aplicarOCupom(String cupom) throws Throwable {
        pageCarrinho.aplicarCupom(cupom);
        suportWeb.tempo(3);
    }


    @Entao("^o valor total do produto deve ser \"([^\"]*)\"$")
    public void oValorTotalDoProdutoDeveSer(String valorProduto)  {
        pageCarrinho.validarValorTotal(valorProduto);

    }

    @E("^clicar em finalizar compra$")
    public void clicarEmFinalizarCompra() {
        pageCarrinho.clicarFinalizarCompra();
    }
}
