-- FUNÇÕES PARA LITERAL
select CONCAT('BANCO',' DE',' DADOS')
select INSERT('BANCO    DADOS',7,2,'DE')
select INSTR('BANCO DE DADOS', 'DADOS');
select LCASE('BANCO de DADOS');
select UCASE('banco de dados');
select UPPER('banco de dados');
select TRIM(' BANCO DE DADOS ');
select LTRIM(' Banco de Dados ');
select RTRIM(' Banco de Dados ');

-- FUNÇÕES PARA DATA/HORA
select CURDATE(); -- retorna a data
select CURTIME(); -- retorna o tempo
select NOW(); -- retorna a data e o tempo
select YEAR(CURDATE()); -- retorna o ano de uma data
select ADDDATE(CURDATE(),60); -- retorna uma data mais dias como parâmetro
select DAYOFWEEK(CURDATE()+1); -- retorna o dia da semana de hoje mais 1, se for quinta, retorna sexta
select DATEDIFF(CURDATE(),'1974-04-06'); -- retorna a diferença entre anos
select DATE_FORMAT("2017-06-15", "%d %m %Y"); -- formata a data
select DATE_FORMAT(CURDATE(),'%W,%M of %Y'); --

DELIMITER $$
CREATE OR REPLACE FUNCTION fc_tempo_servico (data DATE) RETURNS INTEGER
BEGIN
	DECLARE resultado INTEGER DEFAULT 0;
	
	SET resultado = YEAR(CURDATE()) - YEAR(DATA);
	
	IF resultado > 0 THEN
		RETURN resultado;
	END IF;
	
	RETURN 0;
END $$ 

SELECT fc_tempo_servico('3000-03-03');

DELIMITER $$
CREATE OR REPLACE PROCEDURE pc_atualiza_valor_medicamento
	(IN percentual INTEGER, OUT preco DECIMAL(8,2))
BEGIN
	SELECT vl_venda FROM medicamento
		WHERE cd_medicamento = 1 INTO preco;
END $$

SET @preco_retorno = 0.0;
SELECT @preco_retorno;

SELECT * FROM medicamento;
CALL pc_atualiza_valor_medicamento(1, @preco_retorno);
SELECT @preco_retorno;

-- rotina equivalente, porém do tipo "function", em substituição a procedure

DELIMITER $$
CREATE OR REPLACE FUNCTION fc_obter_preco_medicamento (id_medicamento INTEGER) RETURNS DECIMAL(8,2)
BEGIN
  DECLARE valor DECIMAL(8,2);
  SET valor = (SELECT vl_venda FROM medicamento WHERE cd_medicamento = id_medicamento);
  RETURN valor;
END $$

-- exemplo de chamada para obter o preço do produto cd = 3

SELECT fc_obter_preco_medicamento(3);

-- rotina para iniciar/criar uma "nota fiscal", retornando o "id" da mesma
DELIMITER $$
CREATE OR REPLACE FUNCTION fc_cria_nf() RETURNS INTEGER
BEGIN
	INSERT INTO notafiscal (dt_emissao, vl_total)
		VALUES(CURDATE(), 0.0);
	RETURN LAST_INSERT_ID();
END $$

DELETE FROM itemnotafiscal;
DELETE FROM notafiscal;
SELECT * FROM notafiscal;
SELECT * FROM itemnotafiscal;

SELECT fc_cria_nf();

-- rotina para inserir itens na nota fiscal, passando como parâmetros id nota, medicamento e quantidade
DELIMITER $$
CREATE OR REPLACE PROCEDURE pc_insere_item_nf (IN nota INTEGER, IN medic INTEGER, IN qtde INTEGER)
BEGIN
	INSERT INTO itemnotafiscal (nr_notafiscal, cd_medicamento, qt_vendida, vl_produto)
		VALUES(nota, medic, qtde, fc_obter_preco_medicamento(medic));
END $$

-- executando a procedure
CALL pc_insere_item_nf (3, 3, 1);

DELIMITER $$
CREATE OR REPLACE TRIGGER tg_itemnotafiscal_atualiza_estoque BEFORE INSERT
ON itemnotafiscal
FOR EACH ROW
BEGIN
  -- declrando uma variável para o estoque do produto (tabela medicamento)
  DECLARE var_estoque INT DEFAULT 0;
  -- atribuindo o valor à variável
  SET var_estoque = (SELECT qt_estoque FROM medicamento WHERE cd_medicamento = NEW.cd_medicamento);
  -- ou
  --  SELECT qt_estoque INTO var_estoque FROM medicamento WHERE cd_medicamento = NEW.cd_medicamento;
  if NEW.qt_vendida > var_estoque THEN
    SET NEW.qt_vendida = var_estoque;
  END IF;
  UPDATE medicamento
    SET  qt_estoque = qt_estoque - NEW.qt_vendida
    WHERE cd_medicamento = NEW.cd_medicamento;
  UPDATE notafiscal
    SET vl_total = vl_total + (NEW.qt_vendida * new.vl_produto)
    WHERE nr_notafiscal = NEW.nr_notafiscal;  
