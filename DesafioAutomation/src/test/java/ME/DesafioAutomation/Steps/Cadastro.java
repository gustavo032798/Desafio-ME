package ME.DesafioAutomation.Steps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.github.javafaker.Faker;
import ME.DesafioAutomation.Pages.CadastroPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class Cadastro {
	
	WebDriver driver;  // Objeto do Selenium WebDriver
	CadastroPage cadastroPage; // Objeto herdado da classe CadastroPage
	
	@Dado("que acesso a pagina principal, clico em Sign in pra realizar o cadastro")
	public void que_acesso_a_pagina_principal_clico_em_sign_in_pra_realizar_o_cadastro() {
		System.setProperty("webdriver.chrome.driver", "C:/Tools/webdrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php"); // Abrir site
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // Espera implicita de 5 segundos
		
		cadastroPage = new CadastroPage(driver); // Instanciar a classe cadastroPage
		cadastroPage.ckickSignIn();
	}
	
	@E("preencho um novo email")
	public void preencho_um_novo_email() {
		Faker faker = new Faker();  // Gerador de dados fake para que toda execução tenha um novo email
		String firstName = faker.name().firstName();
		cadastroPage.inputEmailCadastro(firstName + "@mercadoeletronico.com"); // Gera um novo nome e inclui @mercadoeletronico.com
	}

	@Quando("preencho o formulario com os campos obrigatorios")
	public void preencho_o_formulario_com_os_campos_obrigatorios() {
		cadastroPage.PrencheFormulario();	// Executa as acões criadas nos metodos da page de cadastro
		cadastroPage.clickRegister();
	}

	@Entao("devo ser redirecionado para a pagina {string}")
	public void devo_ser_redirecionado_para_a_pagina(String myAccount) {
		cadastroPage.validaMyAccount(myAccount);	// Recebe o valor da feature e valida se esta de acordo com o metodo da page
		driver.quit();
	}

	@Quando("tento dar prosseguimento do cadastro sem ter digitado os campos obrigatorios")
	public void tento_dar_prosseguimento_do_cadastro_sem_ter_digitado_os_campos_obrigatorios() {
		cadastroPage.clickRegister();
	}

	@Entao("devo ver o erro: {string}")
	public void devo_ver_o_erro(String error) {
		cadastroPage.validaErrors(error);
		driver.quit();
	}

	@Quando("preencho o campo email com: {string}")
	public void preencho_o_campo_email_com(String email) {
		cadastroPage.inputEmailCadastro(email);	  // Recebe o valor da feature e inclui no elemento declarado no metodo da page
	}
	
	@Entao("devo ver uma mensagem de alerta {string}")
	public void devo_ver_uma_mensagem_de_alerta(String alert) {
		String msgAlert = driver.findElement(By.xpath("//li[contains(text(),'"+alert+"')]")).getText();
		Assert.assertEquals(alert, msgAlert);
		// Validação utilizando Xpath devido ter que percorrer a div até chegar nas li's
		driver.quit();;
	}
}
