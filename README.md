<h1>MandaCaru Broker API</h1>

<h2>Descrição</h2>
<p>A MandaCaru Broker API é uma aplicação Spring Boot desenvolvida para facilitar o gerenciamento de informações relacionadas a ações (stocks) por meio de operações CRUD (Create, Read, Update, Delete). Com essa API, os usuários podem realizar diversas operações, como listar todas as ações disponíveis, obter detalhes de uma ação específica, criar novas ações, atualizar informações de ações existentes e excluir ações do sistema.</p>

<h2>Parâmetros da API</h2>
<p>O Mandacaru Broker API aceita os seguintes parâmetros em suas solicitações:</p>

<p><strong>• symbol: </strong>O símbolo da ação, que deve consistir em três letras seguidas de um número. Por exemplo: BBAS3.</p>

<p><strong>• companyName: </strong>O nome da empresa associada à ação.</p>

<p><strong>• price: </strong>O preço da ação.</p>

<p><strong>• id: </strong>O ID único associado a cada ação na plataforma.</p>

<h2>Recursos</h2>

<h3>Listar Todas as Ações</h3>
<p>Obtenha uma lista completa de todas as ações disponíveis.</p>

<p><strong>Endpoint:</strong></p>
<pre><code>GET /stocks</code></pre>

<p><strong>Exemplo de Resposta:</strong></p>

<pre><code>{
  {
    "id": 1,
    "symbol": "XYZ1",
    "companyName": "XYZ Corporation",
    "price": 150.25
  },
  {
    "id": 2,
    "symbol": "ABC2",
    "companyName": "ABC Inc.",
    "price": 2775.00
  },
  ...
}</code></pre>

<p>Este endpoint permite que você obtenha uma lista completa de todas as ações disponíveis na plataforma.</p>

<h3>Obter uma Ação por ID</h3>
<p>Retorna os detalhes de uma ação específica com base no ID.</p>

<p><strong>Endpoint:</strong></p>
<pre><code>GET /stocks/{id}</code></pre>

<p><strong>Parâmetros:</strong></p>

<p><strong>id:</strong> O ID único da ação que deseja ser obtida.</p>

<p><strong>Exemplo de Solicitação</strong></p>

<pre><code>GET /stocks/1</code></pre>

<p><strong>Exemplo de Resposta:</strong></p>

<pre><code>{
  "id": 1,
  "symbol": "XYZ1",
  "companyName": "XYZ Corporation",
  "price": 150.25
}</code></pre>

<p>Ao fornecer o ID da ação desejada, este endpoint retorna os detalhes completos dessa ação específica.</p>

<h3>Criar uma Nova Ação</h3>
<p>Cria uma nova ação com base nos dados fornecidos.</p>

<p><strong>Endpoint:</strong></p>
<pre><code>POST /stocks</code></pre>

<p><strong>Corpo da Solicitação (Request Body):</strong></p>
<pre><code>
{
  "symbol": "XYZ1",
  "companyName": "XYZ Corporation",
  "price": 56.97
}</code></pre>

<p><strong>Exemplo de Resposta (Status 201 - Created):</strong></p>

<pre><code>{
  "id": 3,
  "symbol": "XYZ1",
  "companyName": "XYZ Corporation",
  "price": 56.97
}</code></pre>

<p>Este endpoint permite a criação de uma nova ação. Para isso, você precisa fornecer os detalhes da nova ação no corpo da solicitação.</p>

<p>Também é necessário você incluir o símbolo da ação, o nome da empresa e o preço no formato JSON.</p>

<h3>Atualizar uma Ação por ID</h3>
<p>Atualiza os detalhes de uma ação específica com base no ID.</p>

<p><strong>Endpoint:</strong></p>
<pre><code>PUT /stocks/{id}</code></pre>

<p><strong>Parâmetros:</strong></p>

<p><strong>id:</strong> O ID único da ação que deseja ser atualizada.</p>

<p><strong>Corpo da Solicitação (Request Body):</strong></p>
<pre><code>{
  "symbol": "BBA3",
  "companyName": "Banco do Brasil",
  "price": 59.97
}</code></pre>

<strong></p>Exemplo de Resposta (Status 200 - OK):</strong></p>

<pre><code>{
  "id": 1,
  "symbol": "XYZ",
  "companyName": "XYZ Corporation",
  "price": 159.97
}</code></pre>


<p>Ao fornecer o ID da ação que deseja atualizar e os novos detalhes no corpo da solicitação, este endpoint permite a atualização dos detalhes dessa ação.</p>


<h3>Excluir uma Ação por ID</h3>
<p>Remove uma ação específica com base no ID.</p>

<p><strong>Endpoint:</strong></p>
<pre><code>DELETE /stocks/{id}</code></pre>

<p><strong>Parâmetros:</strong></p>

<p><strong>id:</strong> O ID único da ação que deseja ser excluída.</p>

<strong></p>Exemplo de Solicitação:</strong></p>

<pre><code>DELETE /stocks/3</code></pre>

<strong></p>Exemplo de Resposta (Status 204 - No Content):</strong></p>
<p>Nenhum conteúdo na resposta, apenas o status 204 indicando que a exclusão foi bem-sucedida.</p>


<p>Este endpoint permite a exclusão de uma ação específica com base no ID fornecido. Uma vez excluída, a ação não estará mais disponível na lista de ações.</p>

<h2>Novas Rotas</h2>

<h3>Autenticação de Usuários - Register/Login</h3>
<p>Para autenticar um usuário e obter um token JWT, envie uma solicitação POST para o endpoint <code>/auth/register</code> com as credenciais do usuário no corpo da solicitação</p>

