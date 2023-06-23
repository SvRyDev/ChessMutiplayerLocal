package Elementos;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Arturo
 */
public class Pieza {

    int idPieza;
    String nombre;

    int corTableroX;
    int corTableroY;

    int corVentX;
    int corVentY;

    boolean esBlanco;
    LinkedList<Pieza> listaPiezas;

    ArrayList<Coordenada> movimientosValidos;

    public static BufferedImage imgPrincipal;
    public static Image[] imgs;
    public Image fotopieza;

    public Pieza(int corTableroX, int corTableroY, boolean esBlanco, LinkedList<Pieza> listaPiezas, String nombre) {

        this.corTableroX = corTableroX;
        this.corTableroY = corTableroY;
        this.corVentX = corTableroX * 64;
        this.corVentY = corTableroY * 64;
        this.esBlanco = esBlanco;
        this.nombre = nombre;
        listaPiezas.add(this);
        this.listaPiezas = listaPiezas;
        //  this.movimientosValidos = coo;

        fotopieza = subirImage();

    }

    public static void guardarImage() throws IOException {
        imgPrincipal = ImageIO.read(new File("D:\\Archivos-Usuario\\Documentos\\NetBeansProjects\\ChessMutiplayerLocal\\src\\img\\pieces.png"));
        imgs = new Image[12];
        int ind = 0;
        for (int y = 0; y < 400; y += 200) {
            for (int x = 0; x < 1200; x += 200) {
                imgs[ind] = imgPrincipal.getSubimage(x, y, 200, 200).getScaledInstance(64, 64, BufferedImage.SCALE_SMOOTH);
                ind++;
            }
        }
    }

    public Image subirImage() {
        try {
            guardarImage();
        } catch (IOException ex) {
            Logger.getLogger(Pieza.class.getName()).log(Level.SEVERE, null, ex);
        }
        int ind = 0;
        for (Pieza p : listaPiezas) {
            ind = 0;
            if (p.nombre.equalsIgnoreCase("rey")) {
                ind = 0;
            }
            if (p.nombre.equalsIgnoreCase("reina")) {
                ind = 1;
            }
            if (p.nombre.equalsIgnoreCase("alfil")) {
                ind = 2;
            }
            if (p.nombre.equalsIgnoreCase("caballo")) {
                ind = 3;
            }
            if (p.nombre.equalsIgnoreCase("torre")) {
                ind = 4;
            }
            if (p.nombre.equalsIgnoreCase("peon")) {
                ind = 5;
            }
            if (!p.esBlanco) {
                ind += 6;
            }
            //Dibujar la imagen del objeto pieza, 
            //g.drawImage(imgs[ind], p.x, p.y, this);
            fotopieza = imgs[ind];
        }

        System.out.println("PASO POR EL METODO SUBIRTIMAGE: \n "
                + "Int =  " + ind
                + "\nImage = " + fotopieza
                + "\nListaPieza : " + listaPiezas
                + "\nNombre = " + nombre
                + "\nColeccion = " + imgs[ind]
        );
        fotopieza = imgs[ind];
        return fotopieza;
    }

    public ArrayList<Coordenada> movimiento(int posicionX, int posicionY) {
        return movimientosValidos;
    }

    public void mover(int xp, int yp) {

        boolean validarMov = false;

        for (Coordenada c : movimientosValidos) {
            if (xp == c.getX() && yp == c.getY()) {
                validarMov = true;
                break;
            }
        }

        if (Tablero1.getPiece(xp * 64, yp * 64) != null) {

            if (Tablero1.getPiece(xp * 64, yp * 64).esBlanco != esBlanco) {
                Tablero1.getPiece(xp * 64, yp * 64).asesinar();

            } else {
                corVentX = this.corTableroX * 64;
                corVentY = this.corTableroY * 64;
                System.out.println("No puede matar a su mismo color, no sea Imbecil >:v");
                System.out.println("Rango de movimiento = " + movimientosValidos);
                return;
            }

        }
        if (validarMov) {
            this.corTableroX = xp;
            this.corTableroY = yp;
            corVentX = xp * 64;
            corVentY = yp * 64;
        }
        corVentX = this.corTableroX * 64;
        corVentY = this.corTableroY * 64;

    }

    public void asesinar() {
        listaPiezas.remove(this);
    }

}
