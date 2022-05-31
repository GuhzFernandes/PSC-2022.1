/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.Modelos;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author gusta
 */
public class ProdutosTableModel extends AbstractTableModel{
    
    private List<Produto> dados = new ArrayList<>();
    private String[] colunas = {"Id", "Marca", "Nome","Preco","Quantidade Estoque"};
    
    @Override
    public String getColumnName(int column){
        return colunas[column];
    }
    
    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch(coluna){
            case 0:
                return dados.get(linha).getIdProduto();
            
            case 1:
                return dados.get(linha).getMarca();
            
            case 2:
                return dados.get(linha).getNome();
                
            case 3: 
                return dados.get(linha).getPreco();
                
            case 4:
                return dados.get(linha).getQtdEstoque();
            
            default:
                return null;  
                
        }
    }
    
    public void setTable(List<Produto> lista){
        dados = lista;
    }
    
    public Produto remover(int linha){
        return this.dados.get(linha);
    }
    
    public Produto editar(int linha){
        return this.dados.get(linha);
    }
}
