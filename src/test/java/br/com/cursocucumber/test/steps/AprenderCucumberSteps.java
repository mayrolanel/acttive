package br.com.cursocucumber.test.steps;
import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import br.com.cursocucumber.test.utils.DataConverterString;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AprenderCucumberSteps {

	private int contador = 0;
	private Date dataEntrega = new Date();
	
	@When("^que criei o arquivo corretamente$")
	public void queCrieiOArquivoCorretamente() throws Throwable {
	}

	@Given("^executa-lo$")
	public void executaLo() throws Throwable {
	}

	@Then("^a especificacao deve finalizar com sucesso$")
	public void aEspecificacaooDeveFinalizarComSucesso() throws Throwable {
	}

	@When("^que o valor do contador e (\\d+)$")
	public void queOValorDoContadorE(int contador) throws Throwable {
		this.contador = contador;
		assertEquals(contador, this.contador);
	}

	@Given("^eu incrementar em (\\d+)$")
	public void euIncrementarEm(int valor) throws Throwable {
		this.contador += valor;
	}

	@Then("^o valor do contador sera (\\d+)$")
	public void oValorDoContadorSera(int contador) throws Throwable {
		assertEquals(contador, this.contador);
	}
	
	@When("que o prazo e dia {data}")
	public void queOPrazoEDia(Date data) throws Throwable {
		dataEntrega = data;
		
		System.out.println("DATA ENTREGA- "+dataEntrega);
	}

	@Given("^a entrega atrasar em (\\d+) (dia|dias|mes|meses)$")
	public void aEntregaAtrasarEmDias(int diaOuMes, String tempo) throws Throwable {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dataEntrega);
		
		if(tempo.equals("dias")) {
			calendar.add(Calendar.DAY_OF_MONTH, diaOuMes);	
		}else {
			calendar.add(Calendar.MONTH, diaOuMes);
		}
		
		dataEntrega = calendar.getTime();
	}

	@Then("a entrega sera efetuada em {data}")
	public void aEntregaSeraEfetuada_em(Date data) throws Throwable {
		String dataEntregaFormatada = DataConverterString.converteDataParaString(dataEntrega);
		String dataParametroFormatada = DataConverterString.converteDataParaString(data);
		
		assertEquals(dataParametroFormatada, dataEntregaFormatada);
	}
	
	@When("^que o ticket( especial)? e (A.\\d{3})$")
	public void queOTicketEAF(String especial, String ticket) throws Throwable {
	}

	@When("^que o valor da passagem e R\\$ (.*)$")
	public void queOValorDaPassagemER$(Double numero) throws Throwable {
	}

	@When("^que o nome do passageiro e \"(.{5,20})\"$")
	public void queONomeDoPassageiroE(String arg1) throws Throwable {
	}

	@When("^que o telefone do passageiro e (9\\d{3}-\\d{4})$")
	public void queOTelefoneDoPassageiroE(String telefone) throws Throwable {
	}

	@Given("^criar os steps$")
	public void criarOsSteps() throws Throwable {
	}

	@Then("^o teste vai funcionar$")
	public void oTesteVaiFuncionar() throws Throwable {
	}
}