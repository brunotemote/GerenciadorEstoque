CREATE TRIGGER trigger_relatorio_vendas
AFTER INSERT ON Movimentacao
FOR EACH ROW
BEGIN
    DECLARE preco_compra DECIMAL(10, 2);
    DECLARE preco_venda DECIMAL(10, 2);
    DECLARE lucro_unitario DECIMAL(10, 2);

    -- Calcula o lucro por unidade vendida
    SELECT preco_compra, preco_venda INTO preco_compra, preco_venda
    FROM Produto
    WHERE id = NEW.produto_id;

    SET lucro_unitario = preco_venda - preco_compra;

    -- Atualiza o relatório apenas para vendas (saídas)
    IF NEW.tipo_movimentacao = 'saida' THEN
        INSERT INTO RelatorioVendas (produto_id, nome_produto, quantidade_vendida, lucro_total)
        VALUES (NEW.produto_id,
                (SELECT nome FROM Produto WHERE id = NEW.produto_id),
                NEW.quantidade,
                NEW.quantidade * lucro_unitario)
        ON DUPLICATE KEY UPDATE
            quantidade_vendida = quantidade_vendida + NEW.quantidade,
            lucro_total = lucro_total + (NEW.quantidade * lucro_unitario);
    END IF;
END;