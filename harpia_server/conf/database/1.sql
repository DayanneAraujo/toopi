DROP DATABASE IF EXISTS `harpia`;

CREATE DATABASE `harpia` CHARSET=UTF8;

USE harpia;

create table licitacao (
  id BIGINT AUTO_INCREMENT NOT NULL,
  dataAberturaProposta                     VARCHAR(25),
  dataEntregaEdital                      VARCHAR(25),
  dataProposta                      VARCHAR(25),
  dataPublicação                      VARCHAR(25),
  endereçoEntrgaEdital                     VARCHAR(25),
  funcaoResponsavel                      VARCHAR(255),
  identificador                      VARCHAR(25),
  infoGeral                      VARCHAR(255),
  modalidade                      VARCHAR(25),
  nomeResponsavel                    VARCHAR(255),
  numeroAviso                     VARCHAR(255),
  numeroItens                      VARCHAR(255),
  numeroProcesso                     VARCHAR(25),
  objeto                      VARCHAR(255),
  situacaoAviso                      VARCHAR(25),
  tipoPregao                          VARCHAR(25),
  tipoRecurso                          VARCHAR(25),
  uasg                          VARCHAR(255),
  descricaoItem                          VARCHAR(555),
  quantidateValorEstimadoItem                         VARCHAR(25),
  descricaoDetalhadaItem                          VARCHAR(755),
  margemPreferencial                          VARCHAR(255),
  situacaoItem                          VARCHAR(255),
  menorLance                          VARCHAR(255),
  decreto7174                          VARCHAR(25),
  fornecedorVencedor                          VARCHAR(255),
  tratamentoDiferenciado                          VARCHAR(25),
  unidadeFornecimento                         VARCHAR(25),
  valorNegociado                          VARCHAR(25),
  url                          VARCHAR(255),
    primary key (id)
)