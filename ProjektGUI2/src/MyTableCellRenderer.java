import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class MyTableCellRenderer extends DefaultTableCellRenderer {
    private ImageIcon PacmanLewo;
    private ImageIcon PacmanPrawo;
    private ImageIcon PacmanDol;
    private ImageIcon PacmanGora;
    private ImageIcon Sciana;
    private ImageIcon Puste;
    private ImageIcon Truskawka;
    private ImageIcon Boxer;
    int counter;
    MyTableCellRenderer(){
        zaladujObraz();
    }
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        try{
        if(value == MyTableModel.TypKomorki.JEDZONKO) {
            Image imageJedzonko = Truskawka.getImage();
            Image newimgJedzonko = imageJedzonko.getScaledInstance(table.getWidth() / table.getColumnCount() / 2, table.getHeight() / table.getRowCount() / 2, Image.SCALE_SMOOTH);
            return new JLabel(new ImageIcon(newimgJedzonko));
        }
        } catch (Exception e){
                System.out.print("");
            }

        if(value == MyTableModel.TypKomorki.PUSTE){
         Image imagePuste = Puste.getImage();
         Image newimgPuste = imagePuste.getScaledInstance(table.getWidth()/table.getColumnCount(), table.getHeight()/table.getRowCount(), Image.SCALE_SMOOTH);
            return new JLabel((new ImageIcon(newimgPuste)));
        }
        if(value == MyTableModel.TypKomorki.SCIANA){
            Image imageSciana = Sciana.getImage();
            Image newimgSciana = imageSciana.getScaledInstance(table.getWidth()/table.getColumnCount(),table.getHeight()/table.getRowCount(), Image.SCALE_SMOOTH);
            return new JLabel(new ImageIcon(newimgSciana));
        }
        if(value == MyTableModel.TypKomorki.GRACZPRAWO){
            Image imagePacMan = PacmanDol.getImage();
            Image newimgPacMan = imagePacMan.getScaledInstance(table.getWidth()/table.getColumnCount(),table.getHeight()/table.getRowCount(), Image.SCALE_SMOOTH);
            return new JLabel(new ImageIcon(newimgPacMan));
        }
        if(value == MyTableModel.TypKomorki.GRACZLEWO){
            Image imagePacMan = PacmanLewo.getImage();
            Image newimgPacMan = imagePacMan.getScaledInstance(table.getWidth()/table.getColumnCount(),table.getHeight()/table.getRowCount(), Image.SCALE_SMOOTH);
            return new JLabel(new ImageIcon(newimgPacMan));
        }
        if(value == MyTableModel.TypKomorki.GRACZGORA){
            Image imagePacMan = PacmanGora.getImage();
            Image newimgPacMan = imagePacMan.getScaledInstance(table.getWidth()/table.getColumnCount(),table.getHeight()/table.getRowCount(), Image.SCALE_SMOOTH);
            return new JLabel(new ImageIcon(newimgPacMan));
        }
        if(value == MyTableModel.TypKomorki.GRACZDOL){
            Image imagePacMan = PacmanPrawo.getImage();
            Image newimgPacMan = imagePacMan.getScaledInstance(table.getWidth()/table.getColumnCount(),table.getHeight()/table.getRowCount(), Image.SCALE_SMOOTH);
            return new JLabel(new ImageIcon(newimgPacMan));
        }
        if(value == MyTableModel.TypKomorki.BOXER){
            Image imageBoxer = Boxer.getImage();
            Image newimgBoxer = imageBoxer.getScaledInstance(table.getWidth()/table.getColumnCount(),table.getHeight()/table.getRowCount(), Image.SCALE_SMOOTH);
            return new JLabel(new ImageIcon(newimgBoxer));
        }
        return null;
    }
    public void zaladujObraz(){
        PacmanLewo = new ImageIcon("Img/PacmanLewo.png");
        PacmanPrawo = new ImageIcon("Img/PacmanPrawo.png");
        PacmanDol = new ImageIcon("Img/PacmanDol.png");
        PacmanGora = new ImageIcon("Img/PacmanGora.png");
        Sciana = new ImageIcon("Img/Sciana2.png");
        Puste = new ImageIcon("Img/Puste.png");
        Truskawka = new ImageIcon("Img/Truskawka2.png");
        Boxer = new ImageIcon("Img/Boxer.png");
    }

}
