/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.DAO;
import sistema.Entidades.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author gusta
 */
public class UsuarioDAO extends Conexao{
    
    public List<Usuario> Listar(){
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
    
    public Usuario login(String user){
        Usuario usuario = new Usuario();
        try{
            st = conn.prepareStatement("SELECT * FROM projetoa3.usuarios WHERE Usuarios.`Usuario` = ?");
            st.setString(1, user);
            rs = st.executeQuery();
            usuario.setUsuario(rs.getNString("Usuario"));
            usuario.setSenha(rs.getNString("Senha"));
            usuario.setAdm(rs.getByte("Adm"));
        }catch(SQLException e){
            System.out.println("Erro ao verificar "+e);
        }
        return usuario;
    }
}

