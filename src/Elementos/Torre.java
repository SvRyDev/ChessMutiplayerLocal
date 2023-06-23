package Elementos;

import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Torre extends Pieza {

    static int id = 4;
    static String nombre = "torre";
    Image fotoImage = null;
    ArrayList<Coordenada> movimientosValidos;

    public Torre(int corTableroX, int corTableroY, boolean esBlanco, LinkedList<Pieza> listaPiezas) {
        super(corTableroX, corTableroY, esBlanco, listaPiezas, nombre);
        this.fotoImage = super.fotopieza;
    }

    public Image getFotoImage() {
        return fotoImage;
    }

    @Override
    public ArrayList<Coordenada> movimiento(int posicionX, int posicionY) {
        movimientosValidos = new ArrayList<>();
        
        // Movimientos hacia la izquierda
        for (int i = posicionX - 1; i >= 0; i--) {
            movimientosValidos.add(new Coordenada(i, posicionY));
        }

        // Movimientos hacia la derecha
        for (int i = posicionX + 1; i <= 7; i++) {
            movimientosValidos.add(new Coordenada(i, posicionY));
        }

        // Movimientos hacia abajo
        for (int i = posicionY - 1; i >= 0; i--) {
            movimientosValidos.add(new Coordenada(posicionX, i));
        }

        // Movimientos hacia arriba
        for (int i = posicionY + 1; i <= 7; i++) {
            movimientosValidos.add(new Coordenada(posicionX, i));
        }
        
        super.movimientosValidos = this.movimientosValidos;

        return movimientosValidos;
    }
}
