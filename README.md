# Fase 2 - Pós Graduação FIAP

Nesta fase, o tema para o projeto foi o re-desenvolvimento de um sistema de parquímetros a qual estava apresentando problemas de performance e confiabilidade

**tecnologias utilizadas:**
- Java
- Spring Data MongoDB
- Banco de dados NoSql MongoDB


**pre-requisitos:**
- Java JDK Zulu 17
- Maven

|      Entidades          | Path          | collection - mongodb                         |
|----------------|-------------------------------|-----------------------------|
|Veiculo		 |`'/veiculos'`            |'veiculo'            |
|Bilhete         |`'/bilhetes'`            |'bilhete'         |
|Infração        |`'infracoes'`			|'infracao'  |



## 1 - Como Executar o código usando o Docker Compose "RECOMENDADO"

Para este projeto, existem algumas formas diferentes de executar o código, o mais indicado é usando o **Docker Compose**, pois em uma única execução, já entrega tanto o **código a partir da imagem containerizada** como também o **MongoDB** funcionando e se comunicando diretamente.

pre-requisitos: Docker e Docker-Compose instalado na sua máquina

-Baixe apenas o arquivo docker-compose.yaml

-Na mesma pasta onde o arquivo foi baixado, execute o comando: **docker-compose up -d**

A API estará disponível no seu computador no endereço http://localhost:8080/



## 2 - Executando o código direto no computador por meio do Intellij

Para executar o código Java direto pelo IDE Intellij, baixe o projeto do repositório do github, e abra na pasta raíz "parquimetro" (onde está o arquivo pom.xml). 
Baixe as dependências necessárias por meio do utilitário Maven e execute o código a partir da ParquimetroApplication.

O acesso à API estará disponível no seguinte endereço: http://localhost:8080

Obs: Necessita de uma instância do MongoDB 8.0.0 rodando em sua máquina.


## 3 - Executando o código em algum servidor

A imagem buildada do código está disponível no seguinte repositório do Docker Hub: felipebatista765/parquimetro:latest

Faz-se necessário alterar o endereço do banco de dados MongoDB para o IP do Banco que você tem disponível no seu ambiente através da substituição das variáveis de ambiente chamada: **spring.data.mongodb.uri**
ex: spring.data.mongodb.uri=mongodb://localhost/parquimetro-spring para spring.data.mongodb.uri=mongodb://IP-SERVIDOR-MONGODB/parquimetro-spring

