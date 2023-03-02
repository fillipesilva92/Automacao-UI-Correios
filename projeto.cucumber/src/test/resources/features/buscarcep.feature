
@buscarcep
Feature: Buscar CEP valido
  Como usuario quero inserir cep para buscar endereco

  @cepvalido
  Scenario: Buscar CEP valido
    Given que esteja na homepage ok
    And digito cep valido
    When clico no botao pesquisar ok
    Then valido busca
    
  @cepinexistente
  Scenario: Buscar CEP inexistente
    Given que esteja na homepage
    But digito cep inexistente
    When clico no botao pesquisar
    Then sistema retorna erro