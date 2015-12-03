from django.conf.urls import include, url
from django.contrib import admin

urlpatterns = [
    # Examples:
    # url(r'^$', 'harpia.views.home', name='home'),
    url(r'', include('licitacao.urls', namespace='licitacao')),

    url(r'^admin/', include(admin.site.urls)),
]
