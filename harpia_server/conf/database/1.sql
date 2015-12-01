DROP DATABASE IF EXISTS `harpia`;

CREATE DATABASE `harpia` CHARSET=UTF8;

USE harpia;

create table licitacao (
  id BIGINT AUTO_INCREMENT NOT NULL,
  dataAberturaProposta                     DATETIME,
  dataEntregaEdital                      DATETIME,
  dataProposta                      DATETIME,
  dataPublicação                      DATE,
  endereçoEntrgaEdital                     VARCHAR(25),
  funcaoResponsavel                      VARCHAR(255),
  identificador                      VARCHAR(25),
  infoGeral                      VARCHAR(255),
  modalidade                      INTEGER,
  nomeResponsavel                    VARCHAR(255),
  numeroAviso                     INTEGER,
  numeroItens                      INTEGER,
  numeroProcesso                     VARCHAR(25),
  objeto                      VARCHAR(255),
  situacaoAviso                      VARCHAR(25),
  tipoPregao                          VARCHAR(25),
  tipoRecurso                          VARCHAR(25),
  uasg                          VARCHAR(255),
  descricaoItem                          VARCHAR(555),
  quantidateItem                            INTEGER,
  valorEstimadoItem                         FLOAT,
  descricaoDetalhadaItem                          VARCHAR(755),
  margemPreferencial                          VARCHAR(255),
  situacaoItem                          VARCHAR(255),
  menorLance                          FLOAT,
  decreto7174                          VARCHAR(25),
  fornecedorVencedor                          VARCHAR(255),
  tratamentoDiferenciado                          VARCHAR(25),
  unidadeFornecimento                         VARCHAR(25),
  valorNegociado                          Float,
  url                                    VARCHAR(100),
  situacao                                VARCHAR(25),
    primary key (id)
);


INSERT INTO `harpia`.`licitacao` (`id`, `dataAberturaProposta`, `dataEntregaEdital`, `dataProposta`,
                                  `dataPublicação`, `endereçoEntrgaEdital`, `funcaoResponsavel`, `identificador`, `infoGeral`,
                                  `modalidade`, `nomeResponsavel`, `numeroAviso`, `numeroItens`, `numeroProcesso`, `objeto`, `situacaoAviso`,
                                  `tipoPregao`, `tipoRecurso`, `uasg`, `descricaoItem`, `quantidateItem`, `valorEstimadoItem`, `descricaoDetalhadaItem`,
                                  `margemPreferencial`, `situacaoItem`, `menorLance`, `decreto7174`, `fornecedorVencedor`, `tratamentoDiferenciado`,
                                  `unidadeFornecimento`, `valorNegociado`, `url`, `situacao`)
VALUES (NULL, '2013-03-15 08:30:00', '2013-03-05 08:30:00', '2013-03-05 08:30:00', '2013-03-05',
        'Rua do Imperio, S/nº - Santa Cruz/RJ', 'Ordenador de Despesas', '12003105000012000',
        NULL, '5', 'SERGIO BARROS DE OLIVEIRA', '12013', 0, '67243004439201300',
        'Pregão Eletrônico Registro de preços para eventual aquisição de Gêneros Alimentício s.', 'Publicado', 'Eletrônico', 'Nacional', '120031
', 'GRUPO 4
', '0', '100070.00', 'GRUPO 1
', 'false
', 'homologado
', '785525.00', NULL, NULL, NULL, NULL, 0, '/pregoes/doc/pregao/1200310000012013', 'NORMAL');