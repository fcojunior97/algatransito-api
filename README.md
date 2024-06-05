# Projeto AlgaTransito-Api

## Sobre a API
Esse projeto foi sendo desenvolvido com base no curso Ignição Spring Rest, promovido pela AlgaWorks. Esse projeto consiste no desenvolvimento de uma API de Administração de Trânsito, desenvolvido com Java e Spring. 
Inicialmente o projeto consistiu no desenvolvimento de endpoints básicos e construção de algumas entidades de dominio, tais como: Autuacao, Proprietario, Veiculo; Atualmente o projeto está em denvolvimento, onde estão sendo integradas novas funcionalidades e recursos a fim de provisionar uma API funcional e robusta. 

## Importante! ⚠️ <br>
Está sendo realizado a integração de novas funcionalidades, onde atualmente estamos trabalhando no módulo de cadastro de cnh e suas respectivas regras de négocio.

## Endpoints

Esta API fornece os seguintes endpoints: 

#### Proprietario
- Lista todos os proprietarios: `GET/proprietarios`
- Cadastra proprietario: `POST/proprietarios`
- Busca proprietario por cpf: `GET/proprietarios/{cpf}`
- Atualiza dados de um proprietario: `PUT/proprietarios/proprietarioId`
- Deleta um proprietario: `DELETE/proprietarios/{proprietarioId}`

#### Veiculo
- Lista todos os veiculos:  `GET/veiculos`
- Busca veiculo por ID: `GET/veiculos/1`
- Cadastra veiculo: `POST/veiculos`
- Atualiza cadastro de veiculos: `PUT/veiculos/1`

#### Cnh
- Lista todas as cnhs:  `GET/cnhs`
- Busca cnh por numero de registro: `GET/cnhs/{numeroRegistro}`
- Emitir cnh: `POST/cnhs`
- Atualiza dados de cnhs: `PUT/cnhs/{numeroRegistro}`
- Renovar cnh: `PUT/cnhs/renovar/{numeroRegistro}`

#### Autuação

- Listar autuações:  `GET/veiculos/{veiculoId}/autuacoes`
- Registrar autuação:  `POST/veiculos/{veiculoId}/autuacoes`

#### Apreensão

- Apreender veiculo:  `PUT/veiculos/{veiculoId}/apreensao`
- Remover apreensão:  `DELETE/veiculos/{veiculoId}/apreensao`


## Tecnologias usadas

Este projeto foi desenvolvido com as seguintes tecnologias:

- **SpringBoot 3.1.0**
- **Java 17**
- **Maven**
- **Lombok**
- **Flyway** 
- **MySQL**
- **ModelMapper 3.1.1**

## Como executar o projeto

### Clonar repositório

Clone o repositório git com o seguinte comando:

```
git clone https://github.com/fcojunior97/algatransito-api.git
```

### Empacotando
Você pode está gerando um `jar` do projeto para executar a API. Para isso, você deve executar o seguinte comando:

```
mvn clean package
```

Ele irá gerar um pacote `.jar` no seguinte diretorio `\algatransito-api\target` como mostrado no exemplo: `algatransito-api-0.0.1-SNAPSHOT`. 

### Executando
Para executar o projeto, você deve executar os seguinte comando:

```
java -jar algatransito-api-0.0.1-SNAPSHOT
```

