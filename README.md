<h1>MandaCaru Broker API</h1>

<h2>Descrição</h2>
<p>A Mandacaru Broker API é uma aplicação Spring Boot que fornece operações CRUD (Create, Read, Update, Delete) para gerenciar informações sobre ações (stocks).</p>

<h2>Recursos</h2>

<h3>Listar Todas as Ações</h3>
<p>Obtenha uma lista completa de todas as ações disponíveis.</p>

<p><strong>Endpoint:</strong></p>
<pre><code>GET /stocks</code></pre>

<p>Este endpoint permite que você obtenha uma lista completa de todas as ações disponíveis na plataforma.</p>

<h3>Obter uma Ação por ID</h3>
<p>Retorna os detalhes de uma ação específica com base no ID.</p>

<p><strong>Endpoint:</strong></p>
<pre><code>GET /stocks/{id}</code></pre>

<p>Ao fornecer o ID da ação desejada, este endpoint retorna os detalhes completos dessa ação específica.</p>

<h3>Criar uma Nova Ação</h3>
<p>Cria uma nova ação com base nos dados fornecidos.</p>

<p><strong>Endpoint:</strong></p>
<pre><code>POST /stocks</code></pre>

<p>Este endpoint permite a criação de uma nova ação. Para isso, você precisa fornecer os detalhes da nova ação no corpo da solicitação.</p>

<p><strong>Corpo da Solicitação (Request Body):</strong></p>
<pre><code>{
  "symbol": "BBAS3",
  "companyName": "Banco do Brasil SA",
  "price": 56.97
}</code></pre>

<p>Você deve incluir o símbolo da ação, o nome da empresa e o preço no formato JSON.</p>

<h3>Atualizar uma Ação por ID</h3>
<p>Atualiza os detalhes de uma ação específica com base no ID.</p>

<p><strong>Endpoint:</strong></p>
<pre><code>PUT /stocks/{id}</code></pre>

<p>Ao fornecer o ID da ação que deseja atualizar e os novos detalhes no corpo da solicitação, este endpoint permite a atualização dos detalhes dessa ação.</p>

<p><strong>Corpo da Solicitação (Request Body):</strong></p>
<pre><code>{
  "symbol": "BBAS3",
  "companyName": "Banco do Brasil SA",
  "price": 59.97
}</code></pre>

<p>Você deve incluir o símbolo da ação, o nome da empresa e o novo preço no formato JSON.</p>

<h3>Excluir uma Ação por ID</h3>
<p>Remove uma ação específica com base no ID.</p>

<p><strong>Endpoint:</strong></p>
<pre><code>DELETE /stocks/{id}</code></pre>

<p>Este endpoint permite a exclusão de uma ação específica com base no ID fornecido. Uma vez excluída, a ação não estará mais disponível na lista de ações.</p>

<h2>Uso</h2>
<ol>
  <li>Clone o repositório: <code>git clone https://github.com/seu-usuario/MandaCaruBrokerAPI.git</code></li>
  <li>Importe o projeto em sua IDE preferida.</li>
  <li>Configure o banco de dados e as propriedades de aplicação conforme necessário.</li>
  <li>Execute o aplicativo Spring Boot.</li>
  <li>Acesse a API em <code>http://localhost:8080</code>.</li>
</ol>

<h2>Requisitos</h2>
<ul>
  <li>Java 11 ou superior</li>
  <li>Maven</li>
  <li>Banco de dados</li>
</ul>

<h2>Tecnologias Utilizadas</h2>
<ul>
  <li>Spring Boot</li>
  <li>Spring Data JPA</li>
  <li>Maven</li>
  <li>PostgreSQL</li>
</ul>

<h2>Contribuições</h2>
<p>Contribuições são bem-vindas!</p>

<h2>Licença</h2>
<p>Este projeto está licenciado sob a Licença MIT.</p>