# Plataforma de Feedback de Produtos/Serviços

## Descrição

Esta plataforma conecta empresas e consumidores, permitindo que os usuários avaliem produtos e serviços de forma detalhada. O objetivo é fornecer às empresas uma ferramenta prática para cadastrar produtos, gerenciar avaliações e obter insights valiosos com base no feedback dos clientes.

## Funcionalidades

- Cadastro de empresas e produtos.
- Sistema de autenticação e permissões para usuários e administradores.
- Avaliações detalhadas de produtos/serviços por parte dos consumidores.
- Dashboard para visualização de insights e métricas baseadas no feedback.

## Tecnologias Utilizadas

### Backend
- **Linguagem:** Java
- **Frameworks:** Spring Boot, Spring Security, Swagger
- **Banco de Dados:** PostgreSQL

### Frontend
- **Linguagem:** TypeScript
- **Framework:** Vue.js

### Infraestrutura
- **Containerização:** Docker

## Desafios e Aprendizados

- **Integração Backend e Frontend:** Implementar a comunicação eficiente e segura entre o backend e o frontend foi um dos maiores desafios, especialmente ao trabalhar com autenticação e controle de permissões usando Spring Security.
- **Vue.js com TypeScript:** Adquirir proficiência na construção de interfaces dinâmicas e tipadas foi um aprendizado valioso.
- **Docker:** A containerização proporcionou um ambiente de desenvolvimento mais consistente e simplificou o processo de implantação.

## Repositórios

- **Backend:** [GitHub - insight-hub](https://github.com/FillipeOliveiraAndrade/insight-hub)
- **Frontend:** [GitHub - insight-hub-front](https://github.com/FillipeOliveiraAndrade/insight-hub-front)

## Nota sobre o Frontend

Embora a aplicação conte com um frontend funcional desenvolvido em Vue.js com TypeScript, o foco principal deste projeto é o backend. Por isso, o frontend foi mantido intencionalmente com um visual clean e simples, priorizando a funcionalidade e integração com as APIs fornecidas pelo backend.

## Como Executar o Projeto

### Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas:

- **Docker** (para a containerização)
- **Node.js** (para executar o frontend)
- **Java 17+** (para o backend)

### Passos

1. Clone os repositórios:
   ```bash
   git clone https://github.com/FillipeOliveiraAndrade/insight-hub
   git clone https://github.com/FillipeOliveiraAndrade/insight-hub-front
   ```

2. Suba os containers com Docker (se configurado):
   ```bash
   docker-compose up
   ```

3. Execute o backend:
   ```bash
   cd insight-hub
   ./mvnw spring-boot:run
   ```

4. Execute o frontend:
   ```bash
   cd insight-hub-front
   npm install
   npm run serve
   ```

5. Acesse a aplicação no navegador:
   - **Frontend:** `http://localhost:8080`
   - **API:** `http://localhost:8080`

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir uma _issue_ ou enviar um _pull request_.
