/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.DAO;
import sistema.Modelos.Produto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
/**
 *
 * @author gusta
 */
public class ProdutoDAO extends Conexao {
    
    public Produto checkProduto(int id){
        Produto produto = new Produto();
        try{
            st = conn.prepareStatement("SELECT * FROM projetoa3.produtos WHERE IdProduto = "+id);
            rs = st.executeQuery();
            while(rs.next()){
                produto.setId(rs.getInt("IdProduto"));
                produto.setMarca(rs.getString("Marca"));
                produto.setNome(rs.getString("Nome"));
                produto.setPreco(rs.getBigDecimal("Preco"));
                produto.setQtdEstoque(rs.getInt("QuantidadeEstoque"));
            }            
        }catch(SQLException e){
            System.out.println("Erro ao listar "+e);
        }
        return produto;
    }
    
    public List<Produto> listar(){
        List produtos = new ArrayList<>();
        Produto produto;
        try{
            st = conn.prepareStatement("SELECT * FROM projetoa3.produtos");
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
    
    public List<Produto> listarEstoque(boolean estoque){
        List produtos = new ArrayList<>();
        Produto produto;
        try{
            if (estoque){
                st = conn.prepareStatement("SELECT * FROM projetoa3.produtos WHERE QuantidadeEstoque > 0");
            }
            else{
                st = conn.prepareStatement("SELECT * FROM projetoa3.produtos WHERE QuantidadeEstoque = 0");
            }
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
        
    public List<Produto> listarPesquisa(String criterio){
        List produtos = new ArrayList<>();
        Produto produto;
        try{
            st = conn.prepareStatement("SELECT * FROM projetoa3.produtos WHERE Marca LIKE '%"+criterio+"%' OR Nome LIKE '%"+criterio+"%'");
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
        
    public void criar(String marca, String nome, BigDecimal preco, int qtdEstoque){
        try{
            st = conn.prepareStatement("INSERT INTO projetoa3.produtos (Marca,Nome,Preco,QuantidadeEstoque)VALUES('"+marca+"','"+nome+"',"+preco+","+qtdEstoque+")");
            st.execute();
            
        }catch(SQLException e){
            System.out.println("Erro ao Criar "+e);
        }
    }
        
    public void editar(String marca, String nome, BigDecimal preco, int qtdEstoque, int id){
        try{
            st = conn.prepareStatement("UPDATE projetoa3.produtos SET Marca = '"+marca+"', Nome = '"+nome+"', preco = "+preco+", QuantidadeEstoque = "+qtdEstoque+" WHERE IdProduto = "+id);
            st.execute();
        }catch(SQLException e){
            System.out.println("Erro ao atualizar "+e);
        }
    }
    
    public void remover(int id){
        try{
            st = conn.prepareStatement("DELETE FROM projetoa3.produtos WHERE IdProduto = "+id);
            st.execute();
        }catch(SQLException e){
            System.out.println("Erro ao deletar "+e);
        }
    }        
}
