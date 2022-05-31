/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.Modelos;

/**
 *
 * @author gusta
 */
public class Produtos {
    private int idProduto;
    private String marca;
    private String nome;
    private double preco;
    private int qtdEstoque;
 
    
    public Produtos(){
    }
    
    public Produtos(Produtos produto){
        this.idProduto = produto.idProduto;
        this.marca = produto.marca;
        this.nome = produto.nome;
        this.preco = produto.preco;
        this.qtdEstoque = produto.qtdEstoque;
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
    
    public double getPreco(){
        return this.preco;
    }
    
    public int getQtdEstoque(){
        return this.qtdEstoque;
    }
     
    public void setMarca(String marca){
        this.marca = marca;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setPreco(double preco){
        this.preco = preco;
    }
    
    public void setQtdEstoque(int qtdEstoque){
        this.qtdEstoque = qtdEstoque;
    }
    
    @Override
    public String toString(){
        return this.idProduto + "\n"
                +this.marca + "\n"
                +this.nome  + "\n"
                +this.preco + "\n"
                +this.qtdEstoque;
    }
    
}
