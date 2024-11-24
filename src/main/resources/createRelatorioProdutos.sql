-- cria a tabela relatorioprodutos caso ela nao exista
CREATE TABLE IF NOT EXISTS RelatorioProdutos (
    id INT AUTO_INCREMENT PRIMARY KEY,  -- id do relatorio, inteiro, autoincrementado e chave primaria
    produto_id INT,  -- id do produto, inteiro
    nome VARCHAR(255),  -- nome do produto, texto (maximo 255 caracteres)
    descricao TEXT,  -- descricao do produto, texto
    quantidade_estoque INT,  -- quantidade em estoque do produto, inteiro
    preco_compra DECIMAL(10, 2),  -- preco de compra do produto, decimal (10 digitos, 2 casas decimais)
    preco_venda DECIMAL(10, 2),  -- preco de venda do produto, decimal (10 digitos, 2 casas decimais)
    categoria_nome VARCHAR(255),  -- nome da categoria do produto, texto (maximo 255 caracteres)
    data_movimentacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- data e hora da movimentacao, com valor padrao definido como a data e hora atuais
    FOREIGN KEY (produto_id) REFERENCES Produto(id)  -- chave estrangeira que referencia a tabela produto pelo id
);
