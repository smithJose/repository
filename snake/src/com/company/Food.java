package com.company;

import java.awt.*;
import java.util.Random;

public class Food {
    private int x;
    private int y;
    private Color color;
    public Food(Snake snake){
        int testX =0,testY =0;
        boolean flag =true;
        while(flag){
             testX = new Random().nextInt(GamePanel.GameWidth/10)*10+GamePanel.GameLocX;
             testY = new Random().nextInt(GamePanel.GameHeigh/10)*10+GamePanel.GameLocY;
             flag = false;
            for(SnakeNode node:snake.getNodeArrayList()){
                if(testX == node.getX() && testY == node.getY()){
                    flag = true;
                    break;
                }

            }
        }

        this.setX(testX);
        this.setY(testY);
        this.setColor(new Color(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255)));
    }
    void draw(Graphics g){
        g.setColor(this.getColor());
        g.fillRect(this.getX(),this.getY(),10,10);
    }
    public Food(int x,int y ,Color color){
        this.setX(x);
        this.setY(y);
        this.setColor(color);
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
