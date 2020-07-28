package br.com.cursocucumber.test.steps;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InserirContasSteps {

	private WebDriver driver;
	
	@When("^que estou acessando a aplicação$")
	public void queEstouAcessandoAAplicação() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://srbarriga.herokuapp.com");
	}

	@Given("^informo o usuário \"([^\"]*)\"$")
	public void informoOUsuário(String usuarioAcesso) throws Throwable {
		driver.findElement(By.id("email")).sendKeys(usuarioAcesso);;
	}

	@Given("^a senha \"([^\"]*)\"$")
	public void aSenha(String senha) throws Throwable {
		driver.findElement(By.id("senha")).sendKeys(senha);
	}

	@Given("^seleciono entrar$")
	public void selecionoEntrar() throws Throwable {
		driver.findElement(By.tagName("button")).click();
	}

	@Then("^visualizo a página inicial$")
	public void visualizoAPáginaInicial() throws Throwable {
		String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		
		assertEquals("Bem vindo, renato!", texto);
	}

	@Given("^seleciono Contas$")
	public void selecionoContas() throws Throwable {
		driver.findElement(By.linkText("Contas")).click();
	}

	@Given("^seleciono Adicionar$")
	public void selecionoAdicionar() throws Throwable {
		driver.findElement(By.linkText("Adicionar")).click();
	}

	@Given("^informo a conta \"([^\"]*)\"$")
	public void informoAConta(String conta) throws Throwable {
		driver.findElement(By.id("nome")).sendKeys(conta);
	}

	@Given("^seleciono Salvar$")
	public void selecionoSalvar() throws Throwable {
		driver.findElement(By.tagName("button")).click();
	}

	@Then("^a conta é inserida com sucesso$")
	public void aContaÉInseridaComSucesso() throws Throwable {
		String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		
		assertEquals("Conta adicionada com sucesso!", texto);
	}
	
	@Then("^sou notificado que o nome da conta é obrigatório$")
	public void souNotificadoQueONomeDaContaÉObrigatório() throws Throwable {
		String texto = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
		
		assertEquals("Informe o nome da conta", texto);
	}
	
	@Then("^sou notificado que já existe uma conta com esse nome$")
	public void souNotificadoQueJáExisteUmaContaComEsseNome() throws Throwable {
		String texto = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
		
		assertEquals("Já existe uma conta com esse nome!", texto);
	}
	
	@Then("^recebo a mensagem \"([^\"]*)\"$")
	public void receboAMensagem(String mensagem) throws Throwable {
		String texto = driver.findElement(By.xpath("//div[starts-with(@class, 'alert alert-')]")).getText();
		
		assertEquals(mensagem, texto);
	}
	
	@After(order = 1, value = "@funcionais")
	public void screenshot(Scenario cenario) {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(file, new File("target/screenshot/"+cenario.getId()+".jpg"));
		} catch (IOException e) {
		}
	}
	
	@After(order = 0, value = "@funcionais")
	public void closeBrowser() {
		driver.quit();
	}
}