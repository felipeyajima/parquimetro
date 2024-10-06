# Fase 2 - Pós Graduação FIAP

Nesta fase, o tema para o projeto foi o re-desenvolvimento de um sistema de parquímetros a qual estava apresentando problemas de performance e confiabilidade

**tecnologias utilizadas:**
- Java
- Spring Data MongoDB
- Banco de dados NoSql MongoDB


**pre-requisitos:**
- Java JDK Zulu 17
- Maven

|      Entidades          |Controller          |...                         |
|----------------|-------------------------------|-----------------------------|
|Veiculo		 |`'{veiculos}'`            |''            |
|Bilhete         |`"{bilhetes}"`            |''         |
|Infração        |`"{infracoes}"`			|''|



## 1 - Como Executar o código usando o Docker Compose

Para este projeto, existem algumas formas diferentes de executar o código, o mais indicado é usando o **Docker Compose**, pois em uma única execução, já entrega tanto o **código do Spring** como também o **MongoDB** funcionando e se comunicando diretamente. 

Ao baixar o projeto do git para sua máquina, vá até o diretório raíz "parquimetro" (onde estão os arquivos pom.xml, Dockerfile, etc.)  e execute os seguintes comandos:

O Comando abaixo irá buildar o projeto e gerar um arquivo .jar, que usaremos na criação da imagem docker
> mvn clean install

O Comando abaixo irá criar toda estrutura dos containers se comunicando
> docker-compose build

E por fim, o comando abaixo irá iniciar os containers
> docker-compose up -d


Para acessar as APIs, basta usar alguma ferramenta de chamadas como Postman ou Insomnia no seguinte endereço: http://localhost:8080




## 2 - Executando o código direto no computador por meio do Intellij

Para executar o código Java direto pelo IDE Intellij, baixe o projeto do repositório do github, e na pasta raíz "parquimetro" (onde está o arquivo pom.xml). 
Baixe as dependências necessárias por meio do utilitário Maven e execute o código a partir da ParquimetroApplication.

O acesso à API estará disponível no seguinte endereço: http://localhost:8080

## 3 - Executando o código em algum servidor

A imagem buildada do código está disponível no seguinte repositório do Docker Hub: felipebatista765/parquimetro:latest

Faz-se necessário alterar o endereço do banco de dados MongoDB para o IP do Banco que você tem disponível no seu ambiente através da substituição das variáveis de ambiente chamada: **spring.data.mongodb.uri**
