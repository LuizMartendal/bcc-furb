-- Criação de usuário chamado user1
CREATE USER USER1 IDENTIFIED BY 'user1';

-- conceder privilégio de SELECT para o usuário
GRANT SELECT ON bd_teste_1.categoria TO USER1;

-- conceder privilégio de create para o usuário
GRANT CREATE ON bd_teste_1.* TO USER1;

-- conceder privilégio total para o usuário
GRANT ALL ON bd_teste_1 to USER1;

-- verificar quais privilégios de um usuário
SHOW GRANTS FOR USER1;

-- revogando privilégios de um usuário
REVOKE INSERT ON bd_teste_1.`*` FROM USER1;

-- conceder privilégio de alteração de uma coluna
GRANT UPDATE(ds_teste) ON bd_teste_1.teste1 TO USER1;

-- criando um papel (role)
CREATE role operador;
-- concedendo privilégio para a role
GRANT DELETE ON bd_teste_1.teste1 TO operador;
-- concedendo privilégio da role para um usuário
GRANT operador TO USER1;
-- indicando o papel (role) padrão para o usuário
SET DEFAULT role operador FOR USER1;

-- Script SQL para criar a tabela de Clientes
CREATE TABLE Clientes (
    IDCliente INT PRIMARY KEY,
    Nome VARCHAR(255),
    Cartao VARCHAR(16), -- Assumindo que o número do cartão é uma string de 16 caracteres
    Senha VARCHAR(255), -- Aqui, a senha seria armazenada como um hash criptografado
    Saldo DECIMAL(10, 2)
);

-- inserindo senha utilizando o método de criptografia MD5
INSERT INTO cliente (cd_cliente, nm_cliente, id_cartao, id_senha, vl_saldo)
				 VALUES (2, 'Cliente 2','22222',MD5('AbC123'),100);
				 
				 -- testando a validade da senha
SELECT nm_cliente, id_cartao, vl_saldo 
FROM cliente
WHERE id_senha = MD5('AbC123'); -- sucesso
 
SELECT nm_cliente, id_cartao, vl_saldo 
FROM cliente
WHERE id_senha = MD5('ABC123'); -- insucesso, senha apresenta o "B" diferente
