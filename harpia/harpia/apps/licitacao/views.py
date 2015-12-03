# -*- coding: utf-8 -*-

from django.views.generic import TemplateView
from django.views.generic import DetailView
from django.core.urlresolvers import reverse
from models import ItensLicitacao
from licitacao.models import Item


__all__ = ['pag_inicial', 'listagem', 'busca_item', 'detalhe_tipo_item']


class PaginaInicialView(TemplateView):
    template_name = 'licitacao/pagina_inicial.html'

pag_inicial = PaginaInicialView.as_view()


class BuscarItemView(TemplateView):
    template_name = 'licitacao/licitacoes_list.html'

    def get_queryset(self, **kwargs):
        query = kwargs.get('q')
        type_search = kwargs.get('type_search')
        if type_search == '1':
            return ItensLicitacao.objects.filter(ano=query)
        elif type_search == '2':
            return ItensLicitacao.objects.filter(identificador=query)
        elif type_search == '3':
            return ItensLicitacao.objects.filter(situacao=query)
        return None

busca_item = BuscarItemView.as_view()


class ListarLicitacoesView(TemplateView):
    template_name = 'licitacao/licitacoes_list.html'

    def get_queryset(self, **kwargs):
        return ItensLicitacao.objects.all()

    def get_context_data(self, *args, **kwargs):
        context = super(ListarLicitacoesView, self).get_context_data(
            *args, **kwargs)
        context['listagem'] = self.get_queryset()
        return context

listagem = ListarLicitacoesView.as_view()


class DetalheProdutoView(DetailView):
    model = ItensLicitacao
    template_name = 'licitacao/detalhes_item.html'

    def get_context_data(self, **kwargs):
        context = super(DetalheProdutoView, self).get_context_data(**kwargs)
        # context['object'] = ItensLicitacao.objects.get()
        return context


class DetalheItemView(DetailView):
    model = Item
    template_name = "licitacao/detalhes_tipo_item.html"

    def get_context_data(self, **kwargs):
        context = super(DetalheItemView, self).get_context_data(**kwargs)
        context['normal'] = ItensLicitacao.objects.filter(
            descricao_detalhada_item__contains=self.object.item,
            situacao='NORMAL').count()
        context['alto'] = ItensLicitacao.objects.filter(
            descricao_detalhada_item__contains=self.object.item,
            situacao='ALTO').count()
        context['muito_alto'] = ItensLicitacao.objects.filter(
            descricao_detalhada_item__contains=self.object.item,
            situacao='MUITO ALTO').count()
        return context

detalhe_tipo_item = DetalheItemView.as_view()
