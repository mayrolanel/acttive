@unitários
Feature: Aprender cucumber
	Como aluno
	Eu quero aprender a utilizar cucumber
	Para que eu possa automatizar critérios de aceitação
	
Scenario: Deve executar espeficicação
	When que criei o arquivo corretamente
	Given executá-lo
	Then a especificação deve finalizar com sucesso
	
Scenario: Deve incrementar contador
	When que o valor do contador é 15
	Given eu incrementar em 3
	Then o valor do contador será 18
	
Scenario: Deve incrementar contador
	When que o valor do contador é 123
	Given eu incrementar em 35
	Then o valor do contador será 158
	
Scenario: Deve calcular atraso no prazo de entrega
	When que o prazo é dia 05/04/2018
	Given a entrega atrasar em 2 dias
	Then a entrega será efetuada em 07/04/2018
	
Scenario: Deve calcular atraso no prazo de entrega da China
	When que o prazo é dia 05/04/2018
	Given a entrega atrasar em 2 meses
	Then a entrega será efetuada em 05/06/2018
	
Scenario: Deve criar steps genéricos para estes passos
    When que o ticket é AF345
    When que o valor da passagem é R$ 230,45
    When que o nome do passageiro é "Fulano da Silva"
    When que o telefone do passageiro é 9999-9999
    Given criar os steps
    Then o teste vai funcionar
    
Scenario: Deve reaproveitar os steps "Dado" do cenário anterior
    When que o ticket é AB167
    When que o ticket especial é AB167
    When que o valor da passagem é R$ 1120,23
    When que o nome do passageiro é "Cicrano de Oliveira"
    When que o telefone do passageiro é 9888-8888
    
@ignore
Scenario: Deve negar todos os steps Dado dos cenários anteriores
    When que o ticket é CD123
    When que o ticket é AG1234
    When que o valor da passagem é R$ 1.1345,56
    When que o nome do passageiro é "Beltrano Souza Matos de Alcântara Azevedo"
    When que o telefone do passageiro é 1234-5678
    When que o telefone do passageiro é 999-2223