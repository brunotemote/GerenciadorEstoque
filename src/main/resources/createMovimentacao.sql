CREATE TABLE IF NOT EXISTS Movimentacao (
    id INT AUTO_INCREMENT PRIMARY KEY,
    produto_id INT,
    tipo_movimentacao ENUM('entrada', 'saida'),
    quantidade INT,
    data_movimentacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (produto_id) REFERENCES Produto(id)
);