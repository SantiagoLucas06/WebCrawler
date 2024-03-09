A aplicação em Java desenvolvida para realizar crawling/spider no site da DrogaRaia é projetada para coletar informações específicas de algumas páginas de categorias do site. Utilizando técnicas de web scraping, a aplicação navega pelas páginas relevantes, extrai dados estruturados e os armazena para análise posterior. O objetivo principal é obter informações como nomes de produtos, preços, descrições e possíveis promoções dentro das categorias pré-determinadas. O código da aplicação utiliza bibliotecas adequadas para manipulação de HTML, como Jsoup, e implementa lógica eficiente de navegação para garantir a captura precisa e sistemática dos dados desejados. O resultado final é um conjunto organizado de informações que podem ser utilizadas para análise de mercado, comparação de preços ou outros fins específicos.


Parametros de execução


Iniciar/Continuar Depuração: F9
Parar Depuração: Ctrl+F2
Passar para o próximo ponto de interrupção/continuar: F9
Step Over (Executar o próximo passo sem entrar nos métodos): F8
Step Into (Entrar no método onde o cursor está posicionado): F7
Step Out (Sair do método atual): Shift+F8
Run to Cursor (Executar até o cursor): Alt+F9
Evaluate Expression (Avaliar expressão): Alt+F8
Toggle Breakpoint (Ativar/Desativar ponto de interrupção): Ctrl+F8
View Breakpoints (Visualizar pontos de interrupção): Ctrl+Shift+F8


1. Selecionando por ID
Para selecionar um elemento pelo seu ID, use o símbolo # seguido pelo valor do ID.
Element elementoPorId = doc.selectFirst("#searchHeader");

2. Selecionando por Classe
Para selecionar elementos por classe, use o símbolo . seguido pelo nome da classe.
Element elementoPorClasse = doc.selectFirst(".Searchstyles__SearchButton-wxhijf-2");

3. Selecionando por Atributo
Para selecionar elementos por um atributo específico, use colchetes [] contendo o nome do atributo e, opcionalmente, seu valor.
Element elementoPorAtributo = doc.selectFirst("a[title='O que é assinatura?']");

4. Selecionando por Tag
Para selecionar elementos por sua tag, simplesmente use o nome da tag.
Element elementoPorTag = doc.selectFirst("nav");

5. Combinação de Classe e Tag
Para combinar seletores, como buscar uma div com uma classe específica, concatene o nome da tag e a classe.
Element combinacaoTagEClasse = doc.selectFirst("div.RaiaHeaderMyAccountstyles__Container-sc-1pvxolw-0");

6. Filhos Diretos
Para selecionar filhos diretos de um elemento, use o operador > entre os seletores do pai e do filho.
Elements filhosDiretos = doc.select("div > a.RaiaHeaderOrdersstyles__Orderstyles-sc-7ew76i-0");

7. Elementos com Múltiplos Atributos
Para selecionar elementos que possuem múltiplos atributos específicos, combine os seletores de atributo.

Element multiplosAtributos = doc.selectFirst("button[type='submit'][data-qa='header_btn_submit_search']");

8. Elementos com Atributos que Contenham um Valor Específico
Para selecionar elementos cujo valor de um atributo contenha uma string específica, use o símbolo *= dentro dos colchetes.
Elements elementosComSubstring = doc.select("a[href*='/assinatura']");

9. Primeiro e Último Filho
Para selecionar o primeiro ou o último filho dentro de seus respectivos pais, use os pseudos-seletores :first-child e :last-child.
Element primeiroFilho = doc.selectFirst("ul.RaiaHeaderSubscriptionstyles__Links-sc-1f2c38h-4 > li:first-child");
Element ultimoFilho = doc.selectFirst("ul.RaiaHeaderSubscriptionstyles__Links-sc-1f2c38h-4 > li:last-child");

10. Elementos que Contêm um Texto Específico
Para selecionar elementos que contêm um texto específico, você pode usar o método :contains(texto).
Elements elementosComTexto = doc.select("div:contains(Olá faça seu login)");

