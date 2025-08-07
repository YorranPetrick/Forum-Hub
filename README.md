# 🧵 ForumHub API

ForumHub é uma API REST desenvolvida em **Spring Boot** para gerenciamento de tópicos de fórum. Cada tópico é criado por um autor, que pode ter diferentes tipos de permissão. A aplicação utiliza um banco de dados em memória (**H2 Database**) por padrão, mas foi estruturada para permitir fácil migração para outros bancos relacionais.

## 📁 Estrutura do Projeto

- `controller/` – Endpoints da API
  - `AutorController`
  - `TopicoController`
- `models/` – Entidades e enums
  - `autor/`
    - `Autor`
    - `TiposAutores`
  - `topico/`
    - `Topico`
- `repository/` – Interfaces do Spring Data JPA
  - `AutorRepository`
  - `TopicoRepository`
- `service/` – Regras de negócio
  - `AutorService`
  - `TopicoService`
- `ForumhubApplication` – Classe principal da aplicação


## 🚀 Funcionalidades

- ✅ Cadastro de autores
- ✅ Classificação de autores por tipo:
  - `ADMINISTRADOR`
  - `AUTOR_COMUM`
  - `VISITANTE`
- ✅ Criação de tópicos por autores
- ✅ Listagem de tópicos
- ✅ Listagem de autores (Funcionalidade disponivel para Autores ADMINISTRADOR)
- ✅ CRUD disponivel para a Topicos.
- ✅ Persistência em banco de dados H2 (padrão)
