# -*- coding: utf-8 -*-

from django.conf.urls import include
from django.conf.urls import patterns
from django.conf.urls import url


urlpatterns = patterns(
    'licitacao.views',
    url(r'^$', 'pag_inicial', name='pagina_inicial'),
)
