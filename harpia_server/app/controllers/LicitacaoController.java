package controllers;


import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Licitacao;
import play.data.DynamicForm;
import play.data.Form;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

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

                //Fazer o resto

            }else{
                response.put("status", "0");
                response.put("message", "Licitação nao cadastrada.");
            }
        }

        return ok(response);
    }


}
