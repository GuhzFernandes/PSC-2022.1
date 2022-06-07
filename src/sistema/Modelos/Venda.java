/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.Modelos;
import sistema.DAO.ProdutoDAO;
import java.time.LocalDateTime;
import java.math.BigDecimal;


/**
 *
 * @author gusta
 */
public class Venda {
    private int idVenda;
    private int produto;
    private BigDecimal precoUnitario;
    private int qtdVendida;
    private LocalDateTime dataVenda;
    private String produtoTexto;
    
    public Venda(){
    }
    
    public Venda(Venda venda){
        this.idVenda = venda.idVenda;
        this.produto = venda.produto;
        this.precoUnitario = venda.precoUnitario;
        this.qtdVendida = venda.qtdVendida;
        this.dataVenda = venda.dataVenda;
        this.produtoTexto = venda.produtoTexto;
    }
    
    public int getIdVenda(){
        return this.idVenda;
    }
    
    public int getProduto(){
        return this.produto;
    }
    
    public BigDecimal getPrecoUnitario(){
        return this.precoUnitario;
    }
    
    public int getQtdVendida(){
        return this.qtdVendida;
    }
    
    public LocalDateTime getDataVenda(){
        return this.dataVenda;
    }
    
    public String getProdutoTexto(){
        return this.produtoTexto;
    }
    
    public void setIdVenda(int idVenda){
        this.idVenda = idVenda;
    }
    
    public void setProduto(int produto){
        this.produto = produto;
    }
    
    public void setPrecoUnitario(BigDecimal precoUnitario){
        this.precoUnitario = precoUnitario;
    }
    
    public void setQtdVendida(int qtdVendida){
        this.qtdVendida = qtdVendida;
    }
    
    public void setDataVenda(LocalDateTime dataVenda){
        this.dataVenda = dataVenda;
    }
    
    public void setProdutoTexto(){
        ProdutoDAO prod = new ProdutoDAO();
        prod.conectar();
        Produto produto = new Produto();
        produto = prod.checkProduto(this.produto);
        this.produtoTexto = produto.getNomeExibicao();
        prod.desconectar();
    }
    
    @Override
    public String toString(){
        return this.idVenda + "\n"
                +this.produto + "\n"
                +this.precoUnitario  + "\n"
                +this.qtdVendida + "\n"
                +this.dataVenda;
    }
}
