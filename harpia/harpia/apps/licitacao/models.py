# -*- coding: utf-8 -*-

from django.db import models


class Licitacao(models.Model):
    dataAberturaProposta = models.DateTimeField(
        verbose_name=u'data de abertura da proposta', null=True, blank=True)
    dataEntregaEdital = models.DateTimeField(
        verbose_name=u'data de entrega do edital', null=True, blank=True)
    dataEntregaProposta = models.DateTimeField(
        verbose_name=u'data de entrega da proposta', null=True, blank=True)
    dataPublicacao = models.DateField(
        verbose_name=u'data de publicacao', null=True, blank=True)
    enderecoEntregaEdital = models.TextField(
        max_length=255, blank=True, null=True)
    funcaoResponsavel = models.TextField(
        max_length=255, blank=True, null=True)
    identificador = models.TextField(
        max_length=255, blank=True, null=True)
    informacoesGerais = models.TextField(
        max_length=255, blank=True, null=True)
    modalidade = models.TextField(
        max_length=255, blank=True, null=True)
    nomeResponsavel = models.TextField(
        max_length=255, blank=True, null=True)
    numeroAviso = models.PositiveIntegerField(u'numero de aviso')
    numeroItens = models.PositiveIntegerField(u'numero de itens')
    numeroProcesso = models.TextField(
        max_length=255, blank=True, null=True)
    objeto = models.TextField(
        max_length=255, blank=True, null=True)
    situacaoAviso = models.TextField(
        max_length=255, blank=True, null=True)
    tipoPregao = models.TextField(
        max_length=255, blank=True, null=True)
    tipoRecurso = models.TextField(
        max_length=255, blank=True, null=True)
    uasg = models.TextField(
        max_length=255, blank=True, null=True)


class ItensLicitacao(models.Model):
    descricao_item = models.TextField(max_length=255, null=True, blank=True)
    valor_estimado_item = models.TextField(
        max_length=255, null=True, blank=True)
    descricao_detalhada_item = models.TextField(
        max_length=255, null=True, blank=True)
    margem_preferencial = models.TextField(
        max_length=255, null=True, blank=True)
    situacao_item = models.TextField(max_length=255, null=True, blank=True)
    menor_lance = models.TextField(max_length=255, null=True, blank=True)
    decreto_7174 = models.TextField(max_length=255, null=True, blank=True)
    fornecedor_vencedor = models.TextField(
        max_length=255, null=True, blank=True)
    tratamento_diferenciado = models.TextField(
        max_length=255, null=True, blank=True)
    unidade_fornecimento = models.TextField(
        max_length=255, null=True, blank=True)
    url_pregao = models.TextField(max_length=255, null=True, blank=True)
    tipo_material = models.TextField(max_length=255, null=True, blank=True)
    quantidade_item = models.TextField(max_length=255, null=True, blank=True)
    situacao = models.TextField(max_length=255, null=True, blank=True)
    valor_negociado = models.FloatField(null=True, blank=True)
    valor_final = models.FloatField(null=True, blank=True)
    valor_item = models.FloatField(null=True, blank=True)
    data_abertura_proposta = models.DateField(
        verbose_name=u'data de abertura da proposta', null=True, blank=True)
    data_entrega_edital = models.DateField(
        verbose_name=u'data de entrega do edital', null=True, blank=True)
    data_entrega_proposta = models.DateField(
        verbose_name=u'data de entrega da proposta', null=True, blank=True)
    data_publicacao = models.DateField(
        verbose_name=u'data de publicacao', null=True, blank=True)
    endereco_entrega_edital = models.TextField(
        max_length=255, blank=True, null=True)
    funcao_responsavel = models.TextField(
        max_length=255, blank=True, null=True)
    identificador = models.TextField(
        max_length=255, blank=True, null=True)
    informacoes_gerais = models.TextField(
        max_length=255, blank=True, null=True)
    modalidade = models.TextField(
        max_length=255, blank=True, null=True)
    nome_responsavel = models.TextField(
        max_length=255, blank=True, null=True)
    numero_aviso = models.PositiveIntegerField(u'numero de aviso')
    numero_itens = models.PositiveIntegerField(u'numero de itens')
    numero_processo = models.PositiveIntegerField(u'numero do processo')
    objeto = models.TextField(
        max_length=255, blank=True, null=True)
    situacao_aviso = models.TextField(
        max_length=255, blank=True, null=True)
    tipo_pregao = models.TextField(
        max_length=255, blank=True, null=True)
    tipo_recurso = models.TextField(
        max_length=255, blank=True, null=True)
    uasg = models.TextField(
        max_length=255, blank=True, null=True)