END $$

DELIMITER $$
CREATE OR REPLACE PROCEDURE pc_calcula_desconto
       (IN medic INTEGER, IN desconto DECIMAL(4,2), INOUT preco DECIMAL(8,2))
BEGIN
    SELECT vl_venda FROM medicamento
WHERE cd_medicamento = medic INTO preco;
    SET preco = preco - (preco * desconto /100);
END$$

SET @novo_preco = 0.0;
CALL pc_calcula_desconto(4, 15.5, @novo_preco);
SELECT @novo_preco;

SELECT * FROM medicamento;

DELIMITER $$
CREATE OR REPLACE PROCEDURE pc_totaliza_inventario (OUT resultado DECIMAL(8,2))
BEGIN
   -- Definição da variável de controle da estrutura – final da mesma
   DECLARE final_loop INT DEFAULT 1;
   -- Definição da variável que mantém o preço do produto (obtido da estrutura do cursor)
   DECLARE produto_estoque INT DEFAULT 0;
   -- Definição da variável que mantém o valor do produto (obtido da estrutura do cursor)
   DECLARE produto_valor DECIMAL(8,2) DEFAULT 0.0;
   -- Definição da variável que totalização o inventário
   DECLARE total_inventario DECIMAL(8,2) DEFAULT 0.0;
   -- Definição do cursor com a instrução SELECT que irá gerar a estrutura em memória
   DECLARE cursor_estoque CURSOR FOR SELECT qt_estoque, vl_custo FROM medicamento;
   -- Definição de quando o LOOP chegar no final será mudado o estado da variável
   DECLARE CONTINUE HANDLER FOR NOT FOUND SET final_loop=0;
   -- abertura do cursor
   OPEN cursor_estoque;
   -- Looping para percorrer o cursor
   loop_cursor: LOOP
       -- atribuição dos valores da estrutura (cursor) para as variáveis de manipulação
       FETCH cursor_estoque INTO produto_estoque, produto_valor;
       -- controle de existir mais registros na estrutura em memória (cursor)
       IF final_loop = 0 THEN
           LEAVE loop_cursor;
       END IF;
       -- soma o estoque x valor com o total acumulado
       SET total_inventario = total_inventario + (produto_estoque * produto_valor);
   END LOOP loop_cursor;
   -- Setando a variável com o resultado final
   SET resultado = total_inventario;
   -- Fechamento do cursor
   CLOSE cursor_estoque;
END $$

SET @resultado = 0.0;
CALL pc_totaliza_inventario(@resultado);
SELECT @resultado;

DELIMITER $$
CREATE OR REPLACE function fc_totaliza_inventario () RETURNS DECIMAL(8,2)
BEGIN
   -- Definição da variável de controle da estrutura – final da mesma
   DECLARE final_loop INT DEFAULT 1;
   -- Definição da variável que mantém o preço do produto (obtido da estrutura do cursor)
   DECLARE produto_estoque INT DEFAULT 0;
   -- Definição da variável que mantém o valor do produto (obtido da estrutura do cursor)
   DECLARE produto_valor DECIMAL(8,2) DEFAULT 0.0;
   -- Definição da variável que totalização o inventário
   DECLARE total_inventario DECIMAL(8,2) DEFAULT 0.0;
   -- Definição do cursor com a instrução SELECT que irá gerar a estrutura em memória
   DECLARE cursor_estoque CURSOR FOR SELECT qt_estoque, vl_custo FROM medicamento;
   -- Definição de quando o LOOP chegar no final será mudado o estado da variável
   DECLARE CONTINUE HANDLER FOR NOT FOUND SET final_loop=0;
   -- abertura do cursor
   OPEN cursor_estoque;
   -- Looping para percorrer o cursor
   loop_cursor: LOOP
       -- atribuição dos valores da estrutura (cursor) para as variáveis de manipulação
       FETCH cursor_estoque INTO produto_estoque, produto_valor;
       -- controle de existir mais registros na estrutura em memória (cursor)
       IF final_loop = 0 THEN
           LEAVE loop_cursor;
       END IF;
       -- soma o estoque x valor com o total acumulado
       SET total_inventario = total_inventario + (produto_estoque * produto_valor);
   END LOOP loop_cursor;
   -- Fechamento do cursor
   CLOSE cursor_estoque;
   -- setando o valor de retorno da função
   RETURN total_inventario;
END $$
-- abaixo chamada da função
select fc_totaliza_inventario ();
-- abaixo declaração da variável de retorno e chamada da procedure
SET @total = 0.0;
CALL pc_totaliza_inventario (@total) 
-- exibindo o valor da variável usada como parâmetro
SELECT @total, @resultado




















