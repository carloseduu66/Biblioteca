-- Criação da tabela administrador
CREATE TABLE administrador (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(30) NOT NULL,
    cargo VARCHAR(30) NOT NULL,
    genero VARCHAR(20) NOT NULL,
    login VARCHAR(30) NOT NULL,
    senha VARCHAR(30) NOT NULL
);

-- Inserção de dados na tabela administrador
INSERT INTO administrador (nome, cargo, genero, login, senha) VALUES
('Carlos Eduardo', 'Coordenador', 'Masculino', 'carlos', '123');

-- Criação da tabela aluno
CREATE TABLE aluno (
    nome VARCHAR(30) NOT NULL,
    matricula VARCHAR(20) NOT NULL,
    email VARCHAR(20) NOT NULL,
    login VARCHAR(20) NOT NULL,
    senha VARCHAR(20) NOT NULL,
    genero VARCHAR(10) NOT NULL,
    curso VARCHAR(30) NOT NULL
);

-- Criação da tabela emprestimo
CREATE TABLE emprestimo (
    id SERIAL PRIMARY KEY,
    nome_aluno VARCHAR(30) NOT NULL,
    nome_livro VARCHAR(30) NOT NULL,
    data_inicial VARCHAR(30) NOT NULL,
    data_final VARCHAR(30) NOT NULL
);

-- Criação da tabela livro
CREATE TABLE livro (
    codigo SERIAL PRIMARY KEY,
    titulo VARCHAR(30) NOT NULL,
    autor VARCHAR(30) NOT NULL,
    genero VARCHAR(30) NOT NULL
);