<p><strong>Exemplo de Solicitação:</strong></p>
<pre><code>POST /auth/register
Content-Type: application/json
{
    "login": "novo_usuario",
    "password": "sua_senha_segura",
    "email": "exemplo@gmail.com",
    "firstName": "Primeiro Nome",
    "lastName" : "Sobrenome",
    "birthDate": "1990-01-01",
    "balance": 100,
    "role" : "ROLE_USER"
}
</code></pre>

<p>Para autenticar um usuário e obter um token JWT, envie uma solicitação POST para o endpoint <code>/auth/login</code> com as credenciais do usuário no corpo da solicitação</p>

<pre><code>POST /auth/login
Content-Type: application/json
{
  "username": "usuario_exemplo",
  "password": "senha_exemplo"
}</code></pre>

<p>Se as credenciais forem válidas, o servidor retornará um token JWT no corpo da resposta. Este token pode então ser usado em requisições posteriores para acessar rotas protegidas da API.</p>

<p><strong>Exemplo de Solicitação:</strong></p>
<pre><code>{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ1c2VyX2V4cGxvbWUiLCJpYXQiOjE2NDE2NzAwMjEsImV4cCI6MTY0MTY3MzYyMX0.q1x_NJ-Gk43sq0m6e5z6Tv7Zz1fI0_gR-5vEwYSvT1s"
}</code></pre>

<h2>Endpoints Adicionais</h2>

<h3>Depósito</h3>
<p>Realiza um depósito na conta do usuário.</p>

<p><strong>Endpoint:</strong></p>
<pre><code>POST /deposit</code></pre>

<p><strong>Corpo da Solicitação (Request Body):</strong></p>
<pre><code>
{
  "amount": 100.00
}</code></pre>

<p><strong>Exemplo de Resposta (Status 200 - OK):</strong></p>
<pre><code>{
  "message": "Depósito realizado com sucesso"
}</code></pre>

<h3>Saque</h3>
<p>Realiza um saque na conta do usuário.</p>

<p><strong>Endpoint:</strong></p>
<pre><code>POST /withdraw</code></pre>

<p><strong>Corpo da Solicitação (Request Body):</strong></p>
<pre><code>
{
  "amount": 50.00
}</code></pre>

<p><strong>Exemplo de Resposta (Status 200 - OK):</strong></p>
<pre><code>{
  "message": "Saque realizado com sucesso"
}</code></pre>


<h2>Uso</h2>
<ol>
  <li>Clone o repositório: <code>git clone https://github.com/Guilherme76/MandacaruBroker_Parte2</code></li>
  <li>Importe o projeto em sua IDE preferida.</li>
  <li>Configure o banco de dados e as propriedades de aplicação conforme necessário. A aplicação original utiliza o PostgreSQL como banco de dados. Certifique-se de ter um servidor PostgreSQL em execução e atualize as configurações de banco de dados no arquivo <code>application.properties</code>.</li>
  <li>Execute o aplicativo Spring Boot.</li>
  <li>Acesse a API em <code>http://localhost:8080</code>.</li>
</ol>

<p>Você também pode usar o Postman ou qualquer outra ferramenta similar para testar os endpoints da API.</p>

<h2>Requisitos</h2>
<ul>
  <li>Java 11 ou superior</li>
  <li>Maven</li>
  <li>Banco de dados</li>
  <LI>PostGreSQL
</ul>

<h2>Tecnologias Utilizadas</h2>
<ul>
  <li><strong>Spring Boot:</strong> Spring Boot é um framework Java que simplifica o processo de criação de aplicativos Java, fornecendo configurações padrão e convenções de projeto. Ele facilita o desenvolvimento de aplicativos robustos, escaláveis e fáceis de manter, integrando-se bem com outras tecnologias e frameworks.</li>
  <li><strong>Spring Data JPA:</strong> Spring Data JPA é parte do ecossistema Spring e fornece suporte para a implementação de camadas de persistência de dados em aplicativos Java com o uso do JPA (Java Persistence API). Ele simplifica o acesso e a manipulação de dados em bancos de dados relacionais por meio de interfaces de repositório e consultas derivadas.</li>
  <li><strong>Maven:</strong> Maven é uma ferramenta de automação de compilação e gerenciamento de dependências para projetos Java. Ele simplifica o processo de construção, empacotamento e distribuição de aplicativos Java, gerenciando automaticamente as dependências do projeto e facilitando a configuração do ambiente de desenvolvimento.</li>
  <li><strong>PostgreSQL:</strong> PostgreSQL é um sistema de gerenciamento de banco de dados relacional de código aberto e altamente escalável. Ele é amplamente utilizado em aplicativos corporativos e de missão crítica devido à sua confiabilidade, desempenho e recursos avançados de segurança e integridade de dados. Na API, o PostgreSQL é usado como o banco de dados principal para armazenar e manipular as informações sobre as ações (stocks).</li>
</ul>
<p>Essas tecnologias trabalham em conjunto para fornecer uma base sólida para a Mandacaru Broker API, permitindo o desenvolvimento de uma aplicação eficiente, escalável e de alto desempenho para gerenciar informações sobre ações de forma confiável e segura.</p>

<h2>Contribuições</h2>
<p>Caso queira contribuir com a ideia ou relatar um problema, sinta-se a vontade para abrir uma Issue ou um Pull Request, toda e qualquer contribuição será bem-vindas!</p>

<h2>Licença</h2>
<p>Este projeto está licenciado sob a Licença MIT.</p>
