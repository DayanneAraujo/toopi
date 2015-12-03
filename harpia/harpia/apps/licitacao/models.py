# -*- coding: utf-8 -*-

from django.db import models


class Licitacao(models.Model):
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
