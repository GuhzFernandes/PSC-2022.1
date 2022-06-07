/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.DAO;
import sistema.Modelos.Venda;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gusta
 */
public class VendaDAO extends Conexao {
    
    public Venda checkVenda(int id){
        Venda venda = new Venda();
        try{
            st = conn.prepareStatement("SELECT * FROM projetoa3.vendas WHERE IdVenda = "+id);
            rs = st.executeQuery();
            while(rs.next()){
                venda.setIdVenda(rs.getInt("IdVenda"));
                venda.setProduto(rs.getInt("Produto"));
                venda.setQtdVendida(rs.getInt("QuantidadeVendida"));
                venda.setPrecoUnitario(rs.getBigDecimal("PrecoUnitario"));
                venda.setDataVenda(rs.getTimestamp("DataVenda").toLocalDateTime());
                venda.setProdutoTexto();
            }
        }catch(SQLException e){
            System.out.println("Erro ao listar "+e);
        }
        return venda;
    }
    
    public List<Venda> listar(){
        List vendas = new ArrayList<>();
        Venda venda;
        try{
            st = conn.prepareStatement("SELECT * FROM projetoa3.vendas");
            rs = st.executeQuery();
            while(rs.next()){
                venda = new Venda();
                venda.setIdVenda(rs.getInt("IdVenda"));
                venda.setProduto(rs.getInt("Produto"));
                venda.setQtdVendida(rs.getInt("QuantidadeVendida"));
                venda.setPrecoUnitario(rs.getBigDecimal("PrecoUnitario"));
                venda.setDataVenda(rs.getTimestamp("DataVenda").toLocalDateTime());
                venda.setProdutoTexto();
                vendas.add(venda);
            }            
        }catch(SQLException e){
            System.out.println("Erro ao listar "+e);
        }
        return vendas;
    }
    
    public List<Venda> listarPesquisa(String criterio){
        List vendas = new ArrayList<>();
        Venda venda;
        try{
            st = conn.prepareStatement("SELECT * FROM projetoa3.vendas WHERE DataVenda LIKE '%"+criterio+"%' OR Produto LIKE '%"+criterio+"%'");
            rs = st.executeQuery();
            while(rs.next()){
                venda = new Venda();
                venda.setIdVenda(rs.getInt("IdVenda"));
                venda.setProduto(rs.getInt("Produto"));
                venda.setQtdVendida(rs.getInt("QuantidadeVendida"));
                venda.setPrecoUnitario(rs.getBigDecimal("PrecoUnitario"));
                venda.setDataVenda(rs.getTimestamp("DataVenda").toLocalDateTime());
                venda.setProdutoTexto();
                vendas.add(venda);
            }            
        }catch(SQLException e){
            System.out.println("Erro ao listar "+e);
        }
        return vendas;
    }
    
    public void criar(int idProduto, BigDecimal precoUnitario, int qtdVendida, LocalDateTime dataVenda){
        try{
            st = conn.prepareStatement("INSERT INTO projetoa3.vendas (Produto, PrecoUnitario, QuantidadeVendida, DataVenda)VALUES("+idProduto+","+precoUnitario+","+qtdVendida+",CONVERT('"+dataVenda+"', DATETIME))");
            st.execute();
            st = conn.prepareStatement("UPDATE projetoa3.Produtos SET QuantidadeEstoque = QuantidadeEstoque - "+qtdVendida+"  WHERE IdProduto = "+idProduto);
            st.execute();
        }catch(SQLException e){
            System.out.println("Erro ao Criar "+e);
        }
    }
    
    public void editar(int idProduto, int qtdAnterior, BigDecimal precoUnitario, int qtdVendida, LocalDateTime dataVenda, int idVenda){
        try{
            //10 - 15
            int qtdAtualizada = qtdVendida - qtdAnterior;
            st = conn.prepareStatement("UPDATE projetoa3.vendas SET QuantidadeVendida = "+qtdVendida+", DataVenda = CONVERT('"+dataVenda+"', DATETIME),PrecoUnitario = "+precoUnitario+" WHERE IdVenda = "+idVenda);
            st.execute();
            st = conn.prepareStatement("UPDATE projetoa3.Produtos SET QuantidadeEstoque = QuantidadeEstoque - "+qtdAtualizada+"  WHERE IdProduto = "+idProduto);
            st.execute();
        }catch(SQLException e){
            System.out.println("Erro ao atualizar "+e);
        }
    }
    
    public void remover(int idVenda,int qtdVendida,int idProduto){
        try{
            st = conn.prepareStatement("DELETE FROM projetoa3.vendas WHERE IdVenda = "+idVenda);
            st.execute();
            st = conn.prepareStatement("UPDATE projetoa3.vendas SET QuantidadeEstoque = QuantidadeEstoque + "+qtdVendida+"  WHERE IdProduto = "+idProduto);
            st.execute();
        }catch(SQLException e){
            System.out.println("Erro ao deletar "+e);
        }
    }    
}
