-- cria um trigger chamado trigger_relatorio_produtos_insert
CREATE TRIGGER trigger_relatorio_produtos_insert
AFTER INSERT ON Produto  -- executa o trigger apos uma insercao na tabela Produto
FOR EACH ROW  -- executa o trigger para cada linha inserida
BEGIN
    DECLARE categoria_nome VARCHAR(255);  -- variavel para armazenar o nome da categoria

    -- obtem o nome da categoria do produto
    SELECT nome INTO categoria_nome
    FROM Categoria
    WHERE id = NEW.categoria_id;

    -- insere ou atualiza o relatorio de produtos
    INSERT INTO RelatorioProdutos (produto_id, nome, descricao, quantidade_estoque, preco_compra, preco_venda, categoria_nome)
    VALUES (NEW.id, NEW.nome, NEW.descricao, NEW.quantidade_estoque, NEW.preco_compra, NEW.preco_venda, categoria_nome)
    ON DUPLICATE KEY UPDATE  -- se ja existir um relatorio para o produto, atualiza os dados
        nome = NEW.nome,
        descricao = NEW.descricao,
        quantidade_estoque = NEW.quantidade_estoque,
        preco_compra = NEW.preco_compra,
        preco_venda = NEW.preco_venda,
        categoria_nome = categoria_nome,
        data_movimentacao = CURRENT_TIMESTAMP;
END;
