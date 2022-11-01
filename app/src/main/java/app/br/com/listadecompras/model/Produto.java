package app.br.com.listadecompras.model;

import java.util.Date;
import java.util.List;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Produto extends RealmObject {

    @PrimaryKey
    private int id;

    @Required
    private Date DataDaInclusao;

    @Required
    private String nomeDoProduto;

    @Required
    private String unidadeDeMedida;

    private double Quantidade;

    private double precoPago;

    private String codigoDeBarras;

    private byte[] imagem;

    @Ignore
    private List<Produto> produtos;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataDaInclusao() {
        return DataDaInclusao;
    }

    public void setDataDaInclusao(Date dataDaInclusao) {
        DataDaInclusao = dataDaInclusao;
    }

    public String getNomeDoProduto() {
        return nomeDoProduto;
    }

    public void setNomeDoProduto(String nomeDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
    }

    public String getUnidadeDeMedida() {
        return unidadeDeMedida;
    }

    public void setUnidadeDeMedida(String unidadeDeMedida) {
        this.unidadeDeMedida = unidadeDeMedida;
    }

    public double getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(double quantidade) {
        Quantidade = quantidade;
    }

    public double getPrecoPago() {
        return precoPago;
    }

    public void setPrecoPago(double precoPago) {
        this.precoPago = precoPago;
    }

    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public void setCodigoDeBarras(String codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
