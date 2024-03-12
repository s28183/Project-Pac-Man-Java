import javax.swing.*;

public class PacMan implements Runnable {
    public static int iloscZyc = 3;
    MyTableModel mapa;
    static int x;
    static int y;
    KeyHandler keyHandler;
    public static int punkty;

    PacMan(MyTableModel mapa, KeyHandler keyHandler, int x, int y) {
        this.mapa = mapa;
        this.keyHandler = keyHandler;
        this.x = x;
        this.y = y;
        mapa.setValueAt(MyTableModel.TypKomorki.GRACZLEWO, x, y);
    }

    public void ruchPacMana() throws MinimalnaLiczbaZyc {
        if (keyHandler.doGory && mapa.getValueAt(x - 1, y) != MyTableModel.TypKomorki.SCIANA) {
            while (mapa.getValueAt(x - 1, y) != MyTableModel.TypKomorki.SCIANA) {
                if (keyHandler.doPrawej || keyHandler.doLewej || keyHandler.doDolu) {
                    break;
                }
                mapa.setValueAt(MyTableModel.TypKomorki.PUSTE, x, y);
                x = x - 1;
                if (mapa.getValueAt(x, y) == MyTableModel.TypKomorki.JEDZONKO) {
                    punkty++;
                    //System.out.println(punkty);
                    mapa.setValueAt(MyTableModel.TypKomorki.PUSTE, x, y);
                }
                if (mapa.getValueAt(x, y) == MyTableModel.TypKomorki.BOXER) {
                    iloscZyc--;
                    x=1;
                    y=1;
                    System.out.println("Straciles zycie. zycia: " + iloscZyc);
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (iloscZyc <= 0) {
                        x = 0;
                        y = 0;
                            throw new MinimalnaLiczbaZyc("Straciles wszystkie zycia!");
                    }
                }
                    mapa.setValueAt(MyTableModel.TypKomorki.GRACZGORA, x, y);
                    try {
                        Thread.sleep(130);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        } else if (keyHandler.doDolu && mapa.getValueAt(x + 1, y) != MyTableModel.TypKomorki.SCIANA) {
            while (mapa.getValueAt(x + 1, y) != MyTableModel.TypKomorki.SCIANA) {
                if (keyHandler.doGory || keyHandler.doLewej || keyHandler.doPrawej) {
                    break;
                }
                mapa.setValueAt(MyTableModel.TypKomorki.PUSTE, x, y);
                x = x + 1;
                if (mapa.getValueAt(x, y) == MyTableModel.TypKomorki.JEDZONKO){
                    punkty++;
                    //System.out.println(punkty);
                    mapa.setValueAt(MyTableModel.TypKomorki.PUSTE, x, y);
                }
                if (mapa.getValueAt(x, y) == MyTableModel.TypKomorki.BOXER) {
                    iloscZyc--;
                    x = 1;
                    y = 1;
                    System.out.println("Straciles zycie. zycia: " + iloscZyc);
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (iloscZyc <= 0) {
                        x = 0;
                        y = 0;
                        throw new MinimalnaLiczbaZyc("Straciles wszystkie zycia!");
                    }
                }
                mapa.setValueAt(MyTableModel.TypKomorki.GRACZPRAWO, x, y);
                try {
                    Thread.sleep(130);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else if (keyHandler.doLewej && mapa.getValueAt(x, y - 1) != MyTableModel.TypKomorki.SCIANA) {
            while (mapa.getValueAt(x, y - 1) != MyTableModel.TypKomorki.SCIANA) {
                if (keyHandler.doGory || keyHandler.doPrawej || keyHandler.doDolu) {
                    break;
                }
                mapa.setValueAt(MyTableModel.TypKomorki.PUSTE, x, y);
                y = y - 1;
                if (mapa.getValueAt(x, y) == MyTableModel.TypKomorki.JEDZONKO){
                    punkty++;
                    //System.out.println(punkty);
                    mapa.setValueAt(MyTableModel.TypKomorki.PUSTE, x, y);
                }
                if (mapa.getValueAt(x, y) == MyTableModel.TypKomorki.BOXER) {
                    iloscZyc--;
                    x = 1;
                    y = 1;
                    System.out.println("Straciles zycie. zycia: " + iloscZyc);
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (iloscZyc <= 0) {
                        x = 0;
                        y = 0;
                        throw new MinimalnaLiczbaZyc("Straciles wszystkie zycia!");
                    }
                }
                mapa.setValueAt(MyTableModel.TypKomorki.GRACZLEWO, x, y);
                try {
                    Thread.sleep(130);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else if (keyHandler.doPrawej && mapa.getValueAt(x, y + 1) != MyTableModel.TypKomorki.SCIANA) {
            while (mapa.getValueAt(x, y + 1) != MyTableModel.TypKomorki.SCIANA) {
                if (keyHandler.doGory || keyHandler.doLewej || keyHandler.doDolu) {
                    break;
                }
                mapa.setValueAt(MyTableModel.TypKomorki.PUSTE, x, y);
                y = y + 1;
                if (mapa.getValueAt(x, y) == MyTableModel.TypKomorki.JEDZONKO){
                    punkty++;
                    // System.out.println(punkty);
                    mapa.setValueAt(MyTableModel.TypKomorki.PUSTE, x, y);
                }
                if (mapa.getValueAt(x, y) == MyTableModel.TypKomorki.BOXER) {
                    iloscZyc--;
                    x = 1;
                    y = 1;
                    System.out.println("Straciles zycie. zycia: " + iloscZyc);
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (iloscZyc <= 0) {
                        x = 0;
                        y = 0;
                        throw new MinimalnaLiczbaZyc("Straciles wszystkie zycia!");
                    }
                }
                mapa.setValueAt(MyTableModel.TypKomorki.GRACZDOL, x, y);
                try {
                    Thread.sleep(130);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        Mapa.punkty.setText(String.valueOf("Punkty: " + punkty));
        Mapa.zycia.setText(String.valueOf("Zycia: " + iloscZyc));
    }


    public void run() {
        while (true) {
            try {
                ruchPacMana();
            } catch (MinimalnaLiczbaZyc e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(150);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

}
