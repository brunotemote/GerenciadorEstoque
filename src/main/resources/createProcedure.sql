-- procedure para cadastrar um novo produto
CREATE PROCEDURE cadastro_produto(
    IN nome_produto VARCHAR(255),  -- nome do produto
    IN descricao TEXT,  -- descricao do produto
    IN preco_compra DECIMAL(10, 2),  -- preco de compra do produto
    IN preco_venda DECIMAL(10, 2),  -- preco de venda do produto
    IN quantidade_estoque INT,  -- quantidade em estoque do produto
    IN nome_categoria VARCHAR(255),  -- nome da categoria do produto
    IN descricao_categoria TEXT  -- descricao da categoria do produto
)
BEGIN
    DECLARE categoria_id INT;  -- variavel para armazenar o id da categoria

    -- busca o id da categoria com base no nome
    SELECT Categoria.id INTO categoria_id
    FROM Categoria
    WHERE nome = nome_categoria
    LIMIT 1;

    -- exibe o id da categoria (pode ser removido em producao)
    SELECT categoria_id;  

    -- se a categoria nao existir, cria uma nova categoria
    IF categoria_id IS NULL THEN
        INSERT INTO Categoria (nome, descricao)
        VALUES (nome_categoria, descricao_categoria);

        -- obtem o id da categoria recem-criada
        SET categoria_id = LAST_INSERT_ID();
    END IF;

    -- insere o novo produto com o id da categoria
    INSERT INTO Produto (nome, descricao, preco_compra, preco_venda, quantidade_estoque, categoria_id)
    VALUES (nome_produto, descricao, preco_compra, preco_venda, quantidade_estoque, categoria_id);

END;
