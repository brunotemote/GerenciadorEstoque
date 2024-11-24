
-- cria a tabela movimentacao caso ela nao exista
CREATE TABLE IF NOT EXISTS Movimentacao (
    id INT AUTO_INCREMENT PRIMARY KEY,  -- id da movimentacao, inteiro, autoincrementado e chave primaria
    produto_id INT,  -- id do produto relacionado a movimentacao, inteiro
    tipo_movimentacao ENUM('entrada', 'saida'),  -- tipo da movimentacao: entrada ou saida
    quantidade INT,  -- quantidade de produtos movimentados, inteiro
    data_movimentacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- data e hora da movimentacao, com valor padrao definido como a data e hora atuais
    FOREIGN KEY (produto_id) REFERENCES Produto(id)  -- chave estrangeira que referencia a tabela produto pelo id
);
