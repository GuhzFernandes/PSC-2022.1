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
public class UsuariosTableModel extends AbstractTableModel {

    private List<Usuario> dados = new ArrayList<>();
    private String[] colunas = {"Usuarios", "Senha", "Administrador"};
    
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
                return dados.get(linha).getUsuario();
            
            case 1:
                return dados.get(linha).getSenha();
            
            case 2:
                return dados.get(linha).getAdm();
            
            default:
                return null;      
        }
    }
    
    public void setTable(List<Usuario> lista){
        dados = lista;
    }
    
    public Usuario remover(int linha){
        return this.dados.get(linha);
    }
    
    public Usuario editar(int linha){
        return this.dados.get(linha);
    }
    
}
