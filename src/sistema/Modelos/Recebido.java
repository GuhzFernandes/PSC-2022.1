/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.Modelos;
import java.time.LocalDateTime;
/**
 *
 * @author gusta
 */
public class Recebido {
    private int idRecebimento;
    private int produto;
    private int qtdRecebida;
    private LocalDateTime dataRecebimento;
    
    public Recebido(){
    }
    
    public Recebido(Recebido recebido){
        this.idRecebimento = recebido.idRecebimento;
        this.produto = recebido.produto;
        this.qtdRecebida = recebido.qtdRecebida;
        this.dataRecebimento = recebido.dataRecebimento;
    }
    
    public int getIdRecebimento(){
        return this.idRecebimento;
    }
    
    public int getProduto(){
        return this.produto;
    }
    
    public int getQtdRecebida(){
        return this.qtdRecebida;
    }
    
    public LocalDateTime getDataRecebimento(){
        return this.dataRecebimento;
    }
    
    public void setIdRecebimento(int idRecebimento){
        this.idRecebimento = idRecebimento;
    }
    
    public void setProduto(int produto){
        this.produto = produto;
    }
    
    public void setQtdRecebida(int qtdRecebida){
        this.qtdRecebida = qtdRecebida;
    }
    
    public void setDataRecebimento(LocalDateTime dataRecebimento){
        this.dataRecebimento = dataRecebimento;
    }
        
    @Override
    public String toString(){
        return this.idRecebimento + "\n"
                +this.produto + "\n"
                +this.qtdRecebida  + "\n"
                +this.qtdRecebida + "\n"
                +this.dataRecebimento;
    }
}
