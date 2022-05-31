/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.DAO;
import sistema.Modelos.Produto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author gusta
 */
public class ProdutoDAO extends Conexao {
    
    public List<Produto> Listar(){
        List produtos = new ArrayList<>();
        Produto produto;
        try{
            st = conn.prepareStatement("SELECT * FROM projetoa3.produtos");
            rs = st.executeQuery();
            while(rs.next()){
                produto = new Produto();
                
            }
                        
        }catch(SQLException e){
            System.out.println("Erro ao listar "+e);
        }
        return produtos;
    }
        
      /*    
    public List<Usuario> listar(){
        List usuarios = new ArrayList<>();
        Usuario usuario;
        try{
            st = conn.prepareStatement("SELECT * FROM projetoa3.usuarios");
            rs = st.executeQuery();
            while(rs.next()){
                usuario = new Usuario();
                usuario.setUsuario(rs.getNString("Usuario"));
                usuario.setSenha(rs.getNString("Senha"));
                usuario.setAdm(rs.getByte("Adm"));
                usuarios.add(usuario);
            }
                        
        }catch(SQLException e){
            System.out.println("Erro ao listar "+e);
        }
        return usuarios;
    }
    
    public List<Usuario> listarPesquisa(String criterio){
        List usuarios = new ArrayList<>();
        Usuario usuario;
        try{
            st = conn.prepareStatement("SELECT * FROM projetoa3.usuarios WHERE Usuario = '%"+criterio+"%'");
            rs = st.executeQuery();
            while(rs.next()){
                usuario = new Usuario();
                usuario.setUsuario(rs.getNString("Usuario"));
                usuario.setSenha(rs.getNString("Senha"));
                usuario.setAdm(rs.getByte("Adm"));
                usuarios.add(usuario);
            }
                        
        }catch(SQLException e){
            System.out.println("Erro ao listar "+e);
        }
        return usuarios;
    }
    
    public List<Usuario> listarCargo(byte cargo){
        List usuarios = new ArrayList<>();
        Usuario usuario;
        try{
            st = conn.prepareStatement("SELECT * FROM projetoa3.usuarios WHERE Adm = '"+cargo+"'");
            rs = st.executeQuery();
            while(rs.next()){
                usuario = new Usuario();
                usuario.setUsuario(rs.getNString("Usuario"));
                usuario.setSenha(rs.getNString("Senha"));
                usuario.setAdm(rs.getByte("Adm"));
                usuarios.add(usuario);
            }
                        
        }catch(SQLException e){
            System.out.println("Erro ao listar "+e);
        }
        return usuarios;
    }
        
    public void criar(String usuario,String senha, byte adm){
        try{
            st = conn.prepareStatement("INSERT INTO projetoa3.Usuarios (Usuario,Senha,Adm)VALUES('"+usuario+"','"+senha+"',"+adm+")");
            st.execute();
            
        }catch(SQLException e){
            System.out.println("Erro ao Criar "+e);
        }   
    }
    
    public void editar(String usuario, String senha, byte adm,String user){
        try{
            st = conn.prepareStatement("UPDATE projetoa3.Usuarios SET Usuario = '"+usuario+"', Senha = '"+senha+"', Adm = "+adm+" WHERE Usuario = '"+user+"'");
            st.execute();
        }catch(SQLException e){
            System.out.println("Erro ao atualizar "+e);
        }
    }
    
    public void remover(String user){
        try{
            st = conn.prepareStatement("DELETE FROM projetoa3.usuarios WHERE Usuario = '"+user+"'");
            st.execute();
        }catch(SQLException e){
            System.out.println("Erro ao deletar "+e);
        }
    }
    */

        
        
}
