package com.company;

import javax.swing.*;

public class GameMain extends JFrame {
    GamePanel GP;
    static final int Width = 800, Heigt = 600, locX=200, locY=80;
    public GameMain(){
        super("SnakeGame");
        GP = new GamePanel();
        this.setSize(Width,Heigt);
        this.setVisible(true);
        this.setLocation(locX,locY);
        add(GP);
        GP.requestFocus();

    }
    static GameMain GM;
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GM = new GameMain();
            }
        });

    }
}
