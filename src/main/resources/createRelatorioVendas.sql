-- cria a tabela relatoriovendas caso ela nao exista
CREATE TABLE IF NOT EXISTS RelatorioVendas (
    id INT AUTO_INCREMENT PRIMARY KEY,  -- id do relatorio de vendas, inteiro, autoincrementado e chave primaria
    produto_id INT,  -- id do produto, inteiro
    nome_produto VARCHAR(255),  -- nome do produto, texto (maximo 255 caracteres)
    quantidade_vendida INT DEFAULT 0,  -- quantidade vendida do produto, inteiro, com valor padrao 0
    lucro_total DECIMAL(10, 2) DEFAULT 0.00,  -- lucro total da venda do produto, decimal (10 digitos, 2 casas decimais), com valor padrao 0.00
    FOREIGN KEY (produto_id) REFERENCES Produto(id)  -- chave estrangeira que referencia a tabela produto pelo id
);
