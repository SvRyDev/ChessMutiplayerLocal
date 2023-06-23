package Elementos;

import static Elementos.ventanaPrueba.principal;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import org.w3c.dom.css.RGBColor;

/**
 *
 * @author Arturo
 */
public class Tablero1 extends javax.swing.JPanel {

    int filas;
    int columnas;
    int dimension;

    Color color1;
    Color color2;

    //CUADRADOR PARA MARCAR CUANDO SE SELCCIONA LA PIEZA
    Bloque[][] cuadrados;

    static LinkedList<Pieza> ps = new LinkedList<>();

    ArrayList<Coordenada> cooAux = new ArrayList<>();

    Pieza piezaAux;

    Alfil Nalfil1 = new Alfil(1, 7, false, ps);
    Torre Btorre1 = new Torre(0, 0, true, ps);
    Torre Ntorre1 = new Torre(7, 0, false, ps);
    Torre Btorre2 = new Torre(7, 7, true, ps);
    Torre Ntorre2 = new Torre(0, 7, false, ps);
    Reina Breina = new Reina(2, 7, false, ps);

    public Tablero1() {
        initComponents();

    }

    public Tablero1(int filas, int columnas, int dimension, Color color1, Color color2) {
        //initComponents();
        eventosMouse();
        this.setBounds(50, 50, filas * dimension, columnas * dimension);
        this.filas = filas;
        this.columnas = columnas;
        this.dimension = dimension;
        this.color1 = color1;
        this.color2 = color2;

        cuadrados = new Bloque[filas][columnas];

        for (int y = 0; y < columnas; y++) {
            for (int x = 0; x < filas; x++) {
                cuadrados[x][y] = new Bloque(x * 64, y * 64, dimension, new Color(255, 255, 255, 0));
            }
        }

    }

    public void movimientosPieza() {
        if (piezaAux != null) {
            cooAux = piezaAux.movimiento(piezaAux.corTableroX, piezaAux.corTableroY);
            for (int i = 0; i < cooAux.size(); i++) {
                cuadrados[cooAux.get(i).getX()][cooAux.get(i).getY()].setColor(Color.black);
            }
            repaint();

            System.out.println("LA SALIDA DE LA IMAGEN DE TORRE ES  : " + piezaAux.fotopieza);
        }
    }

    public void limpiarMovimientos() {
        if (piezaAux != null) {
            for (int i = 0; i < cooAux.size(); i++) {
                cuadrados[cooAux.get(i).getX()][cooAux.get(i).getY()].setColor(new Color(255, 255, 252, 0));
            }
            repaint();

            System.out.println("LA SALIDA DE LA IMAGEN DE TORRE ES  : " + piezaAux.fotopieza);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        boolean white = true;
        for (int y = 0; y < columnas; y++) {
            for (int x = 0; x < filas; x++) {
                if (white) {
                    g.setColor(color1);
                } else {
                    g.setColor(color2);
                }
                white = !white;
                g.fillRect(x * 64, y * 64, dimension, dimension);
            }
            white = !white;
        }

        for (int y = 0; y < columnas; y++) {
            for (int x = 0; x < filas; x++) {
                g.setColor(cuadrados[x][y].getColor());
                g.fillOval(cuadrados[x][y].getX() + 16, cuadrados[x][y].getY() + 16, cuadrados[x][y].getDimension() - 32, cuadrados[x][y].getDimension() - 32);
            }
        }

        for (Pieza p : ps) {
            g.drawImage(p.fotopieza, p.corVentX, p.corVentY, this);
        }

    }

    public class Bloque {

        int x;
        int y;
        int dimension;
        Color color;

        public Bloque(int x, int y, int dimension, Color color) {
            this.x = x;
            this.y = y;
            this.dimension = dimension;
            this.color = color;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getDimension() {
            return dimension;
        }

        public void setDimension(int dimension) {
            this.dimension = dimension;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

    }

    public void pintarCasilla(ArrayList coo) {

    }

    public static Pieza getPiece(int x, int y) {
        Pieza piecita = null;

        int xp = x / 64;
        int yp = y / 64;
        System.out.println(xp + "___" + yp);
        for (Pieza p : ps) {

            if (p.corTableroX == xp && p.corTableroY == yp) {

                switch (p.nombre) {
                    case "torre":
                        piecita = new Torre(p.corTableroX, p.corTableroY, p.esBlanco, p.listaPiezas);
                        break;
                    case "alfil":
                        piecita = new Alfil(p.corTableroX, p.corTableroY, p.esBlanco, p.listaPiezas);
                        break;
                    case "reina":
                        piecita = new Reina(p.corTableroX, p.corTableroY, p.esBlanco, p.listaPiezas);
                        break;
                }

                p.asesinar();
                return piecita;
            }
        }
        return null;
    }

    private void eventosMouse() {
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                piezaAux = getPiece(e.getX(), e.getY());
                movimientosPieza();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                limpiarMovimientos();
                if (piezaAux != null) {
                    
                    piezaAux.mover((piezaAux.corVentX + 31) / 64, (piezaAux.corVentY + 31) / 64);
                    System.out.println(piezaAux.corTableroX + ":" + piezaAux.corTableroY);
                    repaint();

                }
                System.out.println("la coordenada del apnel es " + getBounds());
                piezaAux = null;
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        }
        );
        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (piezaAux != null) {
                    if (e.getX() >= 512) {
                        piezaAux.corVentX = 480;
                    } else if (e.getX() <= 0) {
                        piezaAux.corVentX = -32;
                    } else {
                        piezaAux.corVentX = e.getX() - 32;
                    }

                    if (e.getY() >= 512) {
                        piezaAux.corVentY = 480;
                    } else if (e.getY() <= 0) {
                        piezaAux.corVentY = -32;
                    } else {
                        piezaAux.corVentY = e.getY() - 32;
                    }

                    principal.txtCordenadas.setText("arrastrando:  " + e.getX() + " Y " + e.getY());

                }

                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }

        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 204, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1032, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 582, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
