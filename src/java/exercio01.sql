DROP TABLE contato;

CREATE TABLE contato
(
	id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	nome VARCHAR(50) NOT NULL,
	sobrenome VARCHAR(90) NOT NULL,
	telefone VARCHAR(20) NOT NULL
);

INSERT INTO contato(nome, sobrenome, telefone) VALUES('Fulano', 'da Silva', '555-5555');
