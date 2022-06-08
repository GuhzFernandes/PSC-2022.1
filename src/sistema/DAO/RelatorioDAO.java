/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.DAO;
import sistema.Modelos.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author gusta
 */
public class RelatorioDAO extends Conexao{
    
    public List<Produto> listarForaEstoque(){
        List produtos = new ArrayList<>();
        Produto produto;
        try{
            st = conn.prepareStatement("SELECT * FROM projetoa3.produtos WHERE QuantidadeEstoque = 0");
            rs = st.executeQuery();
            while(rs.next()){
                produto = new Produto();
                produto.setId(rs.getInt("IdProduto"));
                produto.setMarca(rs.getString("Marca"));
                produto.setNome(rs.getString("Nome"));
                produto.setPreco(rs.getBigDecimal("Preco"));
                produto.setQtdEstoque(rs.getInt("QuantidadeEstoque"));
                produtos.add(produto);
            }            
        }catch(SQLException e){
            System.out.println("Erro ao listar "+e);
        }
        return produtos;
    }
    
    public List<Relatorio> listarVendasTotais(){
        List relatorio = new ArrayList<>();
        Relatorio produto;
        
        try{
            st = conn.prepareStatement("SELECT P.IdProduto, P.Marca, P.Nome, sum(V.QuantidadeVendida) AS 'Total Vendas' FROM projetoa3.produtos P INNER JOIN projetoa3.vendas V ON P.IdProduto = V.Produto GROUP BY V.Produto");
            rs = st.executeQuery();
            while(rs.next()){
                produto = new Relatorio();
                produto.setIdProduto(rs.getInt("IdProduto"));
                produto.setMarca(rs.getString("Marca"));
                produto.setNome(rs.getString("Nome"));
                produto.setQtd(rs.getInt("Total Vendas"));
                relatorio.add(produto);
            }            
        }catch(SQLException e){
            System.out.println("Erro ao listar "+e);
        }
        return relatorio;
    }
    /*
    public List<Relatorio> listarVendasMes(int ano, int mes){
        List relatorio = new ArrayList<>();
        Relatorio produto;
        
        try{
            st = conn.prepareStatement("SELECT P.IdProduto, P.Marca, P.Nome, SUM(V.QuantidadeVendida) AS 'Total Vendas'FROM projetoa3.produtos P INNER JOIN projetoa3.vendas V ON P.IdProduto = V.Produto WHERE V.DataVenda LIKE'"+ano+"-"+mes+"%' GROUP BY V.Produto;");
            rs = st.executeQuery();
            while(rs.next()){
                produto = new Relatorio();
                produto.setIdProduto(rs.getInt("IdProduto"));
                produto.setMarca(rs.getString("Marca"));
                produto.setNome(rs.getString("Nome"));
                produto.setQtd(rs.getInt("Total Vendas"));
                relatorio.add(produto);
            }            
        }catch(SQLException e){
            System.out.println("Erro ao listar "+e);
        }
        return relatorio;
    }
    
    public int totalVendasMes(int ano, int mes){
        int quantidade = 0;
        try{
            st = conn.prepareStatement("SELECT SUM(QuantidadeVendida) AS 'ValorTotal' FROM projetoa3.vendas WHERE DataVenda LIKE'"+ano+"-"+mes+"%'");
            rs = st.executeQuery();
            while(rs.next()){
               quantidade = rs.getInt("ValorTotal");
            }            
        }catch(SQLException e){
            System.out.println("Erro ao consultar "+e);
        }
        return quantidade;
    }
    */        
}
