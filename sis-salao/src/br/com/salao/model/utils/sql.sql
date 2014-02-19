CREATE TABLE categoria (
  codigo INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  descricao VARCHAR(200) NOT NULL,
  PRIMARY KEY(codigo)
);

CREATE TABLE servico (
  codigo INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  categoria_codigo INTEGER UNSIGNED NOT NULL,
  descricao VARCHAR(255) NOT NULL,
  preco DOUBLE NOT NULL,
  PRIMARY KEY(codigo),
  INDEX servico_FKIndex1(categoria_codigo)
);

CREATE TABLE cliente_servico (
  codigo INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  cliente_codigo INTEGER UNSIGNED NOT NULL,
  servico_codigo INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(codigo),
  INDEX cliente_servico_FKIndex1(servico_codigo),
  INDEX cliente_servico_FKIndex2(cliente_codigo)
);

CREATE TABLE cliente (
  codigo INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  endereco_codigo INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(255) NOT NULL,
  telefone INTEGER UNSIGNED NULL,
  celular INTEGER UNSIGNED NULL,
  rg INTEGER UNSIGNED NULL,
  cpf INTEGER UNSIGNED NULL,
  email VARCHAR(100) NULL,
  PRIMARY KEY(codigo),
  INDEX cliente_FKIndex1(endereco_codigo)
);

CREATE TABLE endereco (
  codigo INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  cidade_codigo INTEGER UNSIGNED NOT NULL,
  rua VARCHAR(255) NOT NULL,
  complemento VARCHAR(255) NULL,
  numero INTEGER UNSIGNED NULL,
  bairro VARCHAR(50) NOT NULL,
  cep INTEGER(10) UNSIGNED NULL,
  PRIMARY KEY(codigo),
  INDEX endereco_FKIndex1(cidade_codigo)
);

CREATE TABLE cidade (
  codigo INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  estado_codigo INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(50) NOT NULL,
  sigla VARCHAR(2) NULL,
  PRIMARY KEY(codigo),
  INDEX cidade_FKIndex1(estado_codigo)
);

CREATE TABLE estado (
  codigo INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  pais_codigo INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(50) NOT NULL,
  sigla VARCHAR(2) NULL,
  PRIMARY KEY(codigo),
  INDEX estado_FKIndex1(pais_codigo)
);

CREATE TABLE pais (
  codigo INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) NOT NULL,
  sigla VARCHAR(2) NULL,
  PRIMARY KEY(codigo)
);

CREATE TABLE usuarios (
  codigo INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  login VARCHAR(50) NOT NULL,
  senha VARCHAR(50) NOT NULL,
  ativo BOOL NOT NULL,
  PRIMARY KEY(codigo)
);


SELECT servico.*, categoria.descricao FROM servico INNER JOIN 
categoria ON servico.categoria_codigo = categoria.codigo WHERE
categoria.codigo = 1 ORDER BY servico.descricao ASC
