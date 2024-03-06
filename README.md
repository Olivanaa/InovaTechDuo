# InovaTechDuo
API do projeto InovaTechDuo - Aplicativo de saúde para monitoramento e registro de dados pessoais.

## Tarefas

- [ ] CRUD de Categorias
- [ ] CRUD de Resumo
- [ ] CRUD de Usuários
- [ ] CRUD de Explorar

## Documentação da API

### Endpoint
- [Listar Todas as Categorias](#listar-todas-as-categorias)
- [Cadastrar Categoria](#cadastrar-categoria)
- [Detalhes da Categoria](#detalhes-da-categoria)
- [Apagar Categoria](#apagar-categoria)


### Listar Todas as Categorias

`GET` /explorar

Retorna um array com todas as categorias de saúde cadastradas.

#### Exemplo de Resposta

```js
[
    {
        "id": 1,
        "nome": "Sono",
        "icone": "Sleep"
    }
]
```

#### Códigos de Status

|código|descrição|
|------|---------|
|200|A lista de categorias foi retornada com sucesso!
|401|Acesso não permitido. É necessário autentificação.

---

### Cadastrar Categoria

`POST` /explorar

Adiciona uma nova categoria de saúde com os dados fornecidos no corpo da requisição.

#### Corpo da Requisição

|campo|tipo|obrigatório|descrição|
|-----|----|:-----------:|---------|
|nome|string|✅| Nome da categoria de saúde.
|icone|string|✅|Nome do ícone associado à categoria.

```js
{
    "nome": "sono",
    "icone": "sleep"
}
```

#### Exemplo de Resposta

```js
{
    "id": 1,
    "nome": "sono",
    "icone": "sleep"
}
```

#### Códigos de Status

|código|descrição|
|------|---------|
|201|Categoria de saúde adicionada com sucesso!
|400|Não foi possível adicionar a categoria. Verifique o corpo da requisição
|401|Acesso não permitido. É necessário autentificação.
---

### Detalhes da Categoria

`GET` /explorar/`{id}`

Retornar os detalhes da categoria com o `id` informado como parâmetro de path.

#### Exemplo de Resposta

```js
// requisição para /categoria/1
{
    "id": 1,
    "nome": "sono",
    "icone": "sleep"
}
```

#### Códigos de Status

|código|descrição|
|------|---------|
|200|Os dados da categoria foram retornados com sucesso!
|401|Acesso não permitido. É necessário autentificação.
|404|Não existe dados da categoria com o `id` informado.

___

### Apagar Categoria

`DELETE` /explorar/`{id}`

Apagar dados da categoria com o `id` especificado no parâmetro de path.

#### Códigos de Status

|código|descrição|
|------|---------|
|204|Dados da categoria foram apagados com sucesso!
|401|Acesso não permitido. É necessário autentificação.
|404|Não existe dados da categoria com o `id` informado.

___

