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
public class RecebidosTableModel extends AbstractTableModel {

    private List<Recebido> dados = new ArrayList<>();
    private String[] colunas = {"Id", "Produto", "Quantidade Recebida", "Data de Recebimento"};
    
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
                return dados.get(linha).getIdRecebimento();
            
            case 1:
                return dados.get(linha).getProdutoTexto();
            
            case 2:
                return dados.get(linha).getQtdRecebida();
                
            case 3: 
                return dados.get(linha).getDataRecebimento();
                      
            default:
                return null;  
                
        }
    }
    
    public void setTable(List<Recebido> lista){
        dados = lista;
    }
    
    public Recebido remover(int linha){
        return this.dados.get(linha);
    }
    
    public Recebido editar(int linha){
        return this.dados.get(linha);
    }
}
