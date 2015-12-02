DROP TABLE IF EXISTS `licitacao`;


create table licitacao (

  id BIGINT AUTO_INCREMENT NOT NULL,
  data_abertura_proposta	DATETIME,
  data_entrega_edital	DATETIME,
  data_entrega_proposta	DATETIME,
  data_publicacao	DATE,
  endereco_entrega_edital VARCHAR(1000),
  funcao_responsavel	VARCHAR(700),
  identificador	VARCHAR(100),
  informacoes_gerais	VARCHAR(1000),
  modalidade	VARCHAR(500),
  nome_responsavel	VARCHAR(500),
  numero_aviso	INTEGER,
  numero_itens	INTEGER,
  numero_processo	INTEGER,
  objeto	VARCHAR(500),
  situacao_aviso	VARCHAR(500),
  tipo_pregao	VARCHAR(500),
  tipo_recurso	VARCHAR(500),
  uasg	VARCHAR(500),

    primary key (id)

);


create table itenslicitacao(

    id BIGINT AUTO_INCREMENT NOT NULL,
    beneficio VARCHAR(500),
    cnpj_fornecedor VARCHAR(100),
    codigo_item_material VARCHAR(250),
    codigo_item_servico VARCHAR(250),
    cpfVencedor VARCHAR(100),
    criterio_julgamento VARCHAR(500),
    decreto_7174 VARCHAR(100),
    descricao_item VARCHAR(700),
    modalidade VARCHAR(500),
    numero_aviso INTEGER,
    numero_item_licitacao INTEGER,
    numero_licitacao INTEGER,
    quantidade INTEGER,
    sustentavel VARCHAR(100),
    uasg VARCHAR(250),
    unidade VARCHAR(250),
    valor_estimado FLOAT,
    situacao VARCHAR(250),

    primary key (id),
    FOREIGN KEY (numero_licitacao) REFERENCES licitacao (identificador)


)