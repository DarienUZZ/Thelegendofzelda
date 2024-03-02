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
            //Primera fila superior
            BufferedImage texture1 = ImageIO.read(getClass().getResourceAsStream("/Sprites de personaje/1LU.png"));
            BufferedImage texture2 = ImageIO.read(getClass().getResourceAsStream("/Sprites de personaje/1U.png"));
            BufferedImage texture3 = ImageIO.read(getClass().getResourceAsStream("/Sprites de personaje/2U.png"));
            BufferedImage texture4 = ImageIO.read(getClass().getResourceAsStream("/Sprites de personaje/3U.png"));
            BufferedImage texture5 = ImageIO.read(getClass().getResourceAsStream("/Sprites de personaje/4U.png"));
            BufferedImage texture6 = ImageIO.read(getClass().getResourceAsStream("/Sprites de personaje/5U.png"));
            BufferedImage texture7 = ImageIO.read(getClass().getResourceAsStream("/Sprites de personaje/6U.png"));
            BufferedImage texture8 = ImageIO.read(getClass().getResourceAsStream("/Sprites de personaje/7U.png"));
            BufferedImage texture9 = ImageIO.read(getClass().getResourceAsStream("/Sprites de personaje/8U.png"));
            BufferedImage texture10 = ImageIO.read(getClass().getResourceAsStream("/Sprites de personaje/9U.png"));
            BufferedImage texture11 = ImageIO.read(getClass().getResourceAsStream("/Sprites de personaje/10U.png"));
            BufferedImage texture12 = ImageIO.read(getClass().getResourceAsStream("/Sprites de personaje/11U.png"));
            BufferedImage texture13 = ImageIO.read(getClass().getResourceAsStream("/Sprites de personaje/12U.png"));
            BufferedImage texture14 = ImageIO.read(getClass().getResourceAsStream("/Sprites de personaje/13U.png"));
            BufferedImage texture15 = ImageIO.read(getClass().getResourceAsStream("/Sprites de personaje/1RU.png"));

            //Segunda fila
            BufferedImage texture16 = ImageIO.read(getClass().getResourceAsStream("/Sprites de personaje/1f2.png"));
            BufferedImage texture17 = ImageIO.read(getClass().getResourceAsStream("/Sprites de personaje/2f2.png")); // Cambia "Empty.png" por la textura que desees
            BufferedImage texture18 = ImageIO.read(getClass().getResourceAsStream("/Sprites de personaje/3f2.png"));
            BufferedImage texture19 = ImageIO.read(getClass().getResourceAsStream("/Sprites de personaje/4f2.png"));
            BufferedImage texture20 = ImageIO.read(getClass().getResourceAsStream("/Sprites de personaje/5f2.png"));
            BufferedImage texture21 = ImageIO.read(getClass().getResourceAsStream("/Sprites de personaje/6f2.png"));
            BufferedImage texture22 = ImageIO.read(getClass().getResourceAsStream("/Sprites de personaje/7f2.png"));
            BufferedImage texture23 = ImageIO.read(getClass().getResourceAsStream("/Sprites de personaje/8f2.png"));
            BufferedImage texture24 = ImageIO.read(getClass().getResourceAsStream("/Sprites de personaje/9f2.png"));
            BufferedImage texture25 = ImageIO.read(getClass().getResourceAsStream("/Sprites de personaje/10f2.png"));
            BufferedImage texture26 = ImageIO.read(getClass().getResourceAsStream("/Sprites de personaje/11f2.png"));
            BufferedImage texture27 = ImageIO.read(getClass().getResourceAsStream("/Sprites de personaje/12f2.png"));
            BufferedImage texture28 = ImageIO.read(getClass().getResourceAsStream("/Sprites de personaje/13f2.png"));
            BufferedImage texture29 = ImageIO.read(getClass().getResourceAsStream("/Sprites de personaje/14f2.png"));
            BufferedImage texture30 = ImageIO.read(getClass().getResourceAsStream("/Sprites de personaje/15f2.png"));



            // Agrega más texturas según sea necesario

            // Ajusta las coordenadas x de cada nodo para que estén en la misma fila
            int currentX = 0;
            for (BufferedImage texture : List.of(texture1, texture2, texture3, texture4, texture5, texture6, texture7, texture8, texture9, texture10, texture11, texture12, texture13,texture14 ,texture15)) {
                tiles.add(new TileNode(texture, currentX, 0));
                currentX += texture.getWidth();
            }

            // Agrega más nodos según sea necesario

            // Calcula la altura total de la primera fila
            int firstRowHeight = texture1.getHeight();

            // Para la fila 2
            int currentXSecondRow = 0;  // Comienza en la posición x=0 para la segunda fila

            // Ajusta la coordenada y para que esté debajo de la primera fila
            int currentYSecondRow = firstRowHeight;

            for (BufferedImage texture : List.of(texture16, texture17, texture18, texture19, texture20, texture21, texture22, texture23, texture24, texture25, texture26, texture27, texture28, texture29, texture30)) {
                // Ajusta la coordenada x e y
                tiles.add(new TileNode(texture, currentXSecondRow, currentYSecondRow));
                currentXSecondRow += texture.getWidth();
            }

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
