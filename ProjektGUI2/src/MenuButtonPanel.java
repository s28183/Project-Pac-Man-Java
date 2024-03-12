import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuButtonPanel extends JPanel {
    MenuWindow menuWindow;
    JButton newGameButton;
    JButton resultsButton;
    JButton exitButton;


    public MenuButtonPanel(MenuWindow menuWindow) {
        this.menuWindow = menuWindow;
        generowanieMenuButtonPanel();
        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                Dimension wymiar = new Dimension(menuWindow.getWidth() / 4, menuWindow.getHeight() / 8);
                updateButtonSize(wymiar);
                revalidate();
            }
        });
    }

    public void generowanieMenuButtonPanel() {
        setLayout(new GridLayout(3, 1));
        newGameButton = new JButton("New Game");
        resultsButton = new JButton("Results");
        exitButton = new JButton("Exit");
        setBackground(Color.BLACK);
        newGameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Slider slider = new Slider();
            }
        });

        resultsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(newGameButton);
        add(resultsButton);
        add(exitButton);
        setBackground(Color.BLACK);
    }

    private void updateButtonSize(Dimension wymiar) {
        if (newGameButton != null && resultsButton != null && exitButton != null) {
            newGameButton.setPreferredSize(wymiar);
            resultsButton.setPreferredSize(wymiar);
            exitButton.setPreferredSize(wymiar);
        }
    }
}


