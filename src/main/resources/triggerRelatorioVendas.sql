-- cria um trigger chamado trigger_relatorio_vendas
CREATE TRIGGER trigger_relatorio_vendas
AFTER INSERT ON Movimentacao  -- executa o trigger apos uma insercao na tabela Movimentacao
FOR EACH ROW  -- executa o trigger para cada linha inserida
BEGIN
    DECLARE preco_compra DECIMAL(10, 2);  -- variavel para armazenar o preco de compra do produto
    DECLARE preco_venda DECIMAL(10, 2);  -- variavel para armazenar o preco de venda do produto
    DECLARE lucro_unitario DECIMAL(10, 2);  -- variavel para armazenar o lucro unitario do produto

    -- calcula o lucro por unidade vendida
    SELECT preco_compra, preco_venda INTO preco_compra, preco_venda
    FROM Produto
    WHERE id = NEW.produto_id;

    SET lucro_unitario = preco_venda - preco_compra;

    -- atualiza o relatorio apenas para vendas (saidas)
    IF NEW.tipo_movimentacao = 'saida' THEN
        INSERT INTO RelatorioVendas (produto_id, nome_produto, quantidade_vendida, lucro_total)
        VALUES (NEW.produto_id,
                (SELECT nome FROM Produto WHERE id = NEW.produto_id),
                NEW.quantidade,
                NEW.quantidade * lucro_unitario)
        ON DUPLICATE KEY UPDATE  -- se ja existir um relatorio para o produto, atualiza os dados
            quantidade_vendida = quantidade_vendida + NEW.quantidade,
            lucro_total = lucro_total + (NEW.quantidade * lucro_unitario);
    END IF;
END;
