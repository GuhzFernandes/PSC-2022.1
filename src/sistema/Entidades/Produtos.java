/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.Entidades;

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
    
    public Produtos(Produtos product){
        
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
    
/*    
    public void set(){
        this;
    }
    
    public void set(){
        this;
    }
    
    public void set(){
        this;
    }
    
    public void set(){
        this;
    }
    
    @Override
    public String toString(){
        return this.usuario + "\n"
                +this.senha + "\n"
                +this.adm;
    }
*/    
    
}
