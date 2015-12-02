package controllers;


import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Licitacao;
import play.data.DynamicForm;
import play.data.Form;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

/**
 * Created by amaro on 29/11/15.
 */
@Transactional
public class LicitacaoController extends Controller {


    public Result createLicitacao(){

        DynamicForm requestData = Form.form().bindFromRequest();
        ObjectNode response = Json.newObject();

        String identificador = requestData.get("identificador");

        if (Licitacao.checkIfUserExistByIdentificador(identificador)){
            response.put("status", "0");
            response.put("message", "Telefone já cadastrado!");
            flash("error", "Telefone já cadastrado!");
            return badRequest(response);
        }else{
            try{

                Licitacao lic = new Licitacao();
                lic.dataAberturaProposta = requestData.get("dataAberturaPorposta");
                //Assim vai para cada variavel
                lic.save();

                response.put("status", "1");
                response.put("message", "Licitação cadastrada com sucesso!");

            }catch(Exception e){
                response.put("status", "0");
                response.put("message", "Não foi possível cadastrar esta Licitação!");

                e.printStackTrace();
                return badRequest(response);
            }
        }
        return ok(response);

    }


    public Result getLicitacao(String identificador) {

        ObjectNode response = Json.newObject();

        if (identificador.equals("")){
            response.put("status", "0");
            response.put("message", "{}");
        }else{
            Licitacao lic = Licitacao.findByIdentificador(identificador);
            if (lic != null){

                response.put("status", "1");
                response.put("id", lic.id);
                response.put("dataAberturaProposta", lic.dataAberturaProposta);
                response.put("dataEntregaEdital", lic.dataEntregaEdital);
                response.put("dataProposta", lic.dataProposta);
                response.put("dataPublicação", lic.dataPublicação);
                response.put("endereçoEntrgaEdital", lic.endereçoEntrgaEdital);
                response.put("funcaoResponsavel", lic.funcaoResponsavel);
                response.put("identificador", lic.identificador);
                response.put("infoGeral", lic.infoGeral);
                response.put("modalidade", String.valueOf(lic.modalidade));
                response.put("nomeResponsavel", lic.nomeResponsavel);
                response.put("numeroAviso", String.valueOf(lic.numeroAviso));
                response.put("numeroItens", String.valueOf(lic.numeroItens));
                response.put("numeroProcesso", lic.numeroProcesso);
                response.put("objeto", lic.objeto);
                response.put("situacaoAviso", lic.situacaoAviso);
                response.put("tipoPregao", lic.tipoPregao);
                response.put("tipoRecurso", lic.tipoRecurso);
                response.put("uasg", lic.uasg);
                response.put("descricaoItem", lic.descricaoItem);
                response.put("quantidateItem", String.valueOf(lic.quantidateItem));
                response.put("quantidateItem", String.valueOf(lic.valorEstimadoItem));
                response.put("descricaoDetalhadaItem", lic.descricaoDetalhadaItem);
                response.put("margemPreferencial", lic.margemPreferencial);
                response.put("situacaoItem", lic.situacaoItem);
                response.put("menorLance", String.valueOf(lic.menorLance));
                response.put("decreto7174", lic.decreto7174);
                response.put("fornecedorVencedor", lic.fornecedorVencedor);
                response.put("tratamentoDiferenciado", lic.tratamentoDiferenciado);
                response.put("unidadeFornecimento", lic.unidadeFornecimento);
                response.put("valorNegociado", String.valueOf(lic.valorNegociado));
                response.put("url", lic.url);


            }else{
                response.put("status", "0");
                response.put("message", "Licitação nao cadastrada.");
            }
        }

        return ok(response);
    }


    public Result getSituacao(String situacao) {

        ObjectNode response = Json.newObject();

        if (situacao.equals("")){
            response.put("status", "0");
            response.put("message", "{}");
        }else{
            List<Licitacao> licitacoes = Licitacao.findBySituacao(situacao);
            if (licitacoes != null){

                response.put("status", "1");
                response.put("result", Json.toJson(licitacoes));




            }else{
                response.put("status", "0");
                response.put("message", "Licitação nao cadastrada.");
            }
        }

        return ok(response);
    }

    public Result getUntilValorEstimadoItem(float valorEstimadoItem) {

        ObjectNode response = Json.newObject();

        if (valorEstimadoItem  == 0){
            response.put("status", "0");
            response.put("message", "{}");
        }else{
            List<Licitacao> licitacoes = Licitacao.findUntilValorEstimadoItem(valorEstimadoItem);
            if (licitacoes != null){

                response.put("status", "1");
                response.put("result", Json.toJson(licitacoes));




            }else{
                response.put("status", "0");
                response.put("message", "Sem Resultado.");
            }
        }

        return ok(response);
    }

    public Result getLicitacaoAno(int ano) {

        ObjectNode response = Json.newObject();

        if (ano == 0){
            response.put("status", "0");
            response.put("message", "{}");
        }else{
            List<Licitacao> licitacoes = Licitacao.findbyYear(ano);
            if (licitacoes != null){

                response.put("status", "1");
                response.put("result", Json.toJson(licitacoes));




            }else{
                response.put("status", "0");
                response.put("message", "Sem Resultado.");
            }
        }

        return ok(response);
    }

}
