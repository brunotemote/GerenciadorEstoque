CREATE TRIGGER trigger_baixo_estoque
AFTER UPDATE ON Produto
FOR EACH ROW
BEGIN
    IF NEW.quantidade_estoque < 10 THEN
        INSERT INTO AlertaEstoque (produto_id, mensagem)
        VALUES (NEW.id, CONCAT('Estoque baixo para o produto: ', NEW.nome));
    END IF;
END;