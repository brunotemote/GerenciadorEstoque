CREATE TRIGGER trigger_relatorio_produtos_update
AFTER UPDATE ON Produto
FOR EACH ROW
BEGIN
    DECLARE categoria_nome VARCHAR(255);

    -- Obtém o nome da categoria do produto
    SELECT nome INTO categoria_nome
    FROM Categoria
    WHERE id = NEW.categoria_id;

    -- Insere ou atualiza o relatório de produtos

    INSERT INTO RelatorioProdutos (produto_id, nome, descricao, quantidade_estoque, preco_compra, preco_venda, categoria_nome)
    VALUES (NEW.id, NEW.nome, NEW.descricao, NEW.quantidade_estoque, NEW.preco_compra, NEW.preco_venda, categoria_nome)
    ON DUPLICATE KEY UPDATE
        nome = NEW.nome,
        descricao = NEW.descricao,
        quantidade_estoque = NEW.quantidade_estoque,
        preco_compra = NEW.preco_compra,
        preco_venda = NEW.preco_venda,
        categoria_nome = categoria_nome,
        data_movimentacao = CURRENT_TIMESTAMP;
END;