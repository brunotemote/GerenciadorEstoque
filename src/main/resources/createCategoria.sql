-- tabela categoria armazena informacoes sobre as categorias dos produtos
CREATE TABLE IF NOT EXISTS Categoria (
    id INT AUTO_INCREMENT PRIMARY KEY, -- identificador unico da categoria
    nome VARCHAR(255) NOT NULL, -- nome da categoria, obrigatorio
    descricao TEXT -- descricao detalhada da categoria, opcional
);
