package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import models.ItensLicitacao;
import models.Licitacao;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

/**
 * Created by amaro on 02/12/15.
 */
public class ItensLicitacaoController extends Controller {

    public Result getItensLicitacao(String id) {

        ObjectNode response = Json.newObject();

        if (id == null){
            response.put("status", "0");
            response.put("message", "{}");
        }else{
            List<ItensLicitacao> itens = ItensLicitacao.findByIdentificadorLicitacao(id);
            if (itens != null){

                response.put("status", "1");
                response.put("result", Json.toJson(itens));


            }else{
                response.put("status", "0");
                response.put("message", "Sem Resultado.");
            }
        }

        return ok(response);
    }


    public Result getItemDescricao(String descricao) {

        ObjectNode response = Json.newObject();

        if (descricao == null){
            response.put("status", "0");
            response.put("message", "{}");
        }else{
            List<ItensLicitacao> itens = ItensLicitacao.findByDescricao(descricao);
            if (itens != null){

                response.put("status", "1");
                response.put("result", Json.toJson(itens));


            }else{
                response.put("status", "0");
                response.put("message", "Sem Resultado.");
            }
        }

        return ok(response);
    }

}
