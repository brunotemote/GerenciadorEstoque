-- cria um trigger chamado trigger_baixo_estoque
CREATE TRIGGER trigger_baixo_estoque
AFTER UPDATE ON Produto  -- executa o trigger apos uma atualizacao na tabela Produto
FOR EACH ROW  -- executa o trigger para cada linha atualizada
BEGIN
    -- verifica se a quantidade em estoque do produto e menor que 10
    IF NEW.quantidade_estoque < 10 THEN
        -- insere um alerta na tabela alertaestoque
        INSERT INTO AlertaEstoque (produto_id, mensagem)
        VALUES (NEW.id, CONCAT('Estoque baixo para o produto: ', NEW.nome));
    END IF;
END;
