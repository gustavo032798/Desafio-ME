package ME.DesafioAutomation.Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CadastroPage extends Base {
	
	private WebDriver driver;
	
	@FindBy(linkText = "Sign in")  	// Busca elemento através do linkText
	private WebElement linkSignIn;	
	
	@FindBy(id = "email_create")	// Busca elemento através do id
	private WebElement inputEmail;
	
	@FindBy(id = "SubmitCreate")
	private WebElement btnCreate;
	
	@FindBy(id = "customer_firstname")
	private WebElement inputNome;
	
	@FindBy(id = "customer_lastname")
	private WebElement inputSobrenome;
	
	@FindBy(id = "passwd")
	private WebElement inputPassword;
	
	@FindBy(id = "address1")
	private WebElement inputAddres;
	
	@FindBy(id = "city")
	private WebElement inputCity;
	
	@FindBy(id = "id_state")
	private WebElement clickState; // Combobox
	
	@FindBy(xpath = "//option[contains(text(),'Colorado')]") // Busca o valor dentro do combobox
	private WebElement inputState;
	
	@FindBy(id = "postcode")
	private WebElement inputPostCode;
	
	@FindBy(id = "phone_mobile")
	private WebElement inputPhone;
	
	@FindBy(id = "submitAccount")
	private WebElement btnRegister;
	
	@FindBy(xpath = "//h1[contains(text(),'My account')]") // Percorre a div até h1
	private WebElement txtMyAccount;
	
	@FindBy(xpath = "//p[contains(text(),'There are 8 errors')]")
	private WebElement validaError;

	public CadastroPage(WebDriver driver) {  // Construtor
		super(driver);
	}
	
	public void ckickSignIn() {
		linkSignIn.click(); 	// Clica no linkText Sign in da pagina principal
	}
	
	public void inputEmailCadastro(String email) {
		inputEmail.sendKeys(email); 	// Digita o email
		btnCreate.click();				// Clica no botão pra cadastrar
	}
	
	public void PrencheFormulario() {
		inputNome.sendKeys("Mercado");				// Digita o nome
		inputSobrenome.sendKeys("Eletronico");		// Digita o sobrenome
		inputPassword.sendKeys("naotemsenha");		// Digita a senha
		inputAddres.sendKeys("Av Paulista, 23");	// Digita o endereço
		inputCity.sendKeys("Sao Paulo");			// Digita a cidade
		clickState.click();							// Clica no combobox pra selecionar o estado
		inputState.click();							// Clica no valor dentro da combobox
		inputPostCode.sendKeys("09340");			// Digita o postal code
		inputPhone.sendKeys("1199999-9999");		// Digita o telefone
	}
	
	public void clickRegister() {
		btnRegister.click();	// Clica no botão pra se registrar
	}
	
	public void validaMyAccount(String myAccount) {
		String pegaTexto = txtMyAccount.getText();
		Assert.assertEquals(myAccount, pegaTexto); // Obtém valor do elemento e valida se é o mesmo do BDD
	}
	
	public void validaErrors(String errors) {
		String pegaTexto = validaError.getText();
		Assert.assertEquals(errors, pegaTexto); // Obtém valor do elemento e valida se é o mesmo do BDD
	}
}
