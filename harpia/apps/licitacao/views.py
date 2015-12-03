# -*- coding: utf-8 -*-

from django.views.generic import TemplateView
from django.core.urlresolvers import reverse

__all__ = ['pag_inicial', ]


class PaginaInicialView(TemplateView):
    template_name = 'licitacao/pagina_inicial.html'

pag_inicial = PaginaInicialView.as_view()
