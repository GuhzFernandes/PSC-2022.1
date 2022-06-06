package sistema;
import sistema.GUI.*;
import java.time.LocalDateTime;

public class Sistema {

    public static void main(String[] args) {
        Login login = new Login();
        login.setVisible(true);
        LocalDateTime agora = LocalDateTime.now();
        System.out.println(agora);
    }
}
