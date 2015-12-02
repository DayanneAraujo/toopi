package controllers;


import com.fasterxml.jackson.databind.node.ObjectNode;
import models.ItensLicitacao;
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


    public Result getLicitacao(String identificador) {

        ObjectNode response = Json.newObject();

        if (identificador.equals("")) {
            response.put("status", "0");
            response.put("message", "{}");
        } else {
            Licitacao lic = Licitacao.findByIdentificador(identificador);
            if (lic != null) {

                response.put("status", "1");
                response.put("licitacao", Json.toJson(lic));

            }else{
                response.put("status", "0");
                response.put("message", "Licitação nao cadastrada.");
            }
        }

        return ok(response);
    }

    public Result getLicitacaoPorAno(int ano) {

        ObjectNode response = Json.newObject();

        if (ano == 0) {
            response.put("status", "0");
            response.put("message", "{}");
        } else {
            List<Licitacao> lic = Licitacao.findbyYear(ano);
            if (lic != null) {

                response.put("status", "1");
                response.put("licitacao", Json.toJson(lic));


            }else{
                response.put("status", "0");
                response.put("message", "Licitação nao cadastrada.");
            }
        }

        return ok(response);
    }

    public Result getLicitacaoPorOrgao(String uasg) {

        ObjectNode response = Json.newObject();

        if (uasg == null) {
            response.put("status", "0");
            response.put("message", "{}");
        } else {
            List<Licitacao> lic = Licitacao.findByOrgao(uasg);
            if (lic != null) {

                response.put("status", "1");
                response.put("licitacao", Json.toJson(lic));


            }else{
                response.put("status", "0");
                response.put("message", "Licitação nao cadastrada.");
            }
        }

        return ok(response);
    }






}
