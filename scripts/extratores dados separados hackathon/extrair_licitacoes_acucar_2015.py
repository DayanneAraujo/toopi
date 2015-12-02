#!/usr/bin/env python
# -*- coding: utf-8 -*-

import xml.etree.ElementTree as etree
import urllib2

# r = urllib2.urlopen("http://compras.dados.gov.br/licitacoes/v1/licitacoes.xml?data_publicacao_min=2013-01-01&item_material=9725")

output_licitacoes = open("resultado/licitacoes_busca_papel_2015.csv", "w")
output_pregoes = open("resultado/pregoes_busca_papel_2015.csv", "w")
output_licitacoes.write("id;data_abertura_proposta;data_entrega_edital;data_entrega_proposta;data_publicacao;endereco_entrega_edital;funcao_responsavel;identificador;informacoes_gerais;modalidade;nome_responsavel;numero_aviso;numero_itens;numero_processo;objeto;situacao_aviso;tipo_pregao;tipo_recurso;uasg;beneficio;cnpj_fornecedor;codigo_item_material;codigo_item_servico;cpfVencedor;criterio_julgamento;decreto_7174;descricao_item;modalidade;numero_aviso;numero_item_licitacao;numero_licitacao;quantidade;sustentavel;uasg;unidade_valor_estimado;valor_estimado;url_licitacao\n")
output_pregoes.write("id;data_abertura_proposta;data_entrega_edital;data_entrega_proposta;data_publicacao;endereco_entrega_edital;funcao_responsavel;identificador;informacoes_gerais;modalidade;nome_responsavel;numero_aviso;numero_itens;numero_processo;objeto;situacao_aviso;tipo_pregao;tipo_recurso;uasg;descricao_item;quantidade_item;valor_estimado_item;descricao_detalhada_item;margem_preferencial;situacao_item;menor_lance;decreto_7174;fornecedor_vencedor;tratamento_diferenciado;unidade_fornecimento;valor_negociado;url_pregao;tipo_material\n")

#import ipdb; ipdb.set_trace()
r = urllib2.urlopen("http://compras.dados.gov.br/licitacoes/v1/licitacoes.xml?objeto=papel&data_publicacao_min=2014-01-01")

content = r.read()
r.close()
tree = etree.fromstring(content)
root = tree[1]
resources = tree[1]

