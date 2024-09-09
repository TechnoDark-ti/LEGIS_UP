-- Tabela Funcionário
CREATE TABLE Funcionario (
  funcionario_id INT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL,
  CPF VARCHAR(11) NOT NULL,
  cargo VARCHAR(50),
  departamento_id INT,
  salario DECIMAL(10,2),
  FOREIGN KEY (departamento_id) REFERENCES Departamento(departamento_id)
);

-- Tabela Departamento
CREATE TABLE Departamento (
  departamento_id INT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(100),
  descricao TEXT
);

-- Tabela Folha de Pagamento
CREATE TABLE Folha_Pagamento (
  folha_id INT PRIMARY KEY AUTO_INCREMENT,
  funcionario_id INT,
  mes INT,
  ano INT,
  valor_bruto DECIMAL(10,2),
  valor_liquido DECIMAL(10,2),
  descontos DECIMAL(10,2),
  FOREIGN KEY (funcionario_id) REFERENCES Funcionario(funcionario_id)
);

-- Tabela Orçamento
CREATE TABLE Orcamento (
  orcamento_id INT PRIMARY KEY AUTO_INCREMENT,
  ano INT,
  valor_total DECIMAL(10,2)
);

-- Tabela Despesa
CREATE TABLE Despesa (
  despesa_id INT PRIMARY KEY AUTO_INCREMENT,
  orcamento_id INT,
  valor DECIMAL(10,2),
  descricao TEXT,
  data DATE,
  FOREIGN KEY (orcamento_id) REFERENCES Orcamento(orcamento_id)
);

-- Tabela Receita
CREATE TABLE Receita (
  receita_id INT PRIMARY KEY AUTO_INCREMENT,
  orcamento_id INT,
  valor DECIMAL(10,2),
  descricao TEXT,
  data DATE,
  FOREIGN KEY (orcamento_id) REFERENCES Orcamento(orcamento_id)
);

-- Tabela Sessão
CREATE TABLE Sessao (
  sessao_id INT PRIMARY KEY AUTO_INCREMENT,
  data DATE,
  pauta TEXT,
  ata TEXT,
  status VARCHAR(20)
);

-- Tabela Votação
CREATE TABLE Votacao (
  votacao_id INT PRIMARY KEY AUTO_INCREMENT,
  sessao_id INT,
  funcionario_id INT,
  voto VARCHAR(10),
  justificativa TEXT,
  FOREIGN KEY (sessao_id) REFERENCES Sessao(sessao_id),
  FOREIGN KEY (funcionario_id) REFERENCES Funcionario(funcionario_id)
);

-- Tabela Protocolo
CREATE TABLE Protocolo (
  protocolo_id INT PRIMARY KEY AUTO_INCREMENT,
  funcionario_id INT,
  data_abertura DATE,
  descricao TEXT,
  status VARCHAR(20),
  FOREIGN KEY (funcionario_id) REFERENCES Funcionario(funcionario_id)
);

-- Tabela Patrimônio
CREATE TABLE Patrimonio (
  patrimonio_id INT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(100),
  descricao TEXT,
  valor DECIMAL(10,2),
  data_aquisicao DATE
);

-- Tabela Fornecedor
CREATE TABLE Fornecedor (
  fornecedor_id INT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(100),
  CNPJ VARCHAR(14),
  contato VARCHAR(100)
);

-- Tabela Pedido de Compra
CREATE TABLE Pedido_Compra (
  pedido_id INT PRIMARY KEY AUTO_INCREMENT,
  fornecedor_id INT,
  patrimonio_id INT,
  quantidade INT,
  valor_total DECIMAL(10,2),
  data_pedido DATE,
  FOREIGN KEY (fornecedor_id) REFERENCES Fornecedor(fornecedor_id),
  FOREIGN KEY (patrimonio_id) REFERENCES Patrimonio(patrimonio_id)
);
