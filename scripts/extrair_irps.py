#!/usr/bin/env python
# -*- coding: utf-8 -*-

import xml.etree.ElementTree as etree
import urllib2

r = urllib2.urlopen("http://compras.dados.gov.br/licitacoes/v1/irps.xml")
content = r.read()

output = open("irps.csv", "w")
output.write("id;uasg;codigo_material;criterio_julgamento;numero_irp;id_irp;modalidade_licitacao_item;descricao_detalhada;tipo;unidade_fornecimento;valor_estimado;url_irp\n")

tree = etree.fromstring(content)

root = tree.getroot()

resources = root[1]

count = 1
for irp in range(len(resources)):
    for items in resources[irp][0]:
        if items.attrib['rel'] == 'itens':
            url = 'http://compras.dados.gov.br' + items.attrib['href'] + '.xml'
            s = urllib2.urlopen(url)
            content = s.read()
            item_root = etree.fromstring(content)
            item_resources = item_root[1]
            for item in item_resources:
                for links in item.find("_links"):
                    if links.attrib['rel'] == "irp":
                        st = "\"%s\";" % count
                        items_list = ["uasg", "codigo_material", "criterio_julgamento", "numero_irp", "id_irp", "modalidade_licitacao_item", "descricao_detalhada", "tipo", "unidade_fornecimento", "valor_estimado"]
                        for item_name in items_list:
                            if item.find(item_name) is not None:
                                st += ("\"" + item.find(item_name).text.replace('\"', " polegadas") + "\"" + ';')
                            else:
                                st += "\"NA\";"

                        url_irp = links.attrib['href']
                        st += "\"" + url_irp + "\""
                        st  = st.replace('\n', '').replace('\t', '').replace('\r', '').replace('Ž'.decode('utf-8'),'')
                        output.write(st.encode("utf-8") + '\n')
                        print "id=" + str(count) + " IRP " + item.find("id_irp").text + " = " + item.find("valor_estimado").text + " por " + item.find("unidade_fornecimento").text
                count += 1
output.close()
