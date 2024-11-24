CREATE TABLE IF NOT EXISTS AlertaEstoque (
    id INT AUTO_INCREMENT PRIMARY KEY,
    produto_id INT,
    mensagem VARCHAR(255),
    data_alerta TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (produto_id) REFERENCES Produto(id)
);