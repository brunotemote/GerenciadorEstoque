CREATE PROCEDURE cadastro_produto(
    IN nome_produto VARCHAR(255),
    IN descricao TEXT,
    IN preco_compra DECIMAL(10, 2),
    IN preco_venda DECIMAL(10, 2),
    IN quantidade_estoque INT,
    IN nome_categoria VARCHAR(255),
    IN descricao_categoria TEXT
)
BEGIN
    DECLARE categoria_id INT;

    SELECT Categoria.id INTO categoria_id
    FROM Categoria
    WHERE nome = nome_categoria
    LIMIT 1;

    SELECT categoria_id;

    IF categoria_id IS NULL THEN
        INSERT INTO Categoria (nome, descricao)
        VALUES (nome_categoria, descricao_categoria);

        SET categoria_id = LAST_INSERT_ID();
    END IF;

    INSERT INTO Produto (nome, descricao, preco_compra, preco_venda, quantidade_estoque, categoria_id)
    VALUES (nome_produto, descricao, preco_compra, preco_venda, quantidade_estoque, categoria_id);

END;