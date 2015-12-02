package models;

import java.util.List;
import play.db.jpa.JPA;
import javax.persistence.*;

@Entity
@Table(name = "itenslicitacao")
public class ItensLicitacao extends ModelPersistence {

    private static final long serialVersionUID = 389285360394591550L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long id;
    public String beneficio;
    public String cnpj_fornecedor;
    public String codigo_item_material;
    public String codigo_item_servico;
    public String cpfVencedor;
    public String criterio_julgamento;
    public String decreto_7174;
    public String descricao_item;
    public String modalidade;
    public int numero_aviso;
    public int numero_item_licitacao;
    public int numero_licitacao;
    public int quantidade;
    public String sustentavel;
    public String uasg;
    public String unidade;
    public float valor_estimado;
    public String situacao;


    public static TypedQuery<ItensLicitacao> queryFindByIdentificadorLicitacao(String identificador) {
        try{
            TypedQuery<ItensLicitacao> query = JPA.em()
                    .createQuery("SELECT u FROM ItensLicitacao u WHERE u.numero_licitacao = :identificador", ItensLicitacao.class);
            query.setParameter("identificador", identificador);

            return query;
        }catch (NoResultException e){
            return null;
        }
    }

    public static List<ItensLicitacao> findByIdentificadorLicitacao(String identificador) {

        try{
            List<ItensLicitacao> results = queryFindByIdentificadorLicitacao(identificador).getResultList();
            if (!results.isEmpty()) return results;

        }catch (NoResultException e){
            return null;
        }
        return null;
    }


    public static TypedQuery<ItensLicitacao> queryFindByDescricao(String descricao) {
        try{
            TypedQuery<ItensLicitacao> query = JPA.em()
                    .createQuery("SELECT u FROM ItensLicitacao u WHERE u.descricao_item = :descricao", ItensLicitacao.class);
            query.setParameter("descricao", descricao);

            return query;
        }catch (NoResultException e){
            return null;
        }
    }

    public static List<ItensLicitacao> findByDescricao(String descricao) {

        try{
            List<ItensLicitacao> results = queryFindByDescricao(descricao).getResultList();
            if (!results.isEmpty()) return results;

        }catch (NoResultException e){
            return null;
        }
        return null;
    }


}
