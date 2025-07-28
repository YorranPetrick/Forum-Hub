-- Tabela de autores
CREATE TABLE autor (
    id VARCHAR(200) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL
);

-- Tabela de tópicos
CREATE TABLE topico (
    id VARCHAR(200) PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    mensagem TEXT NOT NULL,
    autor_id VARCHAR(200) NOT NULL,
    FOREIGN KEY (autor_id) REFERENCES autor(id)
);