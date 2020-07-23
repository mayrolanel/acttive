@unitarios
Feature: Aprender cucumber
	Como aluno
	Eu quero aprender a utilizar cucumber
	Para que eu possa automatizar criterios de aceitacao
	
Scenario: Deve executar espeficicacao
	When que criei o arquivo corretamente
	Given executa-lo
	Then a especificacao deve finalizar com sucesso
	
Scenario: Deve incrementar contador
	When que o valor do contador e 15
	Given eu incrementar em 3
	Then o valor do contador sera 18
	
Scenario: Deve incrementar contador
	When que o valor do contador e 123
	Given eu incrementar em 35
	Then o valor do contador sera 158
	
Scenario: Deve calcular atraso no prazo de entrega
	When que o prazo e dia 05/04/2018
	Given a entrega atrasar em 2 dias
	Then a entrega sera efetuada em 07/04/2018
	
Scenario: Deve calcular atraso no prazo de entrega da China
	When que o prazo e dia 05/04/2018
	Given a entrega atrasar em 2 meses
	Then a entrega sera efetuada em 05/06/2018
	
Scenario: Deve criar steps genericos para estes passos
    When que o ticket e AF345
    When que o valor da passagem e R$ 230,45
    When que o nome do passageiro e "Fulano da Silva"
    When que o telefone do passageiro e 9999-9999
    Given criar os steps
    Then o teste vai funcionar
    
Scenario: Deve reaproveitar os steps "Dado" do cenario anterior
    When que o ticket e AB167
    When que o ticket especial e AB167
    When que o valor da passagem e R$ 1120,23
    When que o nome do passageiro e "Cicrano de Oliveira"
    When que o telefone do passageiro e 9888-8888
    
@ignore
Scenario: Deve negar todos os steps Dado dos cenarios anteriores
    When que o ticket e CD123
    When que o ticket e AG1234
    When que o valor da passagem e R$ 1.1345,56
    When que o nome do passageiro e "Beltrano Souza Matos de Alcântara Azevedo"
    When que o telefone do passageiro e 1234-5678
    When que o telefone do passageiro e 999-2223