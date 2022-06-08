/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.Modelos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author gusta
 */
public class Relatorio {
    private int idProduto;
    private String marca;
    private String nome;
    private BigDecimal preco;
    private int qtd;
    private LocalDateTime data; 
    
    
    public Relatorio(Relatorio relatorio){
        this.idProduto = relatorio.idProduto;
        this.marca = relatorio.marca;
        this.nome = relatorio.nome;
        this.preco = relatorio.preco;
        this.qtd = relatorio.qtd;
        this.data = relatorio.data;
    }
    
    public Relatorio(){
    }
        
    
    public int getIdProduto(){
        return this.idProduto;
    }
    
    public String getMarca(){
        return this.marca;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public BigDecimal getPreco(){
        return this.preco;
    }
    
    public int getQtd(){
        return this.qtd;
    }
    
    public LocalDateTime getData(){
        return this.data;
    }
    
    public String getNomeExibicao(){
        return "(ID - "+this.idProduto+") - "+this.marca + " " + this.nome;
    }
    
    public void setIdProduto(int idProduto){
        this.idProduto = idProduto;
    }
    
    public void setMarca(String marca){
        this.marca = marca;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setPreco(BigDecimal preco){
        this.preco = preco;
    }
    
    public void setQtd(int qtd){
        this.qtd = qtd;
    }
    
    public void setData(LocalDateTime data){
        this.data = data;
    }
    
}