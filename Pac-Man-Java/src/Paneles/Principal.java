package Paneles;

import Juego.Enemigos;
import Juego.Escenario;
import Juego.Fruta;
import Juego.Personaje;
import Juego.Vidas;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Principal extends JPanel {

    Escenario escenario = new Escenario();
    Personaje personaje = new Personaje();
    Enemigos enemigos = new Enemigos();
    Fruta fruta = new Fruta();
    Vidas vidas = new Vidas();

    public Principal() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                personaje.KeyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        setFocusable(true);
    }

    @Override
    public void paint(Graphics g) {

        escenario.paint(g);
        personaje.paint(g);
        enemigos.paint(g);
        fruta.paint(g);
        vidas.paint(g);
        setOpaque(false);
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Pac-Man");
        Principal prin = new Principal();

        ventana.setSize(600, 600);
        ventana.add(prin);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setVisible(true);

        while (true) {
            if (Vidas.vidas == 0) {
                    int reinciaJuego = JOptionPane.showConfirmDialog(null, "Haz perdido, "
                            + "¿Quieres reiniciar el Jugeo?", "Perdiste!!!", JOptionPane.YES_OPTION);
                    if (reinciaJuego == 0) {
                        reiniciaValores();
                    } else if (reinciaJuego == 1) {
                        System.exit(0);
                    }
                }
            try {
                Thread.sleep(100);    
            } catch (InterruptedException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            prin.repaint();
        }
    }

    public static void reiniciaValores() {
        Vidas.vidas = 3;
        Personaje.x = 40;
        Personaje.y = 40;
        Fruta.x = 240;
        Fruta.y = 120;
        Enemigos.xRojo = 120;
        Enemigos.yRojo = 320;
        Enemigos.xRosa = 120;
        Enemigos.yRosa = 120;
    }
}
