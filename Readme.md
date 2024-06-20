# Webscraping Word Searcher w/ Homoglyphs - Adaptado para HackoonSpace

## Adaptação ao HackoonSpace

O projeto desenvolvido aqui é uma adaptação para o HackoonSpace, de um projeto desenvolvido para atender a um programa de seletiva de estágio na área de segurança da informação, originalmente desenvolvido em 2021.

## Conceito do projeto

Este projeto foi desenvolvido para detectar palavras semelhantes a partir de homóglifos, que são caracteres visualmente semelhantes a outros, mas com representações diferentes. A finalidade é utilizar essa detecção para identificar tentativas de contornar filtros de palavras-chave através do uso de homoglifos.

## Pré-requisitos e recursos utilizados

Foi utilizado a linguagem Java 8 para desenvolver a implementação geral do projeto, além de utilizar-se [outro projeto](https://github.com/codebox/homoglyph), inacabado na época (2021), de base para definir quais seriam os homóglifos base:

## Passo a passo de implementação

1. Implementação do mecanismo de webscraping, utilizado para escanear páginas HTTP à serem analisadas pela aplicação. ([HTMLPageReader](src/main/java/HTMLPageReader.java) e [SafetyCheck](src/main/java/SafetyCheck.java))
2. Definir mapeamento estático de letras para homóglifos. ([Homoglyphs](src/main/java/Homoglyphs.java))
3. Definir e implementar estratégia de comparação de letras com homóglifos. ([StringComparator](src/main/java/StringComparator.java) e [HomoglyphsWordMatcher](src/main/java/matchers/HomoglyphWordMatcher.java))
4. Integrar as implementações e receber os parâmetros de busca por args. ([Application](src/main/java/Application.java))

## Instalação

Para compilar e rodar localmente o programa, é recomendado utilizar o Maven como compilador do projeto, caso não sej habitiado com a ferramenta, é possivel aprender um pouco mais [aqui](https://maven.apache.org/guides/getting-started/index.html).

Para compilar o projeto, utilize o comando `mvn install` no diretório raiz do projeto (o mesmo diretório onde se encontra o arquivo [pom.xml](./pom.xml)).

OBS: É recomendado uma versão Java 8 ou superior para executar o projeto.

## Execução

Para executar o programa, basta executar o arquivo JAR no diretório `target` gerado pela execução do maven com os argumentos necessários.

### Exemplo

`java -classpath ./target/Word-Search-w-Homoglyphs-1.0-SNAPSHOT.jar Application <URL> <blacklist>`

sendo:

- `java` - O comando padrão para executar arquivos JAR gerados pelo compilador Java.
- `-classpath` - Uma flag que indica que passaremos o arquivo JAR que contém nossa classe executável.
- `./target/Word-Search-w-Homoglyphs-1.0-SNAPSHOT.jar` - O caminho padrão do executável do programa gerado pelo maven.
- `Application` - Nome da nossa classe executável (Main).
- `<URL>` - O primeiro argumento, em formato URL (ex: https://www.google.com/) da pagina onde deve se realizar a busca.
- `<blacklist>` - Uma lista de palavras à serem buscadas, separadas por espaço.
  - Obs: Utilize aspas `"palavra1 palavra2"` para buscar por frases literais ao invés de palavras individuais.

## Bugs/problemas conhecidos

- Como o projeto se baseia em um mapa de letra <-> homóglifo para fazer a tradução nas buscas, o escopo de funcionamento do projeto fica delimitado à precisão e completude deste mapa para realização das buscas, logo, caracteres não inseridos no mapa não serão considerados para a busca.

  - Para acrescentar caracteres ao mapa de tradução, insira o caractere desejado ao final da string correspondente à letra referente ao caractere no [mapa de tradução](./src/main/java/impl/Homoglyphs.java).

- A etapa de webscrapping analisa todo o documento HTML em busca das palavras-chave, incluindo tags HTML, cabeçalhos, scripts e respectivos parâmetros. Atualmente não há disponibilidade de buscar apenas no innerHTML/corpo do documento.

## Autor

- Gustavo Eugênio ([Gustavoesm](https://github.com/Gustavoesm)) - Backend Engineer
