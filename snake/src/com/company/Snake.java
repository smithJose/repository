package com.company;

//import com.sun.prism.Graphics;
//import com.sun.prism.paint.Color;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Snake {
    private List<SnakeNode> nodeArrayList = new ArrayList<>();
    private int curDir = 3;
    private int size =10;

    public Snake(){
        nodeArrayList.add(new SnakeNode(350, 250, Color.BLACK));
    }
    List<SnakeNode> getNodeArrayList(){
        return nodeArrayList;
    }

    void draw(Graphics g){
        for(int i = 0; i< nodeArrayList.size(); i++){
            g.setColor(nodeArrayList.get(i).getColor());
            g.fillRect(nodeArrayList.get(i).getX(), nodeArrayList.get(i).getY(),size,size);
        }
    }
    SnakeNode getNewHead(){
        SnakeNode oldHead = nodeArrayList.get(0);
        int oldX = oldHead.getX();
        int oldY = oldHead.getY();
        int newX =0 ,newY =0 ;
        switch(curDir){
            case 0 :
                newX = GamePanel.GameLocX+(GamePanel.GameWidth+(oldX-size-GamePanel.GameLocX))%GamePanel.GameWidth;
                newY = oldY;
                break;
            case 1 :
                newY = GamePanel.GameLocY+(GamePanel.GameHeigh+(oldY+size-GamePanel.GameLocY))%GamePanel.GameHeigh;
                newX = oldX;
                break;
            case 2 :
                newX = GamePanel.GameLocX+(GamePanel.GameWidth+(oldX+size-GamePanel.GameLocX))%GamePanel.GameWidth;
                newY = oldY;
                break;
            case 3 :
                newY = GamePanel.GameLocY+(GamePanel.GameHeigh+(oldY-size-GamePanel.GameLocY))%GamePanel.GameHeigh;
                newX = oldX;
                break;
        }
        SnakeNode newHead = new SnakeNode(newX, newY, oldHead.getColor());
        return newHead;
    }
    void move(){

        for(int i = nodeArrayList.size()-1; i>0; i--){
            SnakeNode tempNode = nodeArrayList.get(i-1);
            nodeArrayList.set(i, new SnakeNode(tempNode.getX(),tempNode.getY(),nodeArrayList.get(i).getColor()));
        }
        nodeArrayList.set(0,getNewHead());
    }
    int getDir(){
        return curDir;
    }
    void changDir(int dir){
        curDir = dir;
    }
    boolean isEat(Food food){
        if(nodeArrayList.get(0).getX() == food.getX() && nodeArrayList.get(0).getY() ==food.getY())
            return true;
        return false;
    }
    void evolve(Food food){
        SnakeNode tailNode = nodeArrayList.get(nodeArrayList.size()-1);
//        Color color = new Color(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255));
        int newX=0,newY=0;
        int oldX = tailNode.getX(),oldY = tailNode.getY();
        switch(curDir){
            case 0 :
                newX = GamePanel.GameLocX+(GamePanel.GameWidth+(oldX-size-GamePanel.GameLocX))%GamePanel.GameWidth;
                newY = oldY;
                break;
            case 1 :
                newY = GamePanel.GameLocY+(GamePanel.GameHeigh+(oldY+size-GamePanel.GameLocY))%GamePanel.GameHeigh;
                newX = oldX;
                break;
            case 2 :
                newX = GamePanel.GameLocX+(GamePanel.GameWidth+(oldX+size-GamePanel.GameLocX))%GamePanel.GameWidth;
                newY = oldY;
                break;
            case 3 :
                newY = GamePanel.GameLocY+(GamePanel.GameHeigh+(oldY-size-GamePanel.GameLocY))%GamePanel.GameHeigh;
                newX = oldX;
                break;

        }
        nodeArrayList.add(new SnakeNode(newX,newY,food.getColor()));

    }


}
