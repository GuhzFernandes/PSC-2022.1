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
    
}
