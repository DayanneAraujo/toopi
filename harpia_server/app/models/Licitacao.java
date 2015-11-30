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
    public String modalidade;
    public String nomeResponsavel;
    public String numeroAviso;
    public String numeroItens;
    public String numeroProcesso;
    public String objeto;
    public String situacaoAviso;
    public String tipoPregao;
    public String tipoRecurso;
    public String uasg;
    public String descricaoItem;
    public String quantidateValorEstimadoItem;
    public String descricaoDetalhadaItem;
    public String margemPreferencial;
    public String situacaoItem;
    public String menorLance;
    public String decreto7174;
    public String fornecedorVencedor;
    public String tratamentoDiferenciado;
    public String unidadeFornecimento;
    public String valorNegociado;
    public String url;

    public Licitacao(){}

    public Licitacao(Long id, String dataAberturaProposta,
                     String dataEntregaEdital, String dataProposta,
                     String dataPublicação, String endereçoEntrgaEdital,
                     String funcaoResponsavel, String identificador,
                     String infoGeral, String modalidade,
                     String nomeResponsavel, String numeroAviso,
                     String numeroItens, String numeroProcesso,
                     String objeto, String situacaoAviso, String tipoPregao,
                     String tipoRecurso, String uasg, String descricaoItem,
                     String quantidateValorEstimadoItem, String descricaoDetalhadaItem,
                     String margemPreferencial, String situacaoItem, String menorLance,
                     String decreto7174, String fornecedorVencedor, String tratamentoDiferenciado,
                     String unidadeFornecimento, String valorNegociado, String url) {
        this.id = id;
        this.dataAberturaProposta = dataAberturaProposta;
        this.dataEntregaEdital = dataEntregaEdital;
        this.dataProposta = dataProposta;
        this.dataPublicação = dataPublicação;
        this.endereçoEntrgaEdital = endereçoEntrgaEdital;
        this.funcaoResponsavel = funcaoResponsavel;
        this.identificador = identificador;
        this.infoGeral = infoGeral;
        this.modalidade = modalidade;
        this.nomeResponsavel = nomeResponsavel;
        this.numeroAviso = numeroAviso;
        this.numeroItens = numeroItens;
        this.numeroProcesso = numeroProcesso;
        this.objeto = objeto;
        this.situacaoAviso = situacaoAviso;
        this.tipoPregao = tipoPregao;
        this.tipoRecurso = tipoRecurso;
        this.uasg = uasg;
        this.descricaoItem = descricaoItem;
        this.quantidateValorEstimadoItem = quantidateValorEstimadoItem;
        this.descricaoDetalhadaItem = descricaoDetalhadaItem;
        this.margemPreferencial = margemPreferencial;
        this.situacaoItem = situacaoItem;
        this.menorLance = menorLance;
        this.decreto7174 = decreto7174;
        this.fornecedorVencedor = fornecedorVencedor;
        this.tratamentoDiferenciado = tratamentoDiferenciado;
        this.unidadeFornecimento = unidadeFornecimento;
        this.valorNegociado = valorNegociado;
        this.url = url;
    }


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
