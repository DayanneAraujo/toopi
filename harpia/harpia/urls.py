from django.conf.urls import include, url
from django.contrib import admin
from harpia import settings
from django.conf.urls import patterns


urlpatterns = [
    # Examples:
    # url(r'^$', 'harpia.views.home', name='home'),
    url(r'', include('licitacao.urls', namespace='licitacao')),
    url(r'^admin/', include(admin.site.urls)),
]

urlpatterns += patterns(
    '',
    (r'^static/(?P<path>.*)$', 'django.views.static.serve',
        {'document_root': settings.STATIC_ROOT}),
    )
