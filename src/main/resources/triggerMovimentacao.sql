CREATE TRIGGER trigger_movimentacao_estoque
    AFTER UPDATE ON Produto
    FOR EACH ROW
BEGIN
    IF NEW.quantidade_estoque > OLD.quantidade_estoque THEN
        INSERT INTO Movimentacao (produto_id, tipo_movimentacao, quantidade)
        VALUES (NEW.id, 'entrada', NEW.quantidade_estoque - OLD.quantidade_estoque);
    ELSEIF NEW.quantidade_estoque < OLD.quantidade_estoque THEN
        INSERT INTO Movimentacao (produto_id, tipo_movimentacao, quantidade)
        VALUES (NEW.id, 'saida', OLD.quantidade_estoque - NEW.quantidade_estoque);
    END IF;
END;