-- tabela alerta_estoque registra alertas relacionados ao estoque de produtos
CREATE TABLE IF NOT EXISTS AlertaEstoque (
    id INT AUTO_INCREMENT PRIMARY KEY, -- identificador unico do alerta
    produto_id INT, -- referencia o produto relacionado ao alerta
    mensagem VARCHAR(255), -- mensagem descrevendo o alerta
    data_alerta TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- data e hora do alerta, preenchido automaticamente
    FOREIGN KEY (produto_id) REFERENCES Produto(id) -- chave estrangeira ligando ao id da tabela produto
);
