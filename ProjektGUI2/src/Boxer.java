import java.util.Random;

public class Boxer implements Runnable {
    MyTableModel mapa;
    int x;
    int y;

    Boxer(MyTableModel mapa, int x, int y) {
        this.mapa = mapa;
        this.x = x;
        this.y = y;
        mapa.setValueAt(MyTableModel.TypKomorki.BOXER, x, y);
    }
                public void ruchBoxera() throws MinimalnaLiczbaZyc {
                Random random = new Random();
                switch (random.nextInt(4)) {
                    case 0:
                        if (mapa.getValueAt(x - 1, y) == MyTableModel.TypKomorki.GRACZLEWO || mapa.getValueAt(x - 1, y) == MyTableModel.TypKomorki.GRACZPRAWO || mapa.getValueAt(x - 1, y) == MyTableModel.TypKomorki.GRACZGORA || mapa.getValueAt(x - 1, y) == MyTableModel.TypKomorki.GRACZDOL) {
                            if (PacMan.iloscZyc <= 0) {
                                PacMan.x = 0;
                                PacMan.y = 0;
                                throw new MinimalnaLiczbaZyc("Straciles wszystkie zycia!");
                            }
                            PacMan.iloscZyc = PacMan.iloscZyc - 1;
                            PacMan.x = 1;
                            PacMan.y = 1;
                            System.out.println(PacMan.iloscZyc);
                        }
                        if (mapa.getValueAt(x - 1, y) != MyTableModel.TypKomorki.SCIANA) {
                            if (mapa.getValueAt(x - 1, y) == MyTableModel.TypKomorki.JEDZONKO) {
                                mapa.setValueAt(MyTableModel.TypKomorki.JEDZONKO, x, y);
                                x = x - 1;
                                mapa.setValueAt(MyTableModel.TypKomorki.BOXER, x, y);
                            } else if (mapa.getValueAt(x - 1, y) != MyTableModel.TypKomorki.BOXER) {
                                mapa.setValueAt(MyTableModel.TypKomorki.BOXER, x - 1, y);
                                mapa.setValueAt(MyTableModel.TypKomorki.PUSTE, x, y);
                                x = x - 1;
                            }
                        }
                        try {
                            Thread.sleep(130);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

        case 1:
        if (mapa.getValueAt(x + 1, y) == MyTableModel.TypKomorki.GRACZLEWO || mapa.getValueAt(x + 1, y) == MyTableModel.TypKomorki.GRACZPRAWO || mapa.getValueAt(x + 1, y) == MyTableModel.TypKomorki.GRACZGORA || mapa.getValueAt(x + 1, y) == MyTableModel.TypKomorki.GRACZDOL) {
            if (PacMan.iloscZyc <= 0) {
                PacMan.x = 0;
                PacMan.y = 0;
                throw new MinimalnaLiczbaZyc("Straciles wszystkie zycia!");
            }
            PacMan.iloscZyc = PacMan.iloscZyc - 1;
            PacMan.x = 1;
            PacMan.y = 1;
            System.out.println(PacMan.iloscZyc);
        }
        if (mapa.getValueAt(x + 1, y) != MyTableModel.TypKomorki.SCIANA) {
            if (mapa.getValueAt(x + 1, y) == MyTableModel.TypKomorki.JEDZONKO) {
                mapa.setValueAt(MyTableModel.TypKomorki.JEDZONKO, x, y);
                x = x + 1;
                mapa.setValueAt(MyTableModel.TypKomorki.BOXER, x, y);
            } else if (mapa.getValueAt(x + 1, y) != MyTableModel.TypKomorki.BOXER) {
                mapa.setValueAt(MyTableModel.TypKomorki.BOXER, x + 1, y);
                mapa.setValueAt(MyTableModel.TypKomorki.PUSTE, x, y);
                x = x + 1;
            }
        }

        try {
            Thread.sleep(130);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


                break;
            case 2:
                    if (mapa.getValueAt(x, y + 1) == MyTableModel.TypKomorki.GRACZLEWO || mapa.getValueAt(x, y + 1) == MyTableModel.TypKomorki.GRACZPRAWO || mapa.getValueAt(x, y + 1) == MyTableModel.TypKomorki.GRACZGORA || mapa.getValueAt(x, y + 1) == MyTableModel.TypKomorki.GRACZDOL) {
                        if (PacMan.iloscZyc <= 0) {
                            PacMan.x = 0;
                            PacMan.y = 0;
                            throw new MinimalnaLiczbaZyc("Straciles wszystkie zycia!");
                        }
                        PacMan.iloscZyc = PacMan.iloscZyc - 1;
                        PacMan.x = 1;
                        PacMan.y = 1;
                        System.out.println(PacMan.iloscZyc);
                    }
                    if (mapa.getValueAt(x, y + 1) != MyTableModel.TypKomorki.SCIANA) {
                        if (mapa.getValueAt(x, y + 1) == MyTableModel.TypKomorki.JEDZONKO) {
                            mapa.setValueAt(MyTableModel.TypKomorki.JEDZONKO, x, y);
                            y = y + 1;
                            mapa.setValueAt(MyTableModel.TypKomorki.BOXER, x, y);
                        } else if (mapa.getValueAt(x, y+1) != MyTableModel.TypKomorki.BOXER){
                            mapa.setValueAt(MyTableModel.TypKomorki.BOXER, x, y + 1);
                            mapa.setValueAt(MyTableModel.TypKomorki.PUSTE, x, y);
                            y = y + 1;
                        }
                    }
                    try {
                        Thread.sleep(130);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                break;
            case 3:
                    if (mapa.getValueAt(x, y - 1) == MyTableModel.TypKomorki.GRACZLEWO || mapa.getValueAt(x, y - 1) == MyTableModel.TypKomorki.GRACZPRAWO || mapa.getValueAt(x, y - 1) == MyTableModel.TypKomorki.GRACZGORA || mapa.getValueAt(x, y - 1) == MyTableModel.TypKomorki.GRACZDOL) {
                        if (PacMan.iloscZyc <= 0) {
                            PacMan.x = 0;
                            PacMan.y = 0;
                            throw new MinimalnaLiczbaZyc("Straciles wszystkie zycia!");
                        }
                        PacMan.iloscZyc = PacMan.iloscZyc - 1;
                        PacMan.x = 1;
                        PacMan.y = 1;
                        System.out.println(PacMan.iloscZyc);
                    }
                    if (mapa.getValueAt(x, y - 1) != MyTableModel.TypKomorki.SCIANA) {
                        if (mapa.getValueAt(x, y - 1) == MyTableModel.TypKomorki.JEDZONKO) {
                            mapa.setValueAt(MyTableModel.TypKomorki.JEDZONKO, x, y);
                            y = y - 1;
                            mapa.setValueAt(MyTableModel.TypKomorki.BOXER, x, y);
                        } else if (mapa.getValueAt(x, y-1) != MyTableModel.TypKomorki.BOXER){
                            mapa.setValueAt(MyTableModel.TypKomorki.BOXER, x, y - 1);
                            mapa.setValueAt(MyTableModel.TypKomorki.PUSTE, x, y);
                            y = y - 1;
                        }
                    }
                    try {
                        Thread.sleep(130);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                break;
        }
                    Mapa.zycia.setText(String.valueOf("Zycia: " + PacMan.iloscZyc));
    }


    public void run() {
        while (true) {
            try {
                ruchBoxera();
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


