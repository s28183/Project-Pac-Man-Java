import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean doGory, doDolu, doLewej, doPrawej;
    Mapa mapa;
    @Override
    public void keyTyped(KeyEvent e) {
    }
    KeyHandler(Mapa mapa){
        this.mapa = mapa;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_Q && e.isControlDown() && e.isShiftDown()){
        mapa.dispose();
        }
        int przycisk = e.getKeyCode();
        if (przycisk == KeyEvent.VK_W) {
            doGory = true;
            doDolu = false;
            doPrawej = false;
            doLewej = false;
//            System.out.println("w");
        } else if (przycisk == KeyEvent.VK_S) {
            doDolu = true;
            doGory = false;
            doPrawej = false;
            doLewej = false;
//            System.out.println("s");
        } else if (przycisk == KeyEvent.VK_A) {
            doLewej = true;
            doGory = false;
            doDolu = false;
            doPrawej = false;
//            System.out.println("a");
        } else if (przycisk == KeyEvent.VK_D) {
            doPrawej = true;
            doGory = false;
            doDolu = false;
            doLewej = false;
//            System.out.println("d");
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
//
    }
}


