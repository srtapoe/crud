## 👩🏻‍💻 Aplicando DTOs, Records, Padrões de projetos e experimentando anotações num CRUD básico

### ✍🏻 Objetivo: Aplicar conhecimentos de libs, conversões entre entidades e Dtos e aplicação de Handlers 


---
### 📝 Conceitos teóricos

1. Controller: 

Atua como a camada de entrada da API. Ele recebe as requisições HTTP (como GET, POST, PUT, DELETE), processa os parâmetros e passa as informações necessárias para o Service. O Controller não deve conter a lógica de negócios, apenas chamar os métodos do Service.

2. Service: 

Contém a lógica de negócios da aplicação. O Service faz a interação com o repositório de dados (banco de dados, por exemplo), validações e as regras específicas da aplicação. Ele é chamado pelo Controller.

3. Interação entre Service e Controller:

O Controller recebe uma requisição HTTP, como um POST para criar um novo personagem de série.
O Controller então chama um método do Service passando as informações necessárias.
O Service executa a lógica de negócios, como salvar o personagem no banco de dados. O resultado é enviado de volta para o Controller, que retorna uma resposta HTTP (como 200 OK ou 201 Created).

4. Como tudo interage:

O Controller recebe as requisições HTTP e delega a lógica para o Service.
O Service executa a lógica de negócios e interage com o PersonagemRepository para acessar o banco de dados.
O Repository é responsável por persistir e recuperar os dados da entidade Personagem do banco de dados.

---
### 📍Nesse CRUD está sendo aplicado:

- [x] Data Transference Object(dto) - [Aprendi sobre DTO nessa explicação no StackOverflow](https://pt.stackoverflow.com/questions/31362/o-que-%C3%A9-um-dto)
- [x] Mapeamento de entidade para Dto e inverso - [Artigo no Medium usado como referência](https://medium.com/globant/mapstruct-let-me-write-the-tedious-piece-of-code-for-you-d3c27f667314)
- [ ] Exceptions Handlers(em andamento)🛸 - [Vídeo referência](https://www.youtube.com/watch?v=GmbK-O3v3Gg&ab_channel=FernandaKipper%7CDev)
- [x] Migrations - [Artigo referência](https://www.baeldung.com/database-migrations-with-flyway)

---
### 🔧 Ferramentas usadas:

1. [Intellij](https://www.jetbrains.com/idea/download/)
2. [Insomnia](https://insomnia.rest/download)
3. [MySQL](https://www.mysql.com/downloads/)

### 🔦 Como baixar e rodar o projeto:

1. Clone o projeto `git@github.com:srtapoe/crud.git`
2. Abra o projeto em sua IDE de preferência
3. Rode o Maven para baixar as dependências do projeto
4. Crie o banco no seu banco de preferência - eu usei o Mysql
5. Mude o applications.properties para refletir os dados de acesso ao seu banco - usei variáveis de ambiente no Intellij para acesso ao banco
6. Ao rodar o projeto pela primeira vez o Flyway vai criar a tabela personagens no banco que referenciou acima
7. Para testar use o Insomnia ou o Postman para testar as requisições - [Coleção de request que fiz no Insomnia]()