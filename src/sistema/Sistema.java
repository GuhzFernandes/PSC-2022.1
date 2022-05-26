package sistema;
import sistema.Entidades.*;
import sistema.DAO.*;
import sistema.GUI.*;
import java.util.ArrayList;
import java.util.List;


public class Sistema {

    public static void main(String[] args) {
        //Login login = new Login();
        //login.setVisible(true);
        
        /*UsuarioDAO teste = new UsuarioDAO();
        teste.conectar();
        teste.Listar();
        List<Usuario> saida = teste.Listar();
        for (Usuario usuario : saida){
            System.out.println(usuario.getUsuario());
        } 
        */
        
        ProdutosDAO teste = new ProdutosDAO();
        teste.conectar();
    }
    
}
