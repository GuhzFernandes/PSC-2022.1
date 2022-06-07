/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.DAO;
import sistema.Modelos.Recebido;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gusta
 */
public class RecebidoDAO extends Conexao {
    public Recebido checkRecebido(int id){
        Recebido recebido = new Recebido();
        try{
            st = conn.prepareStatement("SELECT * FROM projetoa3.recebidos WHERE IdRecebimento = "+id);
            rs = st.executeQuery();
            while(rs.next()){
                recebido.setIdRecebimento(rs.getInt("IdRecebimento"));
                recebido.setProduto(rs.getInt("Produto"));
                recebido.setQtdRecebida(rs.getInt("QuantidadeRecebida"));
                recebido.setDataRecebimento(rs.getTimestamp("DataRecebimento").toLocalDateTime());
                recebido.setProdutoTexto();
            }            
        }catch(SQLException e){
            System.out.println("Erro ao listar "+e);
        }
        return recebido;
    }
    
    public List<Recebido> listar(){
        List recebidos = new ArrayList<>();
        Recebido recebido;
        try{
            st = conn.prepareStatement("SELECT * FROM projetoa3.recebidos");
            rs = st.executeQuery();
            while(rs.next()){
                recebido = new Recebido();
                recebido.setIdRecebimento(rs.getInt("IdRecebimento"));
                recebido.setProduto(rs.getInt("Produto"));
                recebido.setQtdRecebida(rs.getInt("QuantidadeRecebida"));
                recebido.setDataRecebimento(rs.getTimestamp("DataRecebimento").toLocalDateTime());
                recebido.setProdutoTexto();
                recebidos.add(recebido);
            }            
        }catch(SQLException e){
            System.out.println("Erro ao listar "+e);
        }
        return recebidos;
    }
    
    public List<Recebido> listarPesquisa(String criterio){
        List recebidos = new ArrayList<>();
        Recebido recebido;
        try{
            st = conn.prepareStatement("SELECT * FROM projetoa3.recebidos WHERE DataRecebimento LIKE '%"+criterio+"%' OR Produto LIKE '%"+criterio+"%'");
            rs = st.executeQuery();
            while(rs.next()){
                recebido = new Recebido();
                recebido.setIdRecebimento(rs.getInt("IdRecebimento"));
                recebido.setProduto(rs.getInt("Produto"));
                recebido.setQtdRecebida(rs.getInt("QuantidadeRecebida"));
                recebido.setDataRecebimento(rs.getTimestamp("DataRecebimento").toLocalDateTime());
                recebido.setProdutoTexto();
                recebidos.add(recebido);
            }
        }catch(SQLException e){
            System.out.println("Erro ao listar "+e);
        }
        return recebidos;
   }
        
    public void criar(int idProduto, int qtdRecebida, LocalDateTime dataRecebimento){
        try{
            st = conn.prepareStatement("INSERT INTO projetoa3.recebidos (Produto, QuantidadeRecebida,DataRecebimento)VALUES("+idProduto+","+qtdRecebida+",CONVERT('"+dataRecebimento+"', DATETIME))");
            st.execute();
            st = conn.prepareStatement("UPDATE projetoa3.produtos SET QuantidadeEstoque = QuantidadeEstoque + "+qtdRecebida+"  WHERE IdProduto = "+idProduto);
            st.execute();
        }catch(SQLException e){
            System.out.println("Erro ao Criar "+e);
        }
    }
    
    public void editar(int idProduto, int qtdAnterior,int qtdRecebida, LocalDateTime dataRecebimento, int idRecebimento){
        try{
            int qtdAtualizada = qtdRecebida - qtdAnterior;
            st = conn.prepareStatement("UPDATE projetoa3.recebidos SET QuantidadeRecebida = "+qtdRecebida+", DataRecebimento = CONVERT('"+dataRecebimento+"', DATETIME) WHERE IdRecebimento = "+idRecebimento);
            st.execute();
            st = conn.prepareStatement("UPDATE projetoa3.produtos SET QuantidadeEstoque = QuantidadeEstoque + "+qtdAtualizada+"  WHERE IdProduto = "+idProduto);
            st.execute();
        }catch(SQLException e){
            System.out.println("Erro ao atualizar "+e);
        }
    }
    
    public void remover(int idRecebimento,int qtdRecebida,int idProduto){
        try{
            st = conn.prepareStatement("DELETE FROM projetoa3.recebidos WHERE IdRecebimento = "+idRecebimento);
            st.execute();
            st = conn.prepareStatement("UPDATE projetoa3.produtos SET QuantidadeEstoque = QuantidadeEstoque - "+qtdRecebida+"  WHERE IdProduto = "+idProduto);
            st.execute();
        }catch(SQLException e){
            System.out.println("Erro ao deletar "+e);
        }
    }
    
}
