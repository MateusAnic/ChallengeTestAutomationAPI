# Desafio Sicredi - Mateus Aniceto

Este projeto representa um conjunto abrangente de testes automatizados desenvolvidos para validar a integridade e funcionalidades da API associada a uma aplicação de gerenciamento de produtos eletrônicos. Os testes são elaborados em Java, utilizando os frameworks JUnit e RestAssured, proporcionando uma base sólida para a garantia da qualidade do software.

## Informações Mínimas do Projeto

- **Linguagem de Programação:** Java 17
- **Framework de Testes:** JUnit 5
- **Framework de Testes de API:** RestAssured 5.4.0
- **Gestor de Dependências:** Maven 4.0.0
- **Gerador de Relatório:** Allure Report 2.24.0

## Como Executar os Testes

### Pré-requisitos
- Certifique-se de ter o ambiente configurado com Java e Maven instalados.

### Execução dos Testes
1. **Clone o Repositório:**
2. **Navegue até o diretório do projeto:**
3. **Execute os testes:**

    ```bash
    mvn clean test
4. **Abra o relatório do Allure:**

    ```bash
    allure open

# Plano de Teste e Estratégia de Testes

### Testes dividos por Endpoints e tipo de requisição 

# Casos de Teste de Busca de Produtos com Autenticação

## Caso de Teste 1: Busca Bem-Sucedida com Autenticação Válida

**Objetivo:** Verificar se a busca por produtos, com autenticação válida, retorna resultados não vazios.

**Passos:**
1. Iniciar a execução do teste.
2. Enviar uma requisição à API de busca de produtos com credenciais de autenticação válidas.
3. Verificar se o código de status da resposta é 200 (OK).
4. Extrair a resposta e converter para o objeto `ListProduct`.
5. Confirmar que a lista de produtos não está vazia.

**Critérios de Aceitação:**
- O código de status da resposta deve ser 200.
- A lista de produtos obtida não deve estar vazia, indicando uma busca bem-sucedida.

---

## Caso de Teste 2: Falha de Autenticação na Busca de Produtos

**Objetivo:** Validar que a busca por produtos com credenciais de autenticação inválidas resulta em uma resposta adequada.

**Passos:**
1. Iniciar a execução do teste.
2. Enviar uma requisição à API de busca de produtos com credenciais de autenticação inválidas.
3. Verificar se o código de status da resposta é 401 (Unauthorized).
4. Extrair a resposta e converter para o objeto `Unauthorized`.
5. Confirmar que o nome do erro é "JsonWebTokenError".
6. Confirmar que a mensagem de erro é "Invalid/Expired Token!".

**Critérios de Aceitação:**
- O código de status da resposta deve ser 401.
- O nome do erro deve ser "JsonWebTokenError".
- A mensagem de erro deve ser "Invalid/Expired Token!".

---

## Caso de Teste 3: Acesso Negado na Busca de Produtos sem Autenticação

**Objetivo:** Assegurar que a tentativa de busca por produtos sem autenticação resulta em acesso negado.

**Passos:**
1. Iniciar a execução do teste.
2. Enviar uma requisição à API de busca de produtos sem fornecer credenciais de autenticação.
3. Verificar se o código de status da resposta é 403 (Forbidden).
4. Extrair a resposta e converter para o objeto `Forbidden`.
5. Confirmar que a mensagem de erro é "Authentication Problem".

**Critérios de Aceitação:**
- O código de status da resposta deve ser 403.
- A mensagem de erro deve ser "Authentication Problem".

# Casos de Teste de Busca de Produtos

## Caso de Teste 1: Busca de Produtos com Sucesso

**Objetivo:** Verificar se a busca por todos os produtos retorna uma lista não vazia.

**Passos:**
1. Chamar a API para buscar todos os produtos.
2. Verificar se o código de status da resposta é 200 (OK).
3. Extrair a resposta e converter para o objeto `ListProduct`.
4. Obter a lista de produtos.
5. Verificar se a lista de produtos não está vazia.

**Critérios de Aceitação:**
- O código de status da resposta deve ser 200.
- A lista de produtos obtida não deve estar vazia.

---

## Caso de Teste 2: Busca de Produto por ID com Sucesso

**Objetivo:** Confirmar que a busca de um produto por ID retorna o produto esperado.

**Passos:**
1. Gerar um ID aleatório.
2. Chamar a API para buscar o produto por ID.
3. Verificar se o código de status da resposta é 200 (OK).
4. Extrair a resposta e converter para o objeto `Product`.
5. Obter o ID do produto retornado.
6. Verificar se o ID do produto é igual ao ID gerado.

**Critérios de Aceitação:**
- O código de status da resposta deve ser 200.
- O ID do produto retornado deve ser igual ao ID gerado.

---

## Caso de Teste 3: Busca de Produto por ID sem Sucesso

**Objetivo:** Garantir que a busca de um produto por um ID inexistente resulta em um código 404 (Not Found).

**Passos:**
1. Chamar a API para buscar um produto com um ID inexistente (0).
2. Verificar se o código de status da resposta é 404 (Not Found).
3. Extrair a resposta e converter para o objeto `Forbidden`.
4. Obter a mensagem de erro.

