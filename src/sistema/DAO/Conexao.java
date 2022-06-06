/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author gusta
 */
public class Conexao {
    protected final String url = "jdbc:mysql://localhost:3306/projetoa3";
    protected final String user = "root";
    protected final String password = "root";
    protected Connection conn;
    protected PreparedStatement st;
    protected ResultSet rs;
    
    public void conectar(){
        try{
            conn=DriverManager.getConnection(url,user,password);
            System.out.println("Conectado com sucesso!");
        }catch(SQLException e){
            System.out.println("Falha ao conectar "+e);
        }
    }
    
    public void desconectar(){
        try{
            conn.close();
            System.out.println("Operacao concluida, conexao encerrada!");
        }catch(SQLException e){
            System.out.println("Erro ao desconectar " + e);
        }
    }

}
