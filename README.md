
# HemocentroBack

O back-end do projeto de um sistema de gerenciamento de hemocentros, submetido como trabalho para a disciplina de Desenvolvimento de Sistemas do 5º período do curso de Engenharia de Computação, no CEFET-MG.




## Autores

- [@AndreGuilherme404](https://www.github.com/AndreGuilherme404)
- [@ronaldrodriguesvitorino](https://www.github.com/ronaldrodriguesvitorino)
- [@MateusLopes15](https://www.github.com/MateusLopes15)
# Referência da API

## Autenticação

### Login

```http
POST /auth/login
```

Realiza a autenticação do usuário e retorna o token de acesso.

#### Body

| Campo   | Tipo     | Descrição        |
| ------- | -------- | ---------------- |
| `login` | `string` | Login do usuário |
| `senha` | `string` | Senha do usuário |

#### Exemplo

```json
{
  "login": "admin",
  "senha": "123456"
}
```

---

# Pessoa

## Retorna todas as pessoas

```http
GET /pessoa
```

Retorna a lista de pessoas cadastradas.

---

## Buscar pessoa por ID

```http
GET /pessoa/{id}
```

Retorna os dados de uma pessoa específica.

| Parâmetro | Tipo   | Descrição                     |
| --------- | ------ | ----------------------------- |
| `id`      | `long` | **Obrigatório**. ID da pessoa |

---

## Criar pessoa

```http
POST /pessoa
```

Cria uma nova pessoa.

#### Body

```json
{
  "nome": "João da Silva",
  "cpf": "12345678909",
  "email": "joao@email.com"
}
```

| Campo   | Tipo     | Descrição        |
| ------- | -------- | ---------------- |
| `nome`  | `string` | Nome completo    |
| `cpf`   | `string` | CPF da pessoa    |
| `email` | `string` | E-mail da pessoa |

---

## Alterar pessoa

```http
PUT /pessoa/{id}
```

Atualiza os dados de uma pessoa.

| Parâmetro | Tipo   | Descrição                     |
| --------- | ------ | ----------------------------- |
| `id`      | `long` | **Obrigatório**. ID da pessoa |

#### Body

```json
{
  "nome": "João Atualizado",
  "cpf": "12345678909",
  "email": "novo@email.com"
}
```

---

## Excluir pessoa

```http
DELETE /pessoa/{id}
```

Remove uma pessoa do sistema.

| Parâmetro | Tipo   | Descrição                     |
| --------- | ------ | ----------------------------- |
| `id`      | `long` | **Obrigatório**. ID da pessoa |

---

## Listar usuários relacionados a uma pessoa

```http
GET /pessoa/{id}/usuarios
```

Retorna todos os usuários vinculados à pessoa.

| Parâmetro | Tipo   | Descrição                     |
| --------- | ------ | ----------------------------- |
| `id`      | `long` | **Obrigatório**. ID da pessoa |

---

# Hemocentro

## Listar hemocentros

```http
GET /hemocentro
```

Retorna todos os hemocentros cadastrados.

---

## Buscar hemocentro por ID

```http
GET /hemocentro/{id}
```

Retorna um hemocentro específico.

| Parâmetro | Tipo   | Descrição                         |
| --------- | ------ | --------------------------------- |
| `id`      | `long` | **Obrigatório**. ID do hemocentro |

---

## Criar hemocentro

```http
POST /hemocentro
```

Cria um novo hemocentro.

#### Body

```json
{
  "nome": "Hemocentro Central",
  "descricao": "Hemocentro principal"
}
```

| Campo       | Tipo     | Descrição               |
| ----------- | -------- | ----------------------- |
| `nome`      | `string` | Nome do hemocentro      |
| `descricao` | `string` | Descrição do hemocentro |

---

## Alterar hemocentro

```http
PUT /hemocentro/{id}
```

Atualiza um hemocentro.

| Parâmetro | Tipo   | Descrição                         |
| --------- | ------ | --------------------------------- |
| `id`      | `long` | **Obrigatório**. ID do hemocentro |

#### Body

```json
{
  "nome": "Hemocentro Atualizado",
  "descricao": "Descrição atualizada"
}
```

---

## Excluir hemocentro

```http
DELETE /hemocentro/{id}
```

Remove um hemocentro.

| Parâmetro | Tipo   | Descrição                         |
| --------- | ------ | --------------------------------- |
| `id`      | `long` | **Obrigatório**. ID do hemocentro |

---

## Listar usuários do hemocentro

```http
GET /hemocentro/{id}/usuarios
```

Retorna os usuários vinculados ao hemocentro.

| Parâmetro | Tipo   | Descrição                         |
| --------- | ------ | --------------------------------- |
| `id`      | `long` | **Obrigatório**. ID do hemocentro |

---

# Exame

## Listar exames

```http
GET /exame
```

Retorna todos os exames cadastrados.

---

## Buscar exame por ID

```http
GET /exame/{id}
```

Retorna um exame específico.

| Parâmetro | Tipo   | Descrição                    |
| --------- | ------ | ---------------------------- |
| `id`      | `long` | **Obrigatório**. ID do exame |

---

## Criar exame

```http
POST /exame
```

Cria um novo exame.

#### Body

```json
{
  "nome": "HIV",
  "descricao": "Teste para HIV"
}
```

---

## Alterar exame

```http
PUT /exame/{id}
```

Atualiza um exame.

| Parâmetro | Tipo   | Descrição                    |
| --------- | ------ | ---------------------------- |
| `id`      | `long` | **Obrigatório**. ID do exame |

#### Body

```json
{
  "nome": "HIV Atualizado",
  "descricao": "Nova descrição"
}
```

---

## Excluir exame

```http
DELETE /exame/{id}
```

Remove um exame.

| Parâmetro | Tipo   | Descrição                    |
| --------- | ------ | ---------------------------- |
| `id`      | `long` | **Obrigatório**. ID do exame |

---

# Coleta

## Listar coletas

```http
GET /coleta
```

Retorna todas as coletas cadastradas.

---

## Buscar coleta por ID

```http
GET /coleta/{id}
```

Retorna uma coleta específica.

| Parâmetro | Tipo   | Descrição                     |
| --------- | ------ | ----------------------------- |
| `id`      | `long` | **Obrigatório**. ID da coleta |

---

## Criar coleta

```http
POST /coleta
```

Cria uma nova coleta.

#### Body

```json
{
  "dataColeta": "22-06-2026",
  "dataValidade": "22-08-2026",
  "hemocentroId": 1,
  "pessoaId": 1
}
```

| Campo          | Tipo     |
| -------------- | -------- |
| `dataColeta`   | `string` |
| `dataValidade` | `string` |
| `hemocentroId` | `long`   |
| `pessoaId`     | `long`   |

---

## Alterar coleta

```http
PUT /coleta/{id}
```

Atualiza uma coleta.

| Parâmetro | Tipo   | Descrição                     |
| --------- | ------ | ----------------------------- |
| `id`      | `long` | **Obrigatório**. ID da coleta |

---

## Excluir coleta

```http
DELETE /coleta/{id}
```

Remove uma coleta.

| Parâmetro | Tipo   | Descrição                     |
| --------- | ------ | ----------------------------- |
| `id`      | `long` | **Obrigatório**. ID da coleta |

---

# Usuário

## Listar usuários

```http
GET /usuario
```

Retorna todos os usuários cadastrados.

---

## Buscar usuário por ID

```http
GET /usuario/{id}
```

Retorna um usuário específico.

| Parâmetro | Tipo   | Descrição                      |
| --------- | ------ | ------------------------------ |
| `id`      | `long` | **Obrigatório**. ID do usuário |

---

## Criar usuário

```http
POST /usuario
```

Cria um novo usuário.

#### Body

```json
{
  "login": "admin",
  "senha": "123456",
  "tipoPerfil": "GERENTE",
  "pessoaId": 1,
  "hemocentroId": 1
}
```

| Campo          | Tipo     |
| -------------- | -------- |
| `login`        | `string` |
| `senha`        | `string` |
| `tipoPerfil`   | `string` |
| `pessoaId`     | `long`   |
| `hemocentroId` | `long`   |

---

## Alterar usuário

```http
PUT /usuario/{id}
```

Atualiza um usuário.

| Parâmetro | Tipo   | Descrição                      |
| --------- | ------ | ------------------------------ |
| `id`      | `long` | **Obrigatório**. ID do usuário |

---

## Excluir usuário

```http
DELETE /usuario/{id}
```

Remove um usuário.

| Parâmetro | Tipo   | Descrição                      |
| --------- | ------ | ------------------------------ |
| `id`      | `long` | **Obrigatório**. ID do usuário |

---

# Exame Coleta

## Listar exames de uma coleta

```http
GET /exameColeta?coletaId={coletaId}
```

Retorna os exames vinculados a uma coleta.

| Parâmetro  | Tipo   | Descrição                     |
| ---------- | ------ | ----------------------------- |
| `coletaId` | `long` | **Obrigatório**. ID da coleta |

---

## Criar vínculo exame/coleta

```http
POST /exameColeta
```

Vincula um exame a uma coleta.

#### Body

```json
{
  "coletaId": 1,
  "exameId": 1,
  "situacao": "POSITIVO"
}
```

| Campo      | Tipo     |
| ---------- | -------- |
| `coletaId` | `long`   |
| `exameId`  | `long`   |
| `situacao` | `string` |

---

## Alterar vínculo exame/coleta

```http
PUT /exameColeta/{id}
```

Atualiza o resultado de um exame vinculado a uma coleta.

| Parâmetro | Tipo   | Descrição                      |
| --------- | ------ | ------------------------------ |
| `id`      | `long` | **Obrigatório**. ID do vínculo |

#### Body

```json
{
  "coletaId": 1,
  "exameId": 1,
  "situacao": "REPROVADO"
}
```

---

## Excluir vínculo exame/coleta

```http
DELETE /exameColeta/{id}
```

Remove o vínculo entre exame e coleta.

| Parâmetro | Tipo   | Descrição                      |
| --------- | ------ | ------------------------------ |
| `id`      | `long` | **Obrigatório**. ID do vínculo |

```
```
