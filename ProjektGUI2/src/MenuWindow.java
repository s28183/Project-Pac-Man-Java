import javax.swing.*;
import java.awt.*;

public class MenuWindow extends JFrame {
    public MenuWindow(){
        generowanieMenuWindow();
    }
    public void generowanieMenuWindow(){
        setMinimumSize(new Dimension(750,750));
        setLayout(new BorderLayout());
        getContentPane().add(new MenuButtonPanel(this), BorderLayout.CENTER);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
