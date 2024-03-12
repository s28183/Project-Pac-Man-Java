import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Slider implements ChangeListener {

    JFrame frame;
    JPanel panel;
    JLabel label;
    JLabel label1;
    JSlider slider;
    JSlider slider1;
    JButton jbutton;
    static int wiersz;
    static int kolumna;

    Slider() {
        frame = new JFrame("Slider");
        panel = new JPanel();
        panel.setLayout(new GridLayout(5,1));
        label = new JLabel();
        label1 = new JLabel();
        slider = new JSlider(10, 100, 15);
        slider.setPreferredSize(new Dimension(200, 50));
        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(5);
        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(15);
        slider.setPaintLabels(true);
        slider.setFont(new Font("Arial", Font.PLAIN, 15));
        jbutton = new JButton("Zatwierdz");
        panel.add(jbutton);
        panel.add(slider, BorderLayout.CENTER);
        panel.add(jbutton, BorderLayout.SOUTH);
        frame.pack();
        jbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(()-> new Mapa());
                frame.dispose();
            }
        });

        slider1 = new JSlider(10, 100, 15);
        slider1.setPreferredSize(new Dimension(200, 50));
        slider1.setPaintTicks(true);
        slider1.setMinorTickSpacing(5);
        slider1.setPaintTrack(true);
        slider1.setMajorTickSpacing(15);
        slider1.setPaintLabels(true);
        slider1.setFont(new Font("Arial", Font.PLAIN, 15));

        label.setText("Wysokosc: " + slider.getValue());
        label1.setText("Szerokosc: " + slider1.getValue());

        slider.addChangeListener(this);
        slider1.addChangeListener(this);
        panel.add(label);
        panel.add(label1);
        panel.add(slider1);
        panel.add(slider);
        frame.add(panel);

        frame.setSize(400, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void stateChanged(ChangeEvent e) {
        wiersz = slider.getValue();
        kolumna = slider1.getValue();
        label.setText("Wysokosc: " + slider.getValue());
        label1.setText("Szerokosc: " + slider1.getValue());
    }
}
