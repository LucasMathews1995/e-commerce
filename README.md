Sistema de Gerenciamento de E-commerce 🛍️
Este projeto é uma API RESTful completa para gerenciar um sistema de e-commerce. A aplicação foi desenvolvida utilizando Spring Boot e Spring Data JPA, demonstrando o uso de herança de classes para gerenciar diferentes tipos de produtos, como eletrônicos, livros e roupas, de forma polimórfica e eficiente.

🛠️ Tecnologias Utilizadas
Java 17: Linguagem de programação principal.

Spring Boot: Framework que simplifica o desenvolvimento de APIs robustas.

Spring Data JPA: Facilita a persistência de dados e a interação com o banco de dados.

H2 Database: Banco de dados em memória, ideal para ambientes de desenvolvimento e testes.

Lombok: Reduz a verbosidade do código Java com anotações automáticas.

Maven: Ferramenta de gerenciamento de dependências e construção do projeto.

📦 Estrutura do Projeto
O projeto é modelado em uma hierarquia de classes de produtos, usando a estratégia de herança JOINED para uma estrutura de banco de dados bem normalizada.

Entidade Base: Produto (Classe Abstrata)
Representa as características comuns a todos os itens do e-commerce.

id (Long): Identificador único.

nome (String): Nome do produto.

preco (double): Preço de venda.

descricao (String): Descrição detalhada do produto.

estoque (int): Quantidade disponível em estoque.

Subclasses:
Eletronico: Estende Produto, com atributos específicos para eletrônicos.

voltagem (int): Voltagem de operação (ex: 110V, 220V).

garantiaAnos (int): Período de garantia em anos.

Livro: Estende Produto, com atributos específicos para livros.

autor (String): Nome do autor.

isbn (String): Código ISBN do livro.

numeroPaginas (int): Número total de páginas.

Roupa: Estende Produto, com atributos específicos para vestuário.

tamanho (String): Tamanho da peça (ex: P, M, G).

cor (String): Cor da peça.

material (String): Tipo de material (ex: Algodão, Poliéster).

🚀 Como Executar o Projeto
Clone o repositório:

Bash

git clone https://www.dio.me/articles/enviando-seu-projeto-para-o-github
Navegue até o diretório do projeto:

Bash

cd [nome-do-seu-projeto]
Inicie a aplicação:
Execute o projeto a partir da sua IDE (como IntelliJ ou VS Code) ou via linha de comando com o Maven.

Bash

mvn spring-boot:run
A API estará disponível em http://localhost:8080.

🗺️ Endpoints da API
A API foi projetada para interagir de forma polimórfica com os produtos. O ProdutoController lida com as operações genéricas, enquanto endpoints mais específicos podem ser adicionados para funcionalidades de busca avançadas.

ProdutoController
Método	Endpoint	Descrição
<br></br>
POST	/api/produtos	Cria um novo produto (o tipo é inferido pelo JSON).
<br></br>
GET	/api/produtos	Retorna uma lista de todos os produtos.
<br></br>
GET	/api/produtos/{id}	Retorna um produto pelo seu ID.
<br></br>
PUT	/api/produtos/{id}	Atualiza um produto existente.
DELETE	/api/produtos/{id}	Deleta um produto pelo ID.
