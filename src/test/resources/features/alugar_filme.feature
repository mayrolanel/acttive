@unitários
Feature: Alugar filme
	Como um usuário
	Eu quero cadastrar aluguéis de fillmes
	Para controlar preços e datas de entrega

Scenario: Deve alugar um filme com sucesso
	When um filme
	| estoque | 2     |
	| preco   | 3     |
	| tipo    | comum |
	When alugar
	Then o preço do aluguel será R$ 3
	When a data de entrega será em 1 dia
	Given o estoque do filme será 1 unidade
	
Scenario: Não deve alugar um filme sem estoque
	When um filme com estoque de 0 unidades
	When alugar
	Then não será possível por falta de estoque
	When o estoque do filme será 0 unidade
	
Scenario Outline: Deve dar condições conforme tipo de aluguel
	When um filme com estoque de 2 unidades
	When que o preço de alguel seja R$ <preco>
	When que o tipo do aluguel seja <tipo>
	When alugar
	Then o preço do aluguel será R$ <valor>
	When a data de entrega será em <qtdDias> dias
	When a pontuação recebida será de <pontuacao> pontos
	
Examples:
	|  preco  |  tipo       |  valor  |  qtdDias |  pontuacao  |
	|   4     |  extendido  |   8     |    3     |     2       |
	|   4     |  comum      |   4     |    1     |     1       |
	|   5     |  semanal    |   15    |    7     |     3       |
	