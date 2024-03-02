package main;

import entity.Player;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class Lienzo extends JPanel implements Runnable{

    //Configuracion de pantalla

    final int tamanioTituloOriginal = 16;
    final int escala = 3;

    public final int tamanioTitulo = tamanioTituloOriginal * escala; // 48*48 titulo
    final int maxScreenCol = 16;
    final int getMaxScreenRow = 12;
    final int screenWithd = tamanioTitulo * maxScreenCol; //768 pixel
    final int screenHeight = tamanioTitulo * getMaxScreenRow; //576 pixel

    //fps
    int FPS = 60;

    TileManager tilM = new TileManager ( this );
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    Player player = new Player ( this,keyH );

    // set
    int jugadorX = 100;
    int jugadorY = 100;
    int jugadorSpeed = 4;


    public Lienzo(){
        this.setPreferredSize(new Dimension(screenWithd,screenHeight));
        this.setBackground(Color.RED);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }


    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawIntervalo = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawIntervalo;

        while(gameThread != null){
            System.out.println("Esta corriendo");

            update();
            repaint();


            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if(remainingTime < 0){
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawIntervalo;

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void update(){

        player.update ();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        tilM.draw ( g2 );

        player.draw (g2);

        g2.dispose();
    }
}