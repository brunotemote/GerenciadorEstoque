-- cria a tabela produto caso ela nao exista
CREATE TABLE IF NOT EXISTS Produto (
    id INT AUTO_INCREMENT PRIMARY KEY,  -- id do produto, inteiro, autoincrementado e chave primaria
    nome VARCHAR(255) NOT NULL,  -- nome do produto, texto (maximo 255 caracteres), nao pode ser nulo
    descricao TEXT,  -- descricao do produto, texto
    preco_compra DECIMAL(10, 2) NOT NULL,  -- preco de compra do produto, decimal (10 digitos, 2 casas decimais), nao pode ser nulo
    preco_venda DECIMAL(10, 2) NOT NULL,  -- preco de venda do produto, decimal (10 digitos, 2 casas decimais), nao pode ser nulo
    quantidade_estoque INT NOT NULL,  -- quantidade em estoque do produto, inteiro, nao pode ser nulo
    categoria_id INT,  -- id da categoria do produto, inteiro
    FOREIGN KEY (categoria_id) REFERENCES Categoria(id),  -- chave estrangeira que referencia a tabela categoria pelo id
    deleted BIT  -- indica se o produto foi excluido (0 = nao excluido, 1 = excluido)
);
