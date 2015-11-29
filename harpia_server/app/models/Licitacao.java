package models;

public class Licitacao extends Model{
    
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

    public Licitacao(String id, String dataAberturaProposta,
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDataAberturaProposta() {
        return dataAberturaProposta;
    }

    public void setDataAberturaProposta(String dataAberturaProposta) {
        this.dataAberturaProposta = dataAberturaProposta;
    }

    public String getDataEntregaEdital() {
        return dataEntregaEdital;
    }

    public void setDataEntregaEdital(String dataEntregaEdital) {
        this.dataEntregaEdital = dataEntregaEdital;
    }

    public String getDataProposta() {
        return dataProposta;
    }

    public void setDataProposta(String dataProposta) {
        this.dataProposta = dataProposta;
    }

    public String getDataPublicação() {
        return dataPublicação;
    }

    public void setDataPublicação(String dataPublicação) {
        this.dataPublicação = dataPublicação;
    }

    public String getEndereçoEntrgaEdital() {
        return endereçoEntrgaEdital;
    }

    public void setEndereçoEntrgaEdital(String endereçoEntrgaEdital) {
        this.endereçoEntrgaEdital = endereçoEntrgaEdital;
    }

    public String getFuncaoResponsavel() {
        return funcaoResponsavel;
    }

    public void setFuncaoResponsavel(String funcaoResponsavel) {
        this.funcaoResponsavel = funcaoResponsavel;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getInfoGeral() {
        return infoGeral;
    }

    public void setInfoGeral(String infoGeral) {
        this.infoGeral = infoGeral;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getNumeroAviso() {
        return numeroAviso;
    }

    public void setNumeroAviso(String numeroAviso) {
        this.numeroAviso = numeroAviso;
    }

    public String getNumeroItens() {
        return numeroItens;
    }

    public void setNumeroItens(String numeroItens) {
        this.numeroItens = numeroItens;
    }

    public String getNumeroProcesso() {
        return numeroProcesso;
    }

    public void setNumeroProcesso(String numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getSituacaoAviso() {
        return situacaoAviso;
    }

    public void setSituacaoAviso(String situacaoAviso) {
        this.situacaoAviso = situacaoAviso;
    }

    public String getTipoPregao() {
        return tipoPregao;
    }

    public void setTipoPregao(String tipoPregao) {
        this.tipoPregao = tipoPregao;
    }

    public String getTipoRecurso() {
        return tipoRecurso;
    }

    public void setTipoRecurso(String tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }

    public String getUasg() {
        return uasg;
    }

    public void setUasg(String uasg) {
        this.uasg = uasg;
    }

    public String getDescricaoItem() {
        return descricaoItem;
    }

    public void setDescricaoItem(String descricaoItem) {
        this.descricaoItem = descricaoItem;
    }

    public String getQuantidateValorEstimadoItem() {
        return quantidateValorEstimadoItem;
    }

    public void setQuantidateValorEstimadoItem(String quantidateValorEstimadoItem) {
        this.quantidateValorEstimadoItem = quantidateValorEstimadoItem;
    }

    public String getDescricaoDetalhadaItem() {
        return descricaoDetalhadaItem;
    }

    public void setDescricaoDetalhadaItem(String descricaoDetalhadaItem) {
        this.descricaoDetalhadaItem = descricaoDetalhadaItem;
    }

    public String getMargemPreferencial() {
        return margemPreferencial;
    }

    public void setMargemPreferencial(String margemPreferencial) {
        this.margemPreferencial = margemPreferencial;
    }

    public String getSituacaoItem() {
        return situacaoItem;
    }

    public void setSituacaoItem(String situacaoItem) {
        this.situacaoItem = situacaoItem;
    }

    public String getMenorLance() {
        return menorLance;
    }

    public void setMenorLance(String menorLance) {
        this.menorLance = menorLance;
    }

    public String getDecreto7174() {
        return decreto7174;
    }

    public void setDecreto7174(String decreto7174) {
        this.decreto7174 = decreto7174;
    }

    public String getFornecedorVencedor() {
        return fornecedorVencedor;
    }

    public void setFornecedorVencedor(String fornecedorVencedor) {
        this.fornecedorVencedor = fornecedorVencedor;
    }

    public String getTratamentoDiferenciado() {
        return tratamentoDiferenciado;
    }

    public void setTratamentoDiferenciado(String tratamentoDiferenciado) {
        this.tratamentoDiferenciado = tratamentoDiferenciado;
    }

    public String getUnidadeFornecimento() {
        return unidadeFornecimento;
    }

    public void setUnidadeFornecimento(String unidadeFornecimento) {
        this.unidadeFornecimento = unidadeFornecimento;
    }

    public String getValorNegociado() {
        return valorNegociado;
    }

    public void setValorNegociado(String valorNegociado) {
        this.valorNegociado = valorNegociado;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
