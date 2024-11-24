-- cria um trigger chamado trigger_movimentacao_estoque
CREATE TRIGGER trigger_movimentacao_estoque
AFTER UPDATE ON Produto  -- executa o trigger apos uma atualizacao na tabela Produto
FOR EACH ROW  -- executa o trigger para cada linha atualizada
BEGIN
    -- verifica se a quantidade em estoque aumentou
    IF NEW.quantidade_estoque > OLD.quantidade_estoque THEN
        -- insere uma movimentacao de entrada na tabela Movimentacao
        INSERT INTO Movimentacao (produto_id, tipo_movimentacao, quantidade)
        VALUES (NEW.id, 'entrada', NEW.quantidade_estoque - OLD.quantidade_estoque);
    -- verifica se a quantidade em estoque diminuiu
    ELSEIF NEW.quantidade_estoque < OLD.quantidade_estoque THEN
        -- insere uma movimentacao de saida na tabela Movimentacao
        INSERT INTO Movimentacao (produto_id, tipo_movimentacao, quantidade)
        VALUES (NEW.id, 'saida', OLD.quantidade_estoque - NEW.quantidade_estoque);
    END IF;
END;
