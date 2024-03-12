//import javax.imageio.ImageIO;
//import javax.swing.*;
//import javax.swing.table.AbstractTableModel;
//import javax.swing.table.DefaultTableCellRenderer;
//import java.awt.*;
//import java.awt.event.ComponentAdapter;
//import java.awt.event.ComponentEvent;
//import java.awt.image.BufferedImage;
//import java.io.IOException;
//
//public class Mapa extends JFrame{
//    public JTable jTable;
//    public MyTableModel tableModel;
//    private BufferedImage pacMan;
//    private BufferedImage jedzonko;
//    JPanel jPanel = new JPanel(new GridBagLayout());
//    Mapa(){
//        generowanieMapy();
//            addComponentListener(new ComponentAdapter() {
//                @Override
//                public void componentResized(ComponentEvent e) {
//                    odswiezMape();
//                }
//            });
//    }
//    public void generowanieMapy(){
//        jPanel.setBackground(Color.BLACK);
//        setLayout(new BorderLayout());
//        tableModel = new MyTableModel();
//        jTable = new JTable(tableModel);
//        jTable.setRowHeight(20);
//        jPanel.add(jTable);
//        getContentPane().add(jPanel, BorderLayout.CENTER);
//        setVisible(true);
//        pack();
//        setLocationRelativeTo(null);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }
//    public void foty(){
//        try{
//            pacMan = ImageIO.read(getClass().getResource("C:\\Users\\jaros\\Downloads\\PacMan.piskel"));
//            jedzonko = ImageIO.read(getClass().getResource("C:\\Users\\jaros\\Downloads\\Jedzonko.piskel"));
//        } catch (IOException e){
//            e.printStackTrace();
//        }
//    }
//    public void odswiezMape(){
//        int minSize = Math.min(jPanel.getWidth() / tableModel.getColumnCount(), jPanel.getHeight() / tableModel.getRowCount());
//        jTable.setRowHeight(minSize);
//        for (int i = 0; i < tableModel.getColumnCount(); i++) {
//            jTable.getColumnModel().getColumn(i).setPreferredWidth(minSize);
//        }
//    }
//    public void generowanieScian(){
//        for(int i = 0; i < tableModel.getRowCount()-1; i++){
//            for(int j = 0; j < tableModel.getColumnCount()-1; j++){
//                tableModel.setValueAt(new MyTableModel(i,j));
//            }
//        }
//    }
//}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Mapa extends JFrame {
    public JTable jTable;
    public MyTableModel tableModel;
    JPanel jPanel = new JPanel(new GridBagLayout());
    KeyHandler keyHandler;
    Thread pacMan;
    Thread Boxer1;
    Thread Boxer2;
    Thread Boxer3;
    static JLabel punkty;
    static JLabel zycia;

    MyTableCellRenderer cellRenderer = new MyTableCellRenderer();

    Mapa() {
        keyHandler = new KeyHandler(this);
        generowanieMapy();
        generowanieLabirytnu();
        addKeyListener(keyHandler);
        setFocusable(true);
        pacMan = new Thread(new PacMan(tableModel, keyHandler, 1, 1));
        Boxer1 = new Thread(new Boxer(tableModel, tableModel.getColumnCount()-2, 1));
        Boxer2 = new Thread(new Boxer(tableModel, tableModel.getColumnCount()-2, tableModel.getRowCount()-2));
        Boxer3 = new Thread(new Boxer(tableModel, 1, tableModel.getRowCount()-2));
        jTable.setDefaultRenderer(Object.class, cellRenderer);
        pacMan.start();
        Boxer1.start();
        Boxer2.start();
        Boxer3.start();

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                odswiezMape();
            }
        });
    }

    public void generowanieMapy() {
        jPanel.setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        tableModel = new MyTableModel();
        jTable = new JTable(tableModel);
        jPanel.setOpaque(true);
        Font font = new Font("Basic", Font.BOLD, 80);
        punkty = new JLabel();
        zycia = new JLabel();
        punkty.setFont(font);
        zycia.setFont(font);
        zycia.setBackground(Color.BLACK);
        zycia.setForeground(Color.WHITE);
        zycia.setOpaque(true);
        punkty.setOpaque(true);
        punkty.setBackground(Color.BLACK);
        punkty.setForeground(Color.WHITE);
        for (int i = 0; i < tableModel.getColumnCount(); i++) {
            jTable.getColumnModel().getColumn(i).setMinWidth(1);
        }
        jTable.setRowHeight(20);
        jTable.setOpaque(false);
        jPanel.add(jTable);
        getContentPane().add(jPanel, BorderLayout.CENTER);
        getContentPane().add(punkty, BorderLayout.LINE_START);
        getContentPane().add(zycia, BorderLayout.LINE_END);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void odswiezMape() {
        int minSize = Math.min(jPanel.getWidth() / tableModel.getColumnCount(), jPanel.getHeight() / tableModel.getRowCount());
        jTable.setRowHeight(minSize);
        for (int i = 0; i < tableModel.getColumnCount(); i++) {
            jTable.getColumnModel().getColumn(i).setPreferredWidth(minSize);
        }
    }

    public void generowanieLabirytnu() {
        //graniczne
        for (int i = 0; i < tableModel.getColumnCount(); i++) {
            tableModel.setValueAt(MyTableModel.TypKomorki.SCIANA, i, 0);
            tableModel.setValueAt(MyTableModel.TypKomorki.SCIANA, 0, i);
            tableModel.setValueAt(MyTableModel.TypKomorki.SCIANA, i, tableModel.getColumnCount() - 1);
            tableModel.setValueAt(MyTableModel.TypKomorki.SCIANA, tableModel.getColumnCount() - 1, i);
        }
        //rzedowe
        for (int i = 1; i < tableModel.getRowCount() - 1; i++) {
            for (int j = 1; j < tableModel.getColumnCount() - 1; j++) {
                if ((i % 2 == 0) && (i != tableModel.getRowCount() - 2)) {
                    tableModel.setValueAt(MyTableModel.TypKomorki.SCIANA, i, j);
                }
            }
        }
        //algorytm
        int wallCounter = 0;
        for (int row = 1; row < tableModel.getRowCount() - 1; row++) {
            for (int column = 2; column < tableModel.getColumnCount() - 2 && wallCounter < tableModel.getColumnCount() / 3; column++) {
                if (row % 2 == 1 && row < tableModel.getRowCount() - 2) {
                    if (Math.random() < 0.5 && tableModel.getValueAt(row, column + 1) != MyTableModel.TypKomorki.SCIANA && tableModel.getValueAt(row, column - 1) != MyTableModel.TypKomorki.SCIANA) {
                        tableModel.setValueAt(MyTableModel.TypKomorki.SCIANA, row, column);
                        if (row < tableModel.getRowCount() - 2) {
                            tableModel.setValueAt(MyTableModel.TypKomorki.PUSTE, row + 1, column - 1);
                            tableModel.setValueAt(MyTableModel.TypKomorki.PUSTE, row + 1, column + 1);
                        }
                        wallCounter++;
                        if (row != 1 && column + 1 < tableModel.getColumnCount() - 1 && tableModel.getValueAt(row - 1, column - 1) == MyTableModel.TypKomorki.SCIANA && tableModel.getValueAt(row - 1, column + 1) == MyTableModel.TypKomorki.SCIANA && tableModel.getValueAt(row, column) == MyTableModel.TypKomorki.SCIANA && tableModel.getValueAt(row - 1, column) == MyTableModel.TypKomorki.PUSTE) {
                            tableModel.setValueAt(MyTableModel.TypKomorki.PUSTE, row, column);
                            tableModel.setValueAt(MyTableModel.TypKomorki.PUSTE, row - 1, column - 1);
                            tableModel.setValueAt(MyTableModel.TypKomorki.PUSTE, row - 1, column + 1);
                            if (row < tableModel.getRowCount() - 2) {
                                tableModel.setValueAt(MyTableModel.TypKomorki.SCIANA, row + 1, column - 1);
                                tableModel.setValueAt(MyTableModel.TypKomorki.SCIANA, row + 1, column + 1);
                            }
                        }
                        column = column + 2;
                    }
                }
                if (column >= tableModel.getColumnCount() - 2) {
                    column = 2;
                }
            }
            wallCounter = 0;
        }
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            for (int j = 0; j < tableModel.getColumnCount(); j++) {
                if (tableModel.getValueAt(i,j) == MyTableModel.TypKomorki.PUSTE){
                    tableModel.setValueAt(MyTableModel.TypKomorki.JEDZONKO, i, j);
            }
        }
    }
    }
}






