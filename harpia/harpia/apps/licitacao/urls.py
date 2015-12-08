# -*- coding: utf-8 -*-

from django.conf.urls import include
from django.conf.urls import patterns
from django.conf.urls import url
from django.conf.urls import handler404
from licitacao.views import error_view

urlpatterns = patterns(
    'licitacao.views',
    url(r'^$', 'pag_inicial', name='pagina_inicial'),
    url(r'^busca-item/$', 'busca_item', name='busca_item'),
    url(r'^listar-itens/$', 'listagem', name='listagem'),
    url(r'^detalhe-item/(?P<pk>[-\w]+)/$',
        'detalhe_tipo_item', name='detalhe_tipo_item'),
    url(r'^detalhe-produto/(?P<pk>[-\w]+)/$',
        'detalhe_produto', name='detalhe_produto'),
    url(r'^listar-produtos/$', 'produtos_grid', name='produtos_grid'),
    url(r'^produto/$', 'produto_detalhe', name='produto_detalhe'),
    url(r'^documentacao/$', 'documentacao', name='documentacao'),
    url(r'^sobre/$', 'sobre', name='sobre'),

)

handler404 = error_view