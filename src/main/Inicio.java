package main;

import javax.swing.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Inicio{
    public static void main(String[] args) {

        JFrame ventana = new JFrame("Zelda");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);

        Lienzo lienzo = new Lienzo ();
        ventana.add(lienzo);

        ventana.pack();

        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);

        lienzo.startGameThread();

    }
}