**Critérios de Aceitação:**
- O código de status da resposta deve ser 404.
- A mensagem de erro deve indicar que o produto com o ID especificado não foi encontrado.

---

## Caso de Teste 4: Busca de Produto por ID Negativo

**Objetivo:** Verificar se a busca de um produto por um ID negativo resulta em um código 404 (Not Found).

**Passos:**
1. Chamar a API para buscar um produto com um ID negativo (-10).
2. Verificar se o código de status da resposta é 404 (Not Found).
3. Extrair a resposta e converter para o objeto `Forbidden`.
4. Obter a mensagem de erro.

**Critérios de Aceitação:**
- O código de status da resposta deve ser 404.
- A mensagem de erro deve indicar que o produto com o ID especificado não foi encontrado.

---

## Caso de Teste 5: Busca de Produto por ID String

**Objetivo:** Garantir que a busca de um produto por uma ID em formato de string resulta em um código 404 (Not Found).

**Passos:**
1. Chamar a API para buscar um produto com um ID em formato de string ("arroz e feijao").
2. Verificar se o código de status da resposta é 404 (Not Found).
3. Extrair a resposta e converter para o objeto `Forbidden`.
4. Obter a mensagem de erro.

**Critérios de Aceitação:**
- O código de status da resposta deve ser 404.
- A mensagem de erro deve indicar que o produto com o ID especificado não foi encontrado.

# Casos de Teste para Verificação do Status da Aplicação

## Caso de Teste 1: Verificação de Busca de Status com Sucesso

**Objetivo:** Assegurar que a busca do status da aplicação retorna um código 200 (OK).

**Passos:**
1. Iniciar a execução do teste.
2. Chamar a API para buscar o status da aplicação.
3. Verificar se o código de status da resposta é 200 (OK).
4. Extrair a resposta e converter para o objeto `TestResponse`.

**Critérios de Aceitação:**
- O código de status da resposta deve ser 200.

---

## Caso de Teste 2: Verificação da Resposta do Status

**Objetivo:** Confirmar que a resposta do status contém as informações esperadas.

**Passos:**
1. Iniciar a execução do teste.
2. Chamar a API para buscar o status da aplicação.
3. Verificar se o código de status da resposta é 200 (OK).
4. Extrair a resposta e converter para o objeto `TestResponse`.
5. Verificar se o status retornado é "ok".
6. Verificar se o método utilizado é "GET".

**Critérios de Aceitação:**
- O código de status da resposta deve ser 200.
- O status retornado deve ser "ok".
- O método utilizado deve ser "GET".

# Casos de Teste para Busca de Usuários

## Caso de Teste 1: Verificação de Busca de Usuários com Sucesso

**Objetivo:** Assegurar que a busca de usuários para autenticação retorna um código 200 (OK).

**Passos:**
1. Iniciar a execução do teste.
2. Chamar a API para buscar usuários para autenticação.
3. Verificar se o código de status da resposta é 200 (OK).
4. Extrair a resposta e converter para o objeto `ListUser`.

**Critérios de Aceitação:**
- O código de status da resposta deve ser 200.

---

## Caso de Teste 2: Verificação da Existência de Pelo Menos um Usuário

**Objetivo:** Garantir que a busca de usuários para autenticação resulta em pelo menos um usuário na listagem.

**Passos:**
1. Iniciar a execução do teste.
2. Chamar a API para buscar usuários para autenticação.
3. Verificar se o código de status da resposta é 200 (OK).
4. Extrair a resposta e converter para o objeto `ListUser`.
5. Obter a lista de usuários.
6. Verificar se a lista de usuários não está vazia.

**Critérios de Aceitação:**
- O código de status da resposta deve ser 200.
- A lista de usuários obtida não deve estar vazia.

---

## Caso de Teste 3: Verificação de Usuário Único

**Objetivo:** Confirmar que cada usuário retornado na busca para autenticação tem um nome de usuário único.

**Passos:**
1. Iniciar a execução do teste.
2. Chamar a API para buscar usuários para autenticação.
3. Verificar se o código de status da resposta é 200 (OK).
4. Extrair a resposta e converter para o objeto `ListUser`.
5. Obter a lista de usuários.
6. Extrair os nomes de usuário.
7. Verificar se os nomes de usuário são todos diferentes.

**Critérios de Aceitação:**
- O código de status da resposta deve ser 200.
- Todos os nomes de usuário devem ser diferentes entre si.


# Casos de Teste para Autenticação de Usuário

## Caso de Teste 1: Autenticação de Usuário com Sucesso

**Objetivo:** Garantir que a autenticação de usuário é bem-sucedida e resulta na geração de um token válido.

**Passos:**
1. Iniciar a execução do teste.
2. Buscar usuários para autenticação.
3. Verificar se o código de status da resposta é 200 (OK).
4. Extrair a lista de usuários e obter o primeiro usuário.
5. Preencher as credenciais de login com as informações do primeiro usuário.
6. Chamar a API para criar um token de autenticação.
7. Verificar se o código de status da resposta é 200 (OK).
8. Extrair a resposta e converter para o objeto `LoginSucess`.
9. Obter o token de autenticação.
10. Verificar se o token não está vazio.

