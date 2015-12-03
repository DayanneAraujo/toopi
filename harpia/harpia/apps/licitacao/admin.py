# -*- coding: utf-8 -*-

from django.contrib import admin
from licitacao.models import ItensLicitacao
from licitacao.models import Licitacao


class LicitacaoAdmin(admin.ModelAdmin):
    pass
admin.site.register(Licitacao, LicitacaoAdmin)


class ItensLicitacaoAdmin(admin.ModelAdmin):
    pass
admin.site.register(ItensLicitacao, ItensLicitacaoAdmin)
