package ME.DesafioAutomation.Steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ME.DesafioAutomation.Pages.LoginPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class Login {
	
	WebDriver driver;  // Objeto do Selenium WebDriver
	LoginPage loginPage;  // Objeto herdado da classe LoginPage

	@Dado("que acesso a pagina principal, clico em Sign in pra realizar o login")
	public void que_acesso_a_pagina_principal_clico_em_sign_in_pra_realizar_o_login() {
		System.setProperty("webdriver.chrome.driver", "C:/Tools/webdrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");  // Abrir site
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // Espera implicita de 5 segundos
		
		loginPage = new LoginPage(driver); // Instanciar a classe LoginPage
		loginPage.caminhoLogin();
	}

	@Quando("submeto minhas credenciais com {string} e {string}")
	public void submeto_minhas_credenciais_com_e(String email, String password) {
		loginPage.inputEmailSenha(email, password);  // Recebe os dados da feature e insere nos elementos dos metodos da page
	}

	@Entao("devo ver o meu nome {string} como usuario logado")
	public void devo_ver_o_meu_nome_como_usuario_logado(String user) {
	   loginPage.validaUsuarioLogado(user);
	   driver.quit();
	}

	@Entao("vejo a mensagem de erro: {string}")
	public void vejo_a_mensagem_de_erro(String error) {
		loginPage.validaMensagemErro(error);
		driver.quit();
	}
}
