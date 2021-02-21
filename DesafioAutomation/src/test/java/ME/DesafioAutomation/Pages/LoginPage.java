package ME.DesafioAutomation.Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Base {
	
	private WebDriver driver;
	
	@FindBy(linkText = "Sign in")		// Busca elemento através do linkText
	private WebElement linkSignIn;
	
	@FindBy(id = "email")				// Busca elemento através do id
	private WebElement inputEmail;
	
	@FindBy(id = "passwd")
	private WebElement inputPass;
	
	@FindBy(id = "SubmitLogin")
	private WebElement btnSignIn;
	
	@FindBy(className = "account")		// Busca elemento através da class
	private WebElement userLog;
	
	@FindBy(xpath = "//div[@id='center_column']/div/ol/li") // Percorre a div até chegar nas li
	private WebElement errorAlert;

	public LoginPage(WebDriver driver) {   // Construtor
		super(driver);
	}

	public void caminhoLogin() {
		linkSignIn.click();
	}
	
	public void inputEmailSenha(String email, String senha) {
		inputEmail.sendKeys(email);	// Digita email
		inputPass.sendKeys(senha);  // Digita senha
		btnSignIn.click();			// Clica botão pra realizar o login
	}
	
	public void validaUsuarioLogado(String nome) {
		String nameUser = userLog.getText();
		Assert.assertEquals(nome, nameUser); // Obtém valor da class e valida se é o mesmo do BDD
	}
	
	public void validaMensagemErro(String alert) {
		String msgAlert = errorAlert.getText(); 
		Assert.assertEquals(alert, msgAlert); // Obtém valor da li e valida se é o mesmo do BDD
	}
}
