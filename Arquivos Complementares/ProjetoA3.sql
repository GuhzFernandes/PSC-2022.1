CREATE DATABASE ProjetoA3;
USE ProjetoA3;

CREATE TABLE Usuarios(
  Usuario VARCHAR (20) NOT NULL,
  Senha VARCHAR (20) NOT NULL,
  Adm BIT NOT NULL,
  UNIQUE (Usuario),
  PRIMARY KEY (Usuario)
);

CREATE TABLE Produtos(
  IdProduto INT NOT NULL AUTO_INCREMENT,
  Marca VARCHAR (25) NOT NULL,
  Nome VARCHAR (50) NOT NULL,
  Preco DECIMAL (5,2) NOT NULL,
  QuantidadeEstoque INT DEFAULT 0,
  PRIMARY KEY (IdProduto)
);

CREATE TABLE Vendas(
  IdVenda INT NOT NULL AUTO_INCREMENT,
  Produto INT,
  PrecoUnitario DECIMAL(5,2),
  QuantidadeVendida INT NOT NULL,
  DataVenda DATETIME NOT NULL,
  PRIMARY KEY (IdVenda),
  FOREIGN KEY (Produto) REFERENCES Produtos(IdProduto)
);

CREATE TABLE Recebidos(
  IdRecebimento INT NOT NULL AUTO_INCREMENT,
  Produto INT,
  QuantidadeRecebida INT NOT NULL,
  DataRecebimento DATETIME NOT NULL,
  PRIMARY KEY (IdRecebimento),
  FOREIGN KEY (Produto) REFERENCES Produtos(IdProduto)
);

INSERT INTO Usuarios (Usuario,Senha,Adm)
VALUES 
('ADM', 'ADM', 1),
('Gabriel', '125111364427', 0),
('Gustavo', '125111346229', 0),
('Isabelle', '125111376379', 0),
('Milena', '125111350681', 0),
('Vinicius', '125111349444', 0);

INSERT INTO Produtos (Marca,Nome,Preco,QuantidadeEstoque)
VALUES
('Fini','Tubes Morango Azedinho 80g',5.70,50),
('Fini','Tubes Uva Azedinho 80g',5.70,50),
('Fini','Tubes Tutti Frutti Azedinho 80g',5.70,50),
('Fini','Tubes Morango 80g',5.70,50),
('Fini','Tubes Uva 80g',5.70,50),
('Fini','Tubes Iogurte 27g',1.80,50),
('Fini','Alvorada 80g',4.30,30),
('Fini','Torçao 80g',4.30,30),
('Fini','Coracao 80g',4.30,30),
('Fini', 'Bananas 90g',4.30,50),
('Fini', 'Aros de Morango Azedinhos 90g',4.30,50),
('Fini', 'Amoras 90g',4.30,50),
('Fini', 'Beijos de Morango 90g',4.30,50),
('Fini', 'Ovos Fritos 90g',4.30,50),
('Fini', 'Minhocas Azedinhas 90g',4.30,50),
('Fini', 'Dentaduras Azedinhas 90g',4.30,50),
('Fini', 'Dentaduras 90g',4.30,50),
('Fini', 'Salada de Frutas Azedinhas 80g',4.30,30),

('Nestle','Kitkat Dark 41,5g',3.90,50),
('Nestle','Kitkat Ao Leite 41,5g',3.90,50),
('Nestle','Kitkat Branco 41,5g',3.90,50),

('Santa Helena', 'Pacoquita 20g',0.99,250),
('Santa Helena', 'Pacoquita 20g',0.99,250),

('Lacta', 'Bombom de chocolate Sonho de Valsa 20g', 1.20, 100),
('Lacta', 'Bombom de Chocolate Ouro Branco 20g', 1.20, 100),

('Halls', 'Bala de Melancia 34g', 2.50, 50),
('Halls', 'Bala de Morango 34g', 2.50, 50),
('Halls', 'Bala de Cereja 34g', 2.50, 50),
('Halls', 'Bala de Uva Verde 34g', 2.50, 50),
('Halls', 'Bala de Menta extra forte 34g', 2.50, 50),

('Trident', 'Goma de Mascar de Menta 8g', 2.19, 50),
('Trident', 'Goma de Mascar de Hortela 8g', 2.19, 50),
('Trident', 'Goma de Mascar de Melancia 8g', 2.19, 50),
('Trident', 'Goma de Mascar de Canela 8g', 2.19, 50),
('Trident', 'Goma de Mascar de Tutti Frutti 8g', 2.19, 50),
('Trident', 'Goma de Mascar de Morango 8g', 2.19, 50);

