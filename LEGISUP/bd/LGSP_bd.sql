CREATE DATABASE IF NOT EXISTS LGSP_bd;

USE LGSP_bd;

DROP DATABASE LGSP_bd;

CREATE TABLE IF NOT EXISTS Departamento (
  departamento_id INT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(100),
  descricao TEXT
);

CREATE TABLE IF NOT EXISTS Funcionario (
  cpf BIGINT(11) PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  cargo VARCHAR(50),
  departamento_id INT NOT NULL,
  salario DECIMAL(10,2),
    
  FOREIGN KEY (departamento_id) REFERENCES Departamento(departamento_id)
);
-- dar razionho
CREATE TABLE IF NOT EXISTS Folha_Pagamento (
  folha_id INT PRIMARY KEY AUTO_INCREMENT,
  cpf_fk INT,
  mes INT,
  ano INT,
  valor_bruto DECIMAL(10,2),
  valor_liquido DECIMAL(10,2),
  descontos DECIMAL(10,2),
  FOREIGN KEY (cpf_fk) REFERENCES Funcionario(cpf)
);


CREATE TABLE IF NOT EXISTS Orcamento (
  orcamento_id INT PRIMARY KEY AUTO_INCREMENT,
  ano INT,
  valor_total DECIMAL(10,2)
);

CREATE TABLE IF NOT EXISTS Despesa (
  despesa_id INT PRIMARY KEY AUTO_INCREMENT,
  orcamento_id INT,
  valor DECIMAL(10,2),
  descricao TEXT,
  data DATE,
  FOREIGN KEY (orcamento_id) REFERENCES Orcamento(orcamento_id)
);

CREATE TABLE IF NOT EXISTS Receita (
  receita_id INT PRIMARY KEY AUTO_INCREMENT,
  orcamento_id INT,
  valor DECIMAL(10,2),
  descricao TEXT,
  data DATE,
  FOREIGN KEY (orcamento_id) REFERENCES Orcamento(orcamento_id)
);

CREATE TABLE IF NOT EXISTS Sessao (
  sessao_id INT PRIMARY KEY AUTO_INCREMENT,
  data DATE,
  pauta TEXT,
  ata TEXT,
  status VARCHAR(20)
);
-- dar raiozinho
CREATE TABLE IF NOT EXISTS Votacao (
  votacao_id INT PRIMARY KEY AUTO_INCREMENT,
  sessao_id INT,
  cpf_fk INT,
  voto VARCHAR(10),
  justificativa TEXT,
  FOREIGN KEY (sessao_id) REFERENCES Sessao(sessao_id),
  FOREIGN KEY (cpf_fk) REFERENCES Funcionario(cpf)
);
-- dar raiozinho
CREATE TABLE IF NOT EXISTS Protocolo (
  protocolo_id INT PRIMARY KEY AUTO_INCREMENT,
  cpf_fk INT,
  data_abertura DATE,
  descricao TEXT,
  status VARCHAR(20),
  FOREIGN KEY (cpf_fk) REFERENCES Funcionario(cpf)
);

CREATE TABLE IF NOT EXISTS Patrimonio (
  patrimonio_id INT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(100),
  descricao TEXT,
  valor DECIMAL(10,2),
  data_aquisicao DATE
);

CREATE TABLE IF NOT EXISTS Fornecedor (
  CNPJ INT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(100),
  CNPJ VARCHAR(14),
  contato VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS Pedido_Compra (
  pedido_id INT PRIMARY KEY AUTO_INCREMENT,
  fornecedor_id INT,
  patrimonio_id INT,
  quantidade INT,
  valor_total DECIMAL(10,2),
  data_pedido DATE,
  FOREIGN KEY (fornecedor_id) REFERENCES Fornecedor(fornecedor_id),
  FOREIGN KEY (patrimonio_id) REFERENCES Patrimonio(patrimonio_id)
);
