CREATE TABLE IF NOT EXISTS RelatorioProdutos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    produto_id INT,
    nome VARCHAR(255),
    descricao TEXT,
    quantidade_estoque INT,
    preco_compra DECIMAL(10, 2),
    preco_venda DECIMAL(10, 2),
    categoria_nome VARCHAR(255),
    data_movimentacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (produto_id) REFERENCES Produto(id)
);