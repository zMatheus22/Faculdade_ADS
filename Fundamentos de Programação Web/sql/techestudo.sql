DROP database IF EXISTS techestudo; 
CREATE DATABASE techestudo;

USE techestudo;

-- Tabela de Categorias
CREATE TABLE categorias (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
)charset=utf8;

-- Tabela de Produtos
CREATE TABLE produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    preco DECIMAL(10, 2) NOT NULL,
    categoria_id INT,
    FOREIGN KEY (categoria_id) REFERENCES categorias(id)
)charset=utf8;

-- Tabela de Usuários
CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    cargo ENUM('admin', 'usuario') DEFAULT 'usuario'
)charset=utf8;

-- Inserção de Dados nas Tabelas
-- Inserindo categorias
INSERT INTO categorias (nome) VALUES ('Laptops'), ('Tablets'), ('Acessórios');

-- Inserindo produtos
INSERT INTO produtos (nome, descricao, preco, categoria_id) VALUES 
('Laptop para Estudantes', 'Laptop ideal para estudos', 2500.00, 1),
('Tablet para Anotações', 'Tablet perfeito para anotações e leitura', 1500.00, 2),
('Mouse Ergonômico', 'Mouse confortável para uso prolongado', 100.00, 3),
('Teclado Mecânico', 'Teclado com switches mecânicos', 200.00, 3),
('Capa para Tablet', 'Capa protetora para tablet', 50.00, 2);


-- Inserindo usuários
INSERT INTO usuarios (nome, email, senha, cargo) VALUES 
('João Silva', 'joao@example.com', MD5('senha123'), 'admin'),
('Maria Oliveira', 'maria@example.com', MD5('senha456'), 'usuario'),
('Carlos Souza', 'carlos@example.com', MD5('senha789'), 'usuario'),
('Ana Paula', 'ana@example.com', MD5('senha101112'), 'usuario'),
('Pedro Santos', 'pedro@example.com', MD5('senha131415'), 'usuario'),
('Mariana Lima', 'mariana@example.com', MD5('senha161718'), 'admin');