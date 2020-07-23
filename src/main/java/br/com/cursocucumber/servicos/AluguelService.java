package br.com.cursocucumber.servicos;

import java.util.Date;

import br.com.cursocucumber.domain.Filme;
import br.com.cursocucumber.domain.NotaAluguel;
import br.com.cursocucumber.utils.DateUtils;
import br.com.cursocucumber.utils.TipoAluguel;

public class AluguelService {
	private NotaAluguel nota;

	public AluguelService() {
		nota = new NotaAluguel();
	}

	public NotaAluguel alugar(Filme filme, TipoAluguel tipoAluguel) {
		if (filme.getEstoque() == 0)
			throw new RuntimeException("Filme sem estoque");

		switch (tipoAluguel) {
		case COMUM:
			preencheNota(filme.getAluguel(), DateUtils.obterDataDiferencaDias(1), 1);
			break;
		case EXTENDIDO:
			preencheNota(filme.getAluguel() * 2, DateUtils.obterDataDiferencaDias(3), 2);
			break;
		case SEMANAL:
			preencheNota(filme.getAluguel() * 3, DateUtils.obterDataDiferencaDias(7), 3);
			break;
		default:
			break;
		}

		filme.setEstoque((filme.getEstoque() - 1));

		return nota;
	}

	private NotaAluguel preencheNota(int alugual, Date data, int pontuacao) {
		nota.setPrecoAluguel(alugual);
		nota.setDataEntrega(data);
		nota.setPontuacao(pontuacao);

		return nota;
	}
}
