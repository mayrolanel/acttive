package br.com.cursocucumber.test.steps;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import br.com.cursocucumber.domain.Filme;
import br.com.cursocucumber.domain.NotaAluguel;
import br.com.cursocucumber.servicos.AluguelService;
import br.com.cursocucumber.utils.DateUtils;
import br.com.cursocucumber.utils.TipoAluguel;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AlugarFilmeSteps {

	private Filme filme;
	private AluguelService aluguelService = new AluguelService();
	private NotaAluguel notaAluguel;
	private String erro;
	private TipoAluguel tipoAluguel;
	
	@When("^um filme com estoque de (\\d+) unidades$")
	public void umFilmeComEstoqueDeUnidades(int qtdEstoque) throws Throwable {
		filme = new Filme();
		filme.setEstoque(qtdEstoque);
	}

	@Given("^que o preco de aluguel seja R\\$ (\\d+)$")
	public void queOPrecoDeAluguelSejaR$(int valorAluguel) throws Throwable {
		filme.setAluguel(valorAluguel);
	}

	@When("^um filme$")
	public void umFilme(DataTable tabela) throws Throwable {
		Map<String,String> map = tabela.asMap(String.class, String.class);
		filme = new Filme();
		filme.setEstoque(Integer.parseInt(map.get("estoque")));
		filme.setAluguel(Integer.parseInt(map.get("preco")));
		String tipo = map.get("tipo");
		tipoAluguel = tipo.equals("comum") ? TipoAluguel.COMUM : tipo.equals("extendido") ? TipoAluguel.EXTENDIDO : TipoAluguel.SEMANAL;
	}
	
	@When("^alugar$")
	public void alugar() throws Throwable {
		try {
			notaAluguel = aluguelService.alugar(filme, tipoAluguel);	
		} catch (RuntimeException e) {
			erro = e.getMessage();
		}
	}

	@Then("^o preco do aluguel sera R\\$ (\\d+)$")
	public void oPrecoDoAluguelSeraR$(int precoAluguel) throws Throwable {
		assertEquals(precoAluguel, notaAluguel.getPrecoAluguel());
	}

	@Given("^o estoque do filme sera (\\d+) unidade$")
	public void oEstoqueDoFilmeSeraUnidade(int qtdEstoque) throws Throwable {
		assertEquals(qtdEstoque, filme.getEstoque());
	}
	
	@Then("^não sera possivel por falta de estoque$")
	public void nãoSeraPossivelPorFaltaDeEstoque() throws Throwable {
		assertEquals("Filme sem estoque", erro);
	}
	
	@When("^que o preco de alguel seja R\\$ (\\d+)$")
	public void queOPrecoDeAlguelSejaR$(int precoAluguel) throws Throwable {
		filme.setAluguel(precoAluguel);
	}

	@When("^que o tipo do aluguel seja (.*)$")
	public void queOTipoDoAluguelSejaExtendido(String tipo) throws Throwable {
		tipoAluguel = tipo.equals("comum") ? TipoAluguel.COMUM : tipo.equals("extendido") ? TipoAluguel.EXTENDIDO : TipoAluguel.SEMANAL;
	}

	@When("^a data de entrega sera em (\\d+) dias?$")
	public void aDataDeEntregaSeraEmDias(int dia) throws Throwable {
		String dataEsperada = DateUtils.obterDataConvertidaParaString(DateUtils.obterDataDiferencaDias(dia));
		String dataEntrega = DateUtils.obterDataConvertidaParaString(notaAluguel.getDataEntrega());
		
		assertEquals(dataEsperada, dataEntrega);
	}

	@When("^a pontuacao recebida sera de (\\d+) pontos$")
	public void aPontuacaoRecebidaSeraDePontos(int pontuacao) throws Throwable {
		assertEquals(pontuacao, notaAluguel.getPontuacao());
	}
}
