CREATE TABLE IF NOT EXISTS RelatorioVendas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    produto_id INT,
    nome_produto VARCHAR(255),
    quantidade_vendida INT DEFAULT 0,
    lucro_total DECIMAL(10, 2) DEFAULT 0.00,
    FOREIGN KEY (produto_id) REFERENCES Produto(id)
);
