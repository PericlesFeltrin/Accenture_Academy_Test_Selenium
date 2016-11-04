# Accenture_Academy_Test_Selenium

#### Academia de Testes Accenture Recife-PE

##### Escopo do projeto
Criar 2 Cenários de teste automatizado que valide a aplicação escolhida utilizando ferramenta Selenium webdriver. Desenvolvimento do cenário.

- REQUERIDO
    - Componentizar partes relevantes do cenário.
    - Criar estrutura de dados para controle das entras de saídas.
    - Logs das execuções com resultados esperados e atuais.
    - Dados de saída e resultados nos logs.
    - Validar fluxos principais, fluxos de exceção e estruturas de layout.
    - Testar em 1 browser.

- DESEJÁVEL
    - Utilizar expressões regulares.
    - Adicionar comentários de código (Preferencialmente em Inglês).
    - Criação de biblioteca de funções para reuso de métodos.
    - Externalizar logs de .txt
    - Validar formatação de dados.
    - Criar evidencias com Prints de tela.
    - Testar em 2 browsers
    - Utilizar API Junit para geração de resultados.

- ESTRELINHA
    - Criar script para controle da execução dos Scripts (número de repetições e controle de resultados)
    - Externalizar dados e entrada e saída ( Excel, .txt, etc )
    - Validar tempo de respostas das transações.
    - Criar evidências com relatório HTML contendo prints de telas e tempos de execução.
    - Parametrizar execuções em múltiplos browsers.

#### Instalação
1. Necessário a IDE de desenvolvimento [Eclipse](https://www.eclipse.org)
2. Necessário o [Chrome](https://www.google.com/chrome)
3. Necessário o JDK 1.8
4. Download do [Selenium](http://www.seleniumhq.org)
    - WebDriver Chrome
    - Selenium Java
5. Clonar o projeto na sua máquina
``` sh
git clone https://github.com/PericlesFeltrin/Accenture_Academy_Test_Selenium
```

#### Executar o Teste
1. Abrir o projeto no Eclipse
2. Alterar o caminho do WebDriver na Main.java
3. Alterar o caminho da pasta que irá salvar os logs em Log.java
4. Executar a classe Main.java
5. Verificar Log e Screenshot na pasta Log


#### Teste
- [Test.cart] Teste para verificar se o preço dos produtos adicionados estão corretos
  - Acessar a página dx.com
  - Realizar o login
  - Loop(1 vez, n vezes)
    - Buscar o produto
    - Abrir o produto
    - Adicionar o produto no carrinho de compras
  - Abrir o carrinho de compras
  - Verificar os valores do carrinho com o dos produtos adicionados

- [Test.wishList] Teste para verificar se os produtos foram adicionados na lista de desejos
  - Acessar a página dx.com
  - Realizar o login
  - Loop(1 vez, n vezes)
    - Buscar o(s) produto(s)
    - Adicionar o produto a lista de desejos
  - Acessar a página da lista de desejos
  - Verificar se foi adicionado corretamente os produtos na lista de deseejos





Autor [@PericlesFeltrin](https://github.com/periclesfeltrin)
