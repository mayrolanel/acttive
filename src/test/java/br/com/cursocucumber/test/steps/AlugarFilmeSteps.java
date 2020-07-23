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

	@Given("^que o preço de aluguel seja R\\$ (\\d+)$")
	public void queOPreçoDeAluguelSejaR$(int valorAluguel) throws Throwable {
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

	@Then("^o preço do aluguel será R\\$ (\\d+)$")
	public void oPreçoDoAluguelSeráR$(int precoAluguel) throws Throwable {
		assertEquals(precoAluguel, notaAluguel.getPrecoAluguel());
	}

	@Given("^o estoque do filme será (\\d+) unidade$")
	public void oEstoqueDoFilmeSeráUnidade(int qtdEstoque) throws Throwable {
		assertEquals(qtdEstoque, filme.getEstoque());
	}
	
	@Then("^não será possível por falta de estoque$")
	public void nãoSeráPossívelPorFaltaDeEstoque() throws Throwable {
		assertEquals("Filme sem estoque", erro);
	}
	
	@When("^que o preço de alguel seja R\\$ (\\d+)$")
	public void queOPreçoDeAlguelSejaR$(int precoAluguel) throws Throwable {
		filme.setAluguel(precoAluguel);
	}

	@When("^que o tipo do aluguel seja (.*)$")
	public void queOTipoDoAluguelSejaExtendido(String tipo) throws Throwable {
		tipoAluguel = tipo.equals("comum") ? TipoAluguel.COMUM : tipo.equals("extendido") ? TipoAluguel.EXTENDIDO : TipoAluguel.SEMANAL;
	}

	@When("^a data de entrega será em (\\d+) dias?$")
	public void aDataDeEntregaSeráEmDias(int dia) throws Throwable {
		String dataEsperada = DateUtils.obterDataConvertidaParaString(DateUtils.obterDataDiferencaDias(dia));
		String dataEntrega = DateUtils.obterDataConvertidaParaString(notaAluguel.getDataEntrega());
		
		assertEquals(dataEsperada, dataEntrega);
	}

	@When("^a pontuação recebida será de (\\d+) pontos$")
	public void aPontuaçãoRecebidaSeráDePontos(int pontuacao) throws Throwable {
		assertEquals(pontuacao, notaAluguel.getPontuacao());
	}
}
