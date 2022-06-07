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
public class VendasTableModel extends AbstractTableModel{
    private List<Venda> dados = new ArrayList<>();
    private String[] colunas = {"Codigo de Venda", "Produto", "Quantidade Vendida", "Data de Venda"};
    
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
                return dados.get(linha).getIdVenda();
            
            case 1:
                return dados.get(linha).getProdutoTexto();
            
            case 2:
                return dados.get(linha).getQtdVendida();
                
            case 3: 
                return dados.get(linha).getDataVenda();
                      
            default:
                return null;  
                
        }
    }
    
    public void setTable(List<Venda> lista){
        dados = lista;
    }
    
    public Venda remover(int linha){
        return this.dados.get(linha);
    }
    
    public Venda editar(int linha){
        return this.dados.get(linha);
    }
}
