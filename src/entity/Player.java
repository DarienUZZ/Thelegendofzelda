package entity;

import main.KeyHandler;
import main.Lienzo;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{

    Lienzo gp;
    KeyHandler keyH;

    public Player ( Lienzo gp, KeyHandler keyH ){

        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues ();
        getPlayerImage ();
    }


    public void setDefaultValues(){

        x = 100;
        y = 100;
        speed = 4;
        direction = "Down";

    }
    public void getPlayerImage(){

        try{

            //UP
            up1 = ImageIO.read(getClass ().getResourceAsStream ( "/Sprites de personaje/link-sin-capa-atras.png" ));
            up2 = ImageIO.read(getClass ().getResourceAsStream ( "/Sprites de personaje/link-sin-capa-atras-2.png" ));
            up3 = ImageIO.read(getClass ().getResourceAsStream ( "/Sprites de personaje/link-sin-capa-atras-3.png" ));
            up4 = ImageIO.read(getClass ().getResourceAsStream ( "/Sprites de personaje/link-sin-capa-atras-4.png" ));
            up5 = ImageIO.read(getClass ().getResourceAsStream ( "/Sprites de personaje/link-sin-capa-atras-5.png" ));
            up6 = ImageIO.read(getClass ().getResourceAsStream ( "/Sprites de personaje/link-sin-capa-atras-6.png" ));
            up7 = ImageIO.read(getClass ().getResourceAsStream ( "/Sprites de personaje/link-sin-capa-atras-7.png" ));
            up8 = ImageIO.read(getClass ().getResourceAsStream ( "/Sprites de personaje/link-sin-capa-atras-8.png" ));
            up9 = ImageIO.read(getClass ().getResourceAsStream ( "/Sprites de personaje/link-sin-capa-atras-9.png" ));
            up10 = ImageIO.read(getClass ().getResourceAsStream ( "/Sprites de personaje/link-sin-capa-atras-10.png" ));
            up11 = ImageIO.read(getClass ().getResourceAsStream ( "/Sprites de personaje/link-sin-capa-atras-11.png" ));



            //DOWN

            down1 = ImageIO.read(getClass ().getResourceAsStream ( "/Sprites de personaje/link-sin-capa-frente.png" ));
            down2 = ImageIO.read(getClass ().getResourceAsStream ( "/Sprites de personaje/link-sin-capa-frente.png" ));

            //LEFT

            left1 = ImageIO.read(getClass ().getResourceAsStream ( "/Sprites de personaje/link-sin-capa-del-lado.png" ));
            left2 = ImageIO.read(getClass ().getResourceAsStream ( "/Sprites de personaje/link-sin-capa-del-lado-2.png" ));
            left3 = ImageIO.read(getClass ().getResourceAsStream ( "/Sprites de personaje/link-sin-capa-del-lado-3.png" ));
            left4 = ImageIO.read(getClass ().getResourceAsStream ( "/Sprites de personaje/link-sin-capa-del-lado-4.png" ));
            left5 = ImageIO.read(getClass ().getResourceAsStream ( "/Sprites de personaje/link-sin-capa-del-lado-5.png" ));
            left6 = ImageIO.read(getClass ().getResourceAsStream ( "/Sprites de personaje/link-sin-capa-del-lado-6.png" ));
            left7 = ImageIO.read(getClass ().getResourceAsStream ( "/Sprites de personaje/link-sin-capa-del-lado-7.png" ));
            left8 = ImageIO.read(getClass ().getResourceAsStream ( "/Sprites de personaje/link-sin-capa-del-lado-8.png" ));
            left9 = ImageIO.read(getClass ().getResourceAsStream ( "/Sprites de personaje/link-sin-capa-del-lado-9.png" ));
            left10 = ImageIO.read(getClass ().getResourceAsStream ( "/Sprites de personaje/link-sin-capa-del-lado-10.png" ));
            left11 = ImageIO.read(getClass ().getResourceAsStream ( "/Sprites de personaje/link-sin-capa-del-lado-11.png" ));

            right1 = ImageIO.read(getClass ().getResourceAsStream ( "/Sprites de personaje/link-sin-capa-del-ladoDerecho.png" ));
            right2 = ImageIO.read(getClass ().getResourceAsStream ( "/Sprites de personaje/link-sin-capa-del-ladoDerecho.png" ));
        }catch (IOException e){
            e.printStackTrace ();

        }

    }

    public void update(){
        if(keyH.upPressed == true){
            direction = "up";
            y -= speed;
        } else if (keyH.downPressed == true) {
            direction = "down";

            y += speed;
        } else if (keyH.leftPressed == true) {
            direction = "left";

            x -= speed;
        }else if (keyH.rightPressed == true) {
            direction = "right";

            x += speed;
        }

        spritCounter++;
        if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
            spritCounter++;
            if (spritCounter > 10) {
                spritNum++;
                if (spritNum > 11) {
                    spritNum = 1;
                }
                spritCounter = 0;
            }
        }

    }
    public void draw(Graphics g2){

//        g2.setColor( Color.WHITE);
//        g2.fillRect(x,y,gp.tamanioTitulo, gp.tamanioTitulo);


        BufferedImage image = null;

        switch (direction){
            case "up":

                if ( spritNum == 1 ){
                    image = up1;
                }
                if ( spritNum == 2 ){
                    image = up2;
                }
                if ( spritNum == 3 ){
                    image = up3;
                }
                if ( spritNum == 4 ){
                    image = up4;
                }
                if ( spritNum == 5 ){
                    image = up5;
                }
                if ( spritNum == 6 ){
                    image = up6;
                }
                if ( spritNum == 7 ){
                    image = up7;
                }
                if ( spritNum == 8 ){
                    image = up8;
                }
                if ( spritNum == 9 ){
                    image = up9;
                }
                if ( spritNum == 10 ){
                    image = up10;
                }
                if ( spritNum == 11 ){
                    image = up11;
                }

                break;
            case "down":
                image = down1;
                break;
            case "left":
                if ( spritNum == 1 ){
                    image = left1;
                }
                if ( spritNum == 2 ){
                    image = left2;
                }
                if ( spritNum == 3 ){
                    image = left3;
                }
                if ( spritNum == 4 ){
                    image = left4;
                }
                if ( spritNum == 5 ){
                    image = left5;
                }
                if ( spritNum == 6 ){
                    image = left6;
                }
                if ( spritNum == 7 ){
                    image = left7;
                }
                if ( spritNum == 8 ){
                    image = left8;
                }
                if ( spritNum == 9 ){
                    image = left9;
                }
                if ( spritNum == 10 ){
                    image = left10;
                }
                if ( spritNum == 11 ){
                    image = left11;
                }
                break;
            case "right":
                image = right1;
                break;
        }
//        int scaledWidth = gp.tamanioTitulo * 2;  // Puedes ajustar el factor de escala según tus necesidades
//        int scaledHeight = gp.tamanioTitulo * 2; // Puedes ajustar el factor de escala según tus necesidades

        // Dibuja la imagen con el tamaño ajustado
        g2.drawImage(image, x, y, gp.tamanioTitulo, gp.tamanioTitulo, null);

    }

}