countpregao = 1
countlicitacao = 1
count_lic = 1
total_offset = int(tree.attrib['count'])
offset = 0
count_fail = 0
print "EXISTEM %s LICITACOES" % tree.attrib['count']
while offset < total_offset:
    print "FAZENDO OFFSET IGUAL A %s" % offset
    r = urllib2.urlopen("http://compras.dados.gov.br/licitacoes/v1/licitacoes.xml?objeto=papel&data_publicacao_min=2014-01-01&offset=%d" % offset)
    content = r.read()
    r.close()
    tree = etree.fromstring(content)
    root = tree[1]
    resources = tree[1]

    for lic in range(len(resources)):
        licitacao = resources[lic]

        links = licitacao.find("_links")
        items_list = ["beneficio", "cnpj_fornecedor", "codigo_item_material", "codigo_item_servico", "cpfVencedor", "criterio_julgamento", "decreto_7174", "descricao_item", "modalidade", "numero_aviso", "numero_item_licitacao", "numero_licitacao", "quantidade", "sustentavel", "uasg", "unidade", "valor_estimado"]
        url_pregao = ""
        url_lic = ""
        id_pregao = ""

        if licitacao.find('modalidade').text == '5':
            for link in links:
                if link.attrib['rel'] == 'pregoes':
                    url = 'http://compras.dados.gov.br' + link.attrib['href'] + '/itens.xml'
                    break
                elif link.attrib['rel'] == 'self':
                    url_lic = 'http://compras.dados.gov.br' + link.attrib['href'] + '/itens.xml'
            items_list = ["descricao_item", "quantidade_item", "valor_estimado_item", "descricao_detalhada_item", "margem_preferencial", "situacao_item", "menor_lance", "decreto_7174", "fornecedor_vencedor", "tratamento_diferenciado", "unidade_fornecimento", "valor_negociado"]
        else:
            for link in links:
                if link.attrib['rel'] == 'self':
                    url = 'http://compras.dados.gov.br' + link.attrib['href'] + '/itens.xml'
                    break
        s = urllib2.urlopen(url)
        content = s.read()
        s.close()
        content_lic = None
        item_lic_resources = None
        item_root = etree.fromstring(content)
        item_resources = item_root[1]
        for it in range(len(item_resources)):
            item = item_resources[it]
            st = ""
            if licitacao.find('modalidade').text == '5':
                st = "\"%s\";" % countpregao
                s_lic = urllib2.urlopen(url_lic)
                content_lic = s_lic.read()
                s_lic.close()
                item_lic_resources = etree.fromstring(content_lic)[1]
            else:
                st = "\"%s\";" % countlicitacao

            licitacoes_list = ["data_abertura_proposta", "data_entrega_edital", "data_entrega_proposta", "data_publicacao", "endereco_entrega_edital", "funcao_responsavel", "identificador", "informacoes_gerais", "modalidade", "nome_responsavel", "numero_aviso", "numero_itens", "numero_processo", "objeto", "situacao_aviso", "tipo_pregao", "tipo_recurso", "uasg"]
            for licitacao_name in licitacoes_list:
                if licitacao.find(licitacao_name) is not None:
                    if licitacao.find(licitacao_name).text is not None:
                        try:
                            st += ("\"" + licitacao.find(licitacao_name).text.replace('\"', " polegadas") + "\"" + ';')
                        except:
                            print "oie foi erro"
                            import ipdb; ipdb.set_trace()

                    else:
                        st += "\"NA\";"
                else:
                    st += "\"NA\";"
            for item_name in items_list:
                if item.find(item_name) is not None:
                    if item.find(item_name).text is not None:
                        try:
                            st += ("\"" + item.find(item_name).text.replace('\"', " polegadas") + "\"" + ';')
                        except:
                            print "oie foi erro"
                            import ipdb; ipdb.set_trace()
                    else:
                        st += "\"NA\";"
                else:
                    st += "\"NA\";"

            url_licitacao = ""
            if licitacao.find('modalidade').text == '5':
                id_pregao = licitacao.find('identificador').text[:7] + licitacao.find('identificador').text[8:]
                url_licitacao = '/pregoes/doc/pregao/' + id_pregao
            else:
                for link in links:
                    if link.attrib['rel'] == 'self':
                        url = 'http://compras.dados.gov.br' + link.attrib['href'] + '/itens.xml'
                        break
                url_licitacao = link.attrib['href']
            st += "\"" + url_licitacao + "\";"

            if licitacao.find('modalidade').text == '5':
                if len(item_resources) == len(item_lic_resources):
                    if item_lic_resources[it].find('codigo_item_material') is not None:
                        if item_lic_resources[it].find('codigo_item_material').text is not None:
                            try:
                                st += ("\"" + item_lic_resources[it].find('codigo_item_material').text + "\"" + ';')
                            except:
                                print "oie foi erro"
                                import ipdb; ipdb.set_trace()
                        else:
                            st += "\"NA\";"
                    else:
                            st += "\"NA\";"
                else:
                    st += "\"NA\";"
                    print "EH DIFERENTE"
                    count_fail += 1

            st = st.replace('\n', '').replace('\t', '').replace('\r', '').replace('Ž'.decode('utf-8'), '')

            if licitacao.find('modalidade').text == '5':
                countpregao += 1
                output_pregoes.write(st.encode("utf-8") + '\n')
                print "id=" + str(countpregao) + " pregao " + str(count_lic) + " & item " + id_pregao
            else:
                countlicitacao += 1
                output_licitacoes.write(st.encode("utf-8") + '\n')
                print "id=" + str(countlicitacao) + " licitacao " + str(count_lic) + " & item " + licitacao.find("identificador").text
        count_lic += 1
    offset += 500
output_licitacoes.close()
output_pregoes.close()

print "OCORRERAM %d FALHAS" % count_fail
