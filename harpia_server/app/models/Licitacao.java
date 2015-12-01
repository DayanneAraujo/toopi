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
    public String dataAberturaProposta;
    public String dataEntregaEdital;
    public String dataProposta;
    public String dataPublicação;
    public String endereçoEntrgaEdital;
    public String funcaoResponsavel;
    public String identificador;
    public String infoGeral;
    public int modalidade;
    public String nomeResponsavel;
    public int numeroAviso;
    public int numeroItens;
    public String numeroProcesso;
    public String objeto;
    public String situacaoAviso;
    public String tipoPregao;
    public String tipoRecurso;
    public String uasg;
    public String descricaoItem;
    public int quantidateItem;
    public float valorEstimadoItem;
    public String descricaoDetalhadaItem;
    public String margemPreferencial;
    public String situacaoItem;
    public float menorLance;
    public String decreto7174;
    public String fornecedorVencedor;
    public String tratamentoDiferenciado;
    public String unidadeFornecimento;
    public float valorNegociado;
    public String url;
    public String situacao;


    public static Licitacao findById(Long id) {
        return JPA.em().find(Licitacao.class, id);
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


    public static List<Licitacao> findBySituacao(String situacao) {

        try{

            List<Licitacao> results = queryFindBySituacao(situacao).getResultList();
            if (!results.isEmpty()) return results;

        }catch (NoResultException e){
            return null;
        }
        return null;
    }

    public static TypedQuery<Licitacao> queryFindBySituacao(String situacao) {
        try{
            TypedQuery<Licitacao> query = JPA.em()
                    .createQuery("SELECT u FROM Licitacao u WHERE u.situacao = :situacao", Licitacao.class);
            query.setParameter("situacao", situacao);

            return query;
        }catch (NoResultException e){
            return null;
        }
    }

    public static List<Licitacao> findByValorEstimadoItem(float valorEstimado) {

        try{

            List<Licitacao> results = queryFindByValorEstimadoItem(valorEstimado).getResultList();
            if (!results.isEmpty()) return results;

        }catch (NoResultException e){
            return null;
        }
        return null;
    }

    public static TypedQuery<Licitacao> queryFindByValorEstimadoItem(float valorEstimadoItem) {
        try{
            TypedQuery<Licitacao> query = JPA.em()
                    .createQuery("SELECT u FROM Licitacao u WHERE u.valorEstimadoItem = :valorEstimadoItem", Licitacao.class);
            query.setParameter("valorEstimadoItem", valorEstimadoItem);

            return query;
        }catch (NoResultException e){
            return null;
        }
    }


    public static List<Licitacao> findUntilValorEstimadoItem(float valorEstimado) {

        try{

            List<Licitacao> results = queryFindUntilValorEstimadoItem(valorEstimado).getResultList();
            if (!results.isEmpty()) return results;

        }catch (NoResultException e){
            return null;
        }
        return null;
    }

    public static TypedQuery<Licitacao> queryFindUntilValorEstimadoItem(float valorEstimadoItem) {
        try{
            TypedQuery<Licitacao> query = JPA.em()
                    .createQuery("SELECT u FROM Licitacao u WHERE u.valorEstimadoItem <= :valorEstimadoItem", Licitacao.class);
            query.setParameter("valorEstimadoItem", valorEstimadoItem);

            return query;
        }catch (NoResultException e){
            return null;
        }
    }




    public static Boolean checkIfUserExistByIdentificador(String identificador) {

        try{

            List<Licitacao> results = queryFindByIdentificador(identificador).getResultList();
            if (!results.isEmpty()) return true;

        }catch (NoResultException e){
            return false;
        }
        return false;
    }
}