**Critérios de Aceitação:**
- O código de status da resposta deve ser 200.
- O token de autenticação não deve estar vazio.

---

## Caso de Teste 2: Autenticação de Usuário sem Sucesso

**Objetivo:** Confirmar que a tentativa de autenticação com credenciais inválidas resulta em um código de erro apropriado.

**Passos:**
1. Iniciar a execução do teste.
2. Chamar a API para criar um token de autenticação com credenciais inválidas.
3. Verificar se o código de status da resposta é 400 (Bad Request).
4. Extrair a resposta e converter para o objeto `Forbidden`.
5. Obter a mensagem de erro.

**Critérios de Aceitação:**
- O código de status da resposta deve ser 400.
- A mensagem de erro deve indicar "Invalid credentials".

# Casos de Teste para Criação de Produtos

## Caso de Teste 1: Criação de Novo Produto com Sucesso

**Objetivo:** Assegurar que a criação de um novo produto é bem-sucedida e retorna um ID de produto válido.

**Passos:**
1. Iniciar a execução do teste.
2. Criar um novo produto utilizando dados válidos.
3. Chamar a API para criar o produto.
4. Verificar se o código de status da resposta é 200 (OK).
5. Extrair a resposta e converter para o objeto `ProductCreated`.
6. Obter o ID do produto criado.
7. Verificar se o ID do produto não está nulo.

**Critérios de Aceitação:**
- O código de status da resposta deve ser 200.
- O ID do produto criado não deve estar nulo.

---

## Caso de Teste 2: Criação de Novo Produto com Campo Vazio

**Objetivo:** Confirmar que a criação de um novo produto com campos vazios resulta em valores nulos para esses campos.

**Passos:**
1. Iniciar a execução do teste.
2. Criar um novo produto com campos vazios.
3. Chamar a API para criar o produto.
4. Verificar se o código de status da resposta é 200 (OK).
5. Extrair a resposta e converter para o objeto `ProductCreated`.
6. Obter o ID, stock, rating, thumbnail, description e brand do produto criado.
7. Verificar se o ID não está nulo.
8. Verificar se os campos stock, rating, thumbnail, description e brand estão nulos.

**Critérios de Aceitação:**
- O código de status da resposta deve ser 200.
- O ID do produto criado não deve estar nulo.
- Os campos stock, rating, thumbnail, description e brand devem estar nulos.

---

## Caso de Teste 3: Criação de Novo Produto Inválido

**Objetivo:** Validar que a tentativa de criar um novo produto com dados inválidos resulta em um código 200 (OK).

**Passos:**
1. Iniciar a execução do teste.
2. Criar um novo produto com dados inválidos.
3. Chamar a API para criar o produto.
4. Verificar se o código de status da resposta é 200 (OK).

**Critérios de Aceitação:**
- O código de status da resposta deve ser 200.

# Relatório de Bugs

## Bug 1: Possibilidade de Adicionar Produto com Dados Nulos

**Descrição:**
Durante a execução dos testes no caso de teste "Criação de Novo Produto com Campo Vazio", foi observado que é possível adicionar um produto com campos vazios. O sistema deveria validar e impedir a criação de produtos com dados nulos ou vazios.

**Passos para Reprodução:**
1. Executar o teste "Criação de Novo Produto com Campo Vazio".
2. Observar que o teste passa mesmo quando os campos do produto estão vazios.

**Comportamento Esperado:**
- O sistema deveria validar e rejeitar a criação de produtos com campos vazios.
- O código de status da resposta deveria indicar um erro apropriado.

**Ambiente:**
- Endpoint da API: "/products/add"

---

## Bug 2: Possibilidade de Realizar POST com Objeto Inválido

**Descrição:**
Ao executar o teste "Criação de Novo Produto Inválido", foi observado que é possível realizar um POST com um objeto que nem mesmo é um produto válido. O sistema não está validando corretamente os dados de entrada.

**Passos para Reprodução:**
1. Executar o teste "Criação de Novo Produto Inválido".
2. Observar que o teste passa mesmo quando um objeto inválido é fornecido para a criação de produto.

**Comportamento Esperado:**
- O sistema deve validar adequadamente os dados de entrada.
- A tentativa de criar um produto com um objeto inválido deve resultar em um código de erro apropriado.

**Ambiente:**
- Endpoint da API: "/products/add"

# Relatório de Melhorias

## Melhoria 1: Código de Resposta Incorreto ao Adicionar Novo Produto

**Descrição:**
Ao adicionar um novo produto, o código de resposta retornado é 200 (OK), quando o correto deveria ser 201 (Created) para indicar que a criação do recurso foi bem-sucedida.

**Passos para Reprodução:**
1. Executar o teste "Criação de Novo Produto com Sucesso".
2. Observar que o código de resposta é 200 em vez de 201.

**Comportamento Esperado:**
- O código de resposta ao adicionar um novo produto deve ser 201 (Created).

**Ambiente:**
- URL da API: "/products/add"

---
