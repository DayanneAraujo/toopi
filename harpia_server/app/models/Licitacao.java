package models;

import java.util.List;
import play.db.jpa.JPA;
import javax.persistence.*;

@Entity
@Table(name = "licitacao")
public class Licitacao extends ModelPersistence{


    private static final long serialVersionUID = 389285360394591550L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long id;
    public String data_abertura_proposta;
    public String data_entrega_edital;
    public String data_entrega_proposta;
    public String data_publicacao;
    public String endereco_entrega_edital;
    public String funcao_responsavel;
    public String identificador;
    public String informacoes_gerais;
    public String modalidade;
    public String nome_responsavel;
    public String numero_aviso;
    public String numero_itens;
    public String numero_processo;
    public String objeto;
    public String situacao_aviso;
    public String tipo_pregao;
    public String tipo_recurso;
    public String uasg;


    public static TypedQuery<Licitacao> queryFindByIdentificador(String identificador) {
        try{
            TypedQuery<Licitacao> query = JPA.em()
                    .createQuery("SELECT u FROM Licitacao u WHERE u.identificador = :identificador", Licitacao.class);
            query.setParameter("identificador", identificador);

            return query;
        }catch (NoResultException e){
            return null;
        }
    }

    public static Licitacao findByIdentificador(String identificador) {

        try{

            List<Licitacao> results = queryFindByIdentificador(identificador).getResultList();
            if (!results.isEmpty()) return results.get(0);

        }catch (NoResultException e){
            return null;
        }
        return null;
    }

    public static List<Licitacao> findbyYear(int ano) {

        try{

            List<Licitacao> results = queryFindByYear(ano).getResultList();
            if (!results.isEmpty()) return results;

        }catch (NoResultException e){
            return null;
        }
        return null;
    }

    public static TypedQuery<Licitacao> queryFindByYear(int ano) {
        try{
            TypedQuery<Licitacao> query = JPA.em()
                    .createQuery("SELECT u FROM Licitacao u WHERE YEAR(u.data_publicacao) = :ano", Licitacao.class);
            query.setParameter("ano", ano);

            return query;
        }catch (NoResultException e){
            return null;
        }
    }

    public static TypedQuery<Licitacao> queryFindByOrgao(String uasg) {
        try{
            TypedQuery<Licitacao> query = JPA.em()
                    .createQuery("SELECT u FROM Licitacao u WHERE u.uasg = :uasg", Licitacao.class);
            query.setParameter("uasg", uasg);

            return query;
        }catch (NoResultException e){
            return null;
        }
    }

    public static List<Licitacao> findByOrgao(String uasg) {

        try{

            List<Licitacao> results = queryFindByOrgao(uasg).getResultList();
            if (!results.isEmpty()) return results;

        }catch (NoResultException e){
            return null;
        }
        return null;
    }

}
