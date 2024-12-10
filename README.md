# Plano de Desenvolvimento: Plataforma de Feedback de Produtos/Serviços

## Objetivo
Desenvolver uma plataforma onde empresas podem cadastrar seus produtos/serviços e os usuários podem avaliá-los, deixando feedbacks detalhados. A plataforma permitirá interação entre usuários e empresas, proporcionando insights valiosos para as empresas e uma experiência mais rica para os consumidores.

---

## Fase 1: Planejamento e Estrutura Inicial
- ✅ Definir a arquitetura do sistema.
- ✅ Planejar o banco de dados (entidades: Usuário, Empresa, Produto/Serviço, Avaliação).
- ✅ Escolher as tecnologias a serem utilizadas (Spring Boot, React/Vue.js, PostgreSQL, etc.).
- ✅ Configuração do ambiente de desenvolvimento local.
- ✅ Criar repositório no GitHub para controle de versão.

---

## Fase 2: Criação de Funcionalidades Básicas
### 1. Cadastro de Empresas (com CNPJ) e Usuários
- ✅ Implementar cadastro de empresas com CNPJ e senha (validação no backend).
- [ ] Definir permissões diferenciadas (empresas: gerenciar produtos e visualizar avaliações; usuários: apenas avaliar).

### 2. Cadastro e Gerenciamento de Produtos/Serviços (para Empresas)
- [ ] Empresas podem criar, editar e excluir seus anúncios de produtos/serviços.
- [ ] Adicionar campos obrigatórios: nome, descrição, preço, categoria, imagens.

### 3. Interface de Avaliação de Produtos/Serviços (para Usuários)
- [ ] Usuários podem visualizar os anúncios e avaliar produtos/serviços com notas e comentários.
- [ ] Implementar a possibilidade de adicionar fotos nos comentários (se relevante).

---

## Fase 3: Funcionalidades Avançadas e Melhorias
### 1. Painel Administrativo (para Empresas)
- [ ] Empresas podem visualizar avaliações de seus produtos, responder a comentários e gerenciar publicações.
- [ ] Permitir download de relatórios de avaliação (em CSV ou PDF).

### 2. Filtragem e Busca de Produtos
- [ ] Implementar filtros por categoria, avaliação mínima, e data de publicação.
- [ ] Desenvolver funcionalidade de busca por nome de produto/serviço.

---

## Fase 4: Polimento e Testes
### 1. Testes de Funcionalidade
- [ ] Testar fluxos de cadastro, login, criação de anúncios, avaliação de produtos, resposta às avaliações e notificações.
- [ ] Testar performance do sistema.

### 2. Testes de Interface e UX
- [ ] Garantir interface intuitiva para empresas e usuários.
- [ ] Realizar testes de usabilidade com usuários.

### 3. Deploy
- [ ] Realizar deploy do backend (Heroku ou Vercel).
- [ ] Hospedar frontend (Netlify ou Vercel).
- [ ] Configurar domínio e SSL.

---

## Fase 5: Lançamento e Feedback
### 1. Lançamento Beta
- [ ] Disponibilizar a plataforma para um grupo seleto de empresas e usuários.
- [ ] Coletar feedback sobre usabilidade, performance e funcionalidades.

### 2. Correções e Ajustes
- [ ] Corrigir bugs e melhorar funcionalidades com base no feedback.

### 3. Marketing e Divulgação
- [ ] Preparar materiais de marketing para divulgar a plataforma.
- [ ] Implementar estratégias para atrair empresas.

---

## Fase 6: Melhorias e Expansão
- [ ] Implementar novos recursos conforme necessidades dos usuários.
- [ ] Explorar formas de monetização (planos premium, taxas por destaque de produtos, etc.).
- [ ] Continuar aprimorando a plataforma (desempenho, segurança, UX).

---

## Diagrama ER

Este é o diagrama ER do projeto para referência:

![er_diagram](https://github.com/user-attachments/assets/ccf85164-ec19-425f-a06e-09af5ae77654)
