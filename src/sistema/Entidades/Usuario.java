/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.Entidades;

/**
 *
 * @author gusta
 */
public class Usuario {
    private String usuario;
    private String senha;
    private boolean adm;

    public Usuario(){
    }
    
    public Usuario(Usuario user){
        this.usuario = user.usuario;
        this.senha = user.senha;
        this.adm = user.adm;
    }
    
    public String getUsuario(){
        return this.usuario;
    }
    
    public String getSenha(){
        return this.senha;
    }
    
    public boolean getAdm(){
        return this.adm;
    }
    
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public void setAdm(byte adm){
        this.adm = adm != 0;
    }
    
    @Override
    public String toString(){
        return this.usuario + "\n"
                +this.senha + "\n"
                +this.adm;
    }
}
