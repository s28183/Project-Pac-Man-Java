import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class MyTableModel extends AbstractTableModel {
    private TypKomorki[][] data;

    public enum TypKomorki {
        BOXER("Img/Boxer.png"),
        GRACZLEWO("Img/PacmanLewo.png"),
        GRACZGORA("Img/PacmanGora.png"),
        GRACZPRAWO("Img/PacmanPrawo.png"),
        GRACZDOL("Img/PacmanDol.png"),
        JEDZONKO("Img/Truskawka2.png"),
        PUSTE("Img/Puste.png"),
        SCIANA("Img/Sciana2.png");

        private ImageIcon imageIcon;

        TypKomorki(String imgPath) {
            try {
                BufferedImage image = ImageIO.read(new File(imgPath));
                this.imageIcon = new ImageIcon(image);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public ImageIcon getImageIcon() {
            return this.imageIcon;
        }
    }


    public MyTableModel() {
        int wiersz = Slider.wiersz;
        int kolumna = Slider.kolumna;
        this.data = new TypKomorki[wiersz][kolumna];
        for (int i = 0; i < wiersz; i++) {
            for (int j = 0; j < kolumna; j++) {
                data[i][j] = TypKomorki.PUSTE;
            }
        }

    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return data[0].length;
    }

    @Override
    public Object getValueAt(int wiersz, int kolumna) {
        return data[wiersz][kolumna];
    }

    @Override
    public void setValueAt(Object value, int wiersz, int kolumna) {
        if (value instanceof TypKomorki) {
            data[wiersz][kolumna] = (TypKomorki) value;
            fireTableCellUpdated(wiersz, kolumna);
        } else {
            throw new IllegalArgumentException("Zly typ komorki");
        }
    }
}
