@funcionais
Feature: Cadastro de contas
	Como um usuário 
	Gostaria de cadastrar contas
	Para que eu possa distribuir meu dinheiro de uma forma mais organizada

Background:
	When que estou acessando a aplicação
	Given informo o usuário "renato.silva.55@hotmail.com"
	And a senha "aaa"
	And seleciono entrar
	Then visualizo a página inicial
	Given seleciono Contas
	And seleciono Adicionar
	
Scenario Outline: Deve validar regras cadastro contas
	Given informo a conta "<conta>"
	And seleciono Salvar
	Then recebo a mensagem "<mensagem>"

Examples:
	|      conta       |           mensagem                 |
	| Conta de teste   | Conta adicionada com sucesso!      |
	|                  | Informe o nome da conta            |
	| Conta mesmo nome | Já existe uma conta com esse nome! |