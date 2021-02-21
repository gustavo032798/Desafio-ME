# Instruções de Instalações e Inicialização
 * Baixar o pacote JDK 8 do Java
 * Configurar as variáveis de ambiente
 * Instalar Eclipse IDE
 * Instalar o ChromeDriver e direcionar a pasta no qual está dentro do código
 * Instalar o Cucumber no Eclipse Marketplace
  
  
# Instruções para Execução dos Testes
 * Verificar se todas as dependencias estão importadas do arquivo POM
 * Pra executar os testes pode estar executando o Arquivo "RunCucumberTest" com o Junit
   * Com isso irá executar todos os cenários e gerar o resultado através de um arquivo HTML e Json
   * Pra verificar o resultado basta dar um "Refresh" no projeto e ir na Pasta "target" onde estarão esses arquivos
   * Pra poder simular um erro basta alterar algum dado da validação nas features, ou seja, alterar algum dado do step "Entao"
 * Pode-se também executar cada cenário de teste indo na feature desejada e clicar com botão direito e rodar com o Cucumber

# Tecnologias Utilizadas na Aplicação
 * Eclipse
 * Java
 * Maven
 * Selenium
 * BDD
 * Cucumber
 * Junit
 * Faker (Gerador de dados Fake)
 * Page Factory / Page Object
