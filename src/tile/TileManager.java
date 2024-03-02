package tile;

import main.Lienzo;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

class TileNode {
    BufferedImage texture;
    int x, y;

    TileNode(BufferedImage texture, int x, int y) {
        this.texture = texture;
        this.x = x;
        this.y = y;
    }
}

public class TileManager {

    private List<TileNode> tiles;  // Usamos la interfaz List para representar la lista enlazada

    private Lienzo gp;

    public TileManager(Lienzo gp) {
        this.gp = gp;
        this.tiles = new LinkedList<>();  // Utilizamos LinkedList como implementación de List
        getTileImages();
    }

    private void getTileImages() {
        try {
            BufferedImage texture1 = ImageIO.read(getClass().getResourceAsStream("/Sprites de personaje/1LU.png"));
            BufferedImage texture2 = ImageIO.read(getClass().getResourceAsStream("/Sprites de personaje/1LU.png"));
            BufferedImage texture3 = ImageIO.read(getClass().getResourceAsStream("/Sprites de personaje/1LU.png"));
            BufferedImage texture4 = ImageIO.read(getClass().getResourceAsStream("/Sprites de personaje/1LU.png"));
            BufferedImage texture5 = ImageIO.read(getClass().getResourceAsStream("/Sprites de personaje/1LU.png"));
            BufferedImage texture6 = ImageIO.read(getClass().getResourceAsStream("/Sprites de personaje/1LU.png"));
            BufferedImage texture7 = ImageIO.read(getClass().getResourceAsStream("/Sprites de personaje/1LU.png"));
            BufferedImage texture8 = ImageIO.read(getClass().getResourceAsStream("/Sprites de personaje/1LU.png"));
            BufferedImage texture9 = ImageIO.read(getClass().getResourceAsStream("/Sprites de personaje/1LU.png"));
            BufferedImage texture10 = ImageIO.read(getClass().getResourceAsStream("/Sprites de personaje/1LU.png"));
            BufferedImage texture11 = ImageIO.read(getClass().getResourceAsStream("/Sprites de personaje/1LU.png"));
            BufferedImage texture12 = ImageIO.read(getClass().getResourceAsStream("/Sprites de personaje/1LU.png"));
            BufferedImage texture13 = ImageIO.read(getClass().getResourceAsStream("/Sprites de personaje/1LU.png"));
            BufferedImage texture14 = ImageIO.read(getClass().getResourceAsStream("/Sprites de personaje/1LU.png"));
            BufferedImage texture15 = ImageIO.read(getClass().getResourceAsStream("/Sprites de personaje/1LU.png"));
            // Agrega más texturas según sea necesario

            // Ajusta las coordenadas x de cada nodo para que estén en la misma fila
            int currentX = 0;
            for (BufferedImage texture : List.of(texture1, texture2, texture3, texture4, texture5, texture6, texture7, texture8, texture9, texture10, texture11, texture12, texture13,texture14 ,texture15)) {
                tiles.add(new TileNode(texture, currentX, 0));
                currentX += texture.getWidth();
            }

            // Agrega más nodos según sea necesario
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics g2) {
        // Dibuja cada bloque de la lista en su posición
        for (TileNode node : tiles) {
            g2.drawImage(node.texture, node.x, node.y, null);
        }
    }
}
