CREATE TABLE autor (
    id SERIAL,
    nome VARCHAR(100),
    idade int,
    PRIMARY KEY (id)
)

CREATE TABLE livro (
    id SERIAL,
    nome VARCHAR(100),
    paginas int,
    PRIMARY KEY (id)
)

CREATE TABLE autoria (
    id SERIAL NOT NULL PRIMARY KEY,
    id_livro int,
    id_autor int,
	FOREIGN KEY (id_livro) REFERENCES livro(id),
	FOREIGN KEY (id_autor) REFERENCES autor(id)
